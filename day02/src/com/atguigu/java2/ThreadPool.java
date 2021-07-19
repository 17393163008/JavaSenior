package com.atguigu.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * 创建线程的方式四：使用线程池
 *
 * 好处：
     >提高响应速度（减少了创建新线程的时间）
     >降低了资源消耗（重复利用线程池中的线程，不需要每次都创建）
     >便于线程管理


 *
 * @author pqq
 * @create ${year}-05-31 17:52
 */

class NumberThread implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 == 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

class NumberThread1 implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            if(i%2 != 0){
                System.out.println(Thread.currentThread().getName()+": "+i);
            }
        }
    }
}

public class ThreadPool {
    public static void main(String[] args) {

        //1、提供指定数量的线程池
        ExecutorService service = Executors.newFixedThreadPool(10);

        //设置线程池的属性
//        System.out.println(service.getClass());
        ThreadPoolExecutor service1 = (ThreadPoolExecutor)service;
        service1.setCorePoolSize(15);


        //2、执行指定线程的操作
        service.execute(new NumberThread());    //适合使用于Runnable
        service.execute(new NumberThread1());    //适合使用于Runnable
//        service.submit();     //适合使用于Callable

        //关闭连接池
        service.shutdown();
    }

}
