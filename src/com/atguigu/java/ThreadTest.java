package com.atguigu.java;

/**
 * 多线程的创建，方式一：继承于thread类
 * 1、创建一个继承于thread类的子类
 * 2、重写Thread类的run（）   -->将此线程执行的操作放在run（）中
 * 3、创建Thread类的子类的对象
 * 4、通过此对象调用start（）
 *
 * @author pqq
 * @create ${year}-05-26 19:50
 */
//1、创建一个继承于thread类的子类
class MyThread extends Thread{

    //2、重写Thread类的run（）
    @Override
    public void run() {
        for(int i = 0; i < 100; i++){
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i);
            }
        }
    }
}

public class ThreadTest {

    public static void main(String[] args) {
        //3、创建Thread类的子类的对象
        MyThread t1 = new MyThread();
        MyThread t2 = new MyThread();
        //4、通过此对象调用start（）
        t1.start();
        t2.start();
        //如下操作依然是在main线程中执行的
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+i + "***main()***");
            }
        }
    }

}
