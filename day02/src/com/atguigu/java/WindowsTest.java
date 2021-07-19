package com.atguigu.java;

/**
 * @author pqq
 * @create ${year}-05-27 8:34
 */
public class WindowsTest {
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
    private static int ticket = 1000;
    private static Object obj =  new Object();


    @Override
    public void run() {
        while(true) {
            synchronized (Window.class) {
                if (ticket > 0) {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName() + ":卖票，票号为：" + ticket);
                    ticket--;
                } else {
                    break;
                }
            }
        }
    }
}