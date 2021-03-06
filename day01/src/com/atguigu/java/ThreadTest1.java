package com.atguigu.java;

/**
 * @author pqq
 * @create ${year}-05-27 9:02
 */
public class ThreadTest1 {
    public static void main(String[] args) {
        //3、创建实现类的对象
        MThread mThread = new MThread();

        //4、将此对象作为参数传递到Thread类的构造器中，创建Thread类的对象
        Thread t1 = new Thread(mThread);
        t1.setName("线程1");
        //5、通过Thread类的对象调用start:① 启动线程 ② 调用当前线程的run()-->调用了Runnable类型的target
        t1.start();

        //再启动一个线程，遍历100以内的偶数
        Thread t2 = new Thread(mThread);
        t2.setName("线程2");
        t2.start();
    }
}

//1、创建了一个实现了Runnable接口的类
class MThread implements Runnable{

    //2、实现类去实现Runnable中的抽象方法：run()
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}