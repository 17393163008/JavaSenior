package com.atguigu.exer;

/**
 * 测试Thread类中的常用方法
 * 1、start启用当前线程，调用当前线程的run（）
 * 2、run（）：通常将重写Thread类的此方法，将创建新城需要执行的操作声明在此方法中
 * 3、currentThread():静态方法，返回执行当前代码的线程
 * 4、getName（）：获取当前线程的名字
 * 5、setName（）：设置当前线程的名字
 * 6、yield（）：释放当前cpu的执行权
 * 7、
 *
 * @author pqq
 * @create ${year}-05-26 20:40
 */
public class ThreadMethodTest {
    public static void main(String[] args) {
        HelloThread h1 = new HelloThread("xiancheng1");
//        h1.setName("线程一");

        h1.setPriority(Thread.MAX_PRIORITY);
        h1.start();

        Thread.currentThread().setName("主线程");
        Thread.currentThread().setPriority(Thread.MIN_PRIORITY);
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName() + ":" + i);
            }

        }
    }
}

class HelloThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i % 2 == 0){
                System.out.println(Thread.currentThread().getName() + ":"+i);
            }

        }
    }

    public HelloThread(String name){
        super(name);
    }
}
