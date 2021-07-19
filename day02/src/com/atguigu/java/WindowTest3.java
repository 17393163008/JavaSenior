package com.atguigu.java;

/**
 * 使用同步方法实现Runnable接口
 *
 * @author pqq
 * @create ${year}-05-27 16:56
 */
public class WindowTest3 {
    public static void main(String[] args) {
        Window3 w1 = new Window3();


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

class Window3 implements Runnable{
    private static int ticket = 1000;
    private static Object obj =  new Object();


    @Override
    public void run() {
        while(true) {
            show();
        }
    }

    private synchronized void show(){
        if (ticket > 0) {
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
            ticket--;
        }
    }
}