package com.atguigu.java2;

/**
 * 涉及到三个方法：
 * wait（）：一旦执行此方法，当前线程就进入阻塞状态，并释放同步监视器
 * notify（）：一旦此方法，就会唤醒被wait的一个线程，如果有多个线程被wait，就唤醒优先级高的那个
 * notifyAll（）：一旦执行此方法，就会唤醒所欲被wait的线程。
 *
 * 说明：
 * 1、wait（），notify（），notifyall（）必须使用在同步代码快或同步方法中
 * 2、wait（），notify（），notifyall（）三个方法的调用者必须是同步代码快或同步方法中的同步监视器
 *      否则，会出现java.lang.IllegalMonitorStateException异常
 * 3、这三个方法定义在java.lang.Object类中。
 *
 * 面试题：sleep()和wait()方法的异同：
 * 1、相同点：一旦执行该方法，都可以是当前线程进入阻塞状态
 * 2、不同点：
 *  （1）两个方法声明的位置不同，Thread类中声明sleep（），Object类中声明wait（）
 *  （2）调用的要求不同：sleep（）可以在任何需要的场景下调用，wait（）必须使用在同步代码快或同步方法中
 *  （3）关于是否释放同步件事器：如果两个方法都使用在同步代码快或同步方法中，sleep()不会释放锁，wait()会释放锁。
 *
 * @author pqq
 * @create ${year}-05-31 15:11
 */

class Number implements Runnable{
    private int number = 1;

    Object obj = new Object();
    @Override
    public void run() {
        while(true) {
            synchronized (this) {

                notify();

                if (number <= 100) {
                    System.out.println(Thread.currentThread().getName() + ":" + number);
                    number++;

                    try {

                        //使得调用wait（）方法的线程进入阻塞状态
                        wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }else{
                    break;
                }
            }
        }
    }
}

public class CommunicattionTest {
    public static void main(String[] args) {
        Number number = new Number();
        Thread t1 = new Thread(number);
        Thread t2 = new Thread(number);

        t1.setName("线程一");
        t2.setName("线程二");

        t1.start();
        t2.start();
    }
}
