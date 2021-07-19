package com.atguigu.java;

/**
 * 使用同步方法来处理继承Thread类的方式中的线程安全问题
 *
 * 关于同步方法的总结：
 * 1、同步方法仍然涉及到同步监视器，只是不需要我们显式的声明
 * 2、非静态的同步方法，同步监视器是：thsi
 *    静态的同步方法，同步的监视器是：当前类本身
 * @author pqq
 * @create ${year}-05-27 17:12
 */
class Window4 extends Thread{

    private static int ticket = 100;
    @Override
    public void run() {
        while (true){
            show();
        }
    }

    private static synchronized void show(){  //同步监视器：Window4.class
        //private static synchronized void show()  //同步监视器t1,t2,t3,此种解决办法是错误的,
        if(ticket > 0){


            System.out.println(Thread.currentThread().getName() + "卖票，票号："+ticket);
            ticket--;
        }
    }
}

public class WindowTest4 {

    public static void main(String[] args) {

        Window4 t1 = new Window4();
        Window4 t2 = new Window4();
        Window4 t3 = new Window4();

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();

    }

}
