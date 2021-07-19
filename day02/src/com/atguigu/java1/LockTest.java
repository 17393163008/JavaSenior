package com.atguigu.java1;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 解决线程安全问题的方式三：Lock锁  ---
 * 1.面试题：synchronized和Lock的异同
 *      同：都可以解决线程的安全问题
 *      异：synchronized机制在执行完相应的同步代码后，自动释放同步监视器，Lock需要手动启动同步（lock（）），同时结束同步也需要手动释放（unlock（））
 * 2、优先使用顺序：Lock ->同步代码块（已经进入方法体，分配了相应资源） -> 同步方法（在方法体之外）
 * @author pqq
 * @create ${year}-05-27 18:29
 */
public class LockTest {
    public static void main(String[] args) {
        Window w1 = new Window();

        Thread t1 = new Thread(w1);
        Thread t2 = new Thread(w1);
        Thread t3 = new Thread(w1);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();
    }
}

class Window implements Runnable{

    private int ticket = 1000;

    //1、实例化
    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {
        while (true){

            try {
                //2、调用锁定方法
                lock.lock();
                if(ticket > 0){

                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+": 售票，票号为："+ticket);
                    ticket--;
                }else{
                    break;
                }
            } finally {
                //3、调用解锁方法
                lock.unlock();
            }


        }
    }
}
