package com.atguigu.java2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 *
 * 创建线程的方式三：实现callable接口   -->jdk5.0新增
 *  步骤：
 *  1、创建一个实现callable接口的类
 *  2、实现call（），将此线程需要执行的方法放到call（）中
 *  3、创建callable接口实现类的对象
 *  4、将此Callable接口实现类的对象传递到FutureTask构造器中，创建FutureTask的对象
 *  5、将FutureTask的对象作为参数传递到Thread类的构造器中，创建Thread对象，并调用start
 *  6、获取Callable中call方法的返回值
 *
 *
 *  如何理解实现Runnable接口的方式创建多线程比实现Runnable接口创建多线程方式强大
 *  1、call()方法是可以有返回值的
 *  2、call()可以抛出异常，将，被外面的操作补货，获取异常的信息
 *  3、Callable是支持泛型的
 *
 * @author pqq
 * @create ${year}-05-31 17:00
 */
class NumThread implements Callable{

    @Override
    public Object call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 100; i++) {
            if(i%2==0) {
                System.out.println(i);
                sum+=i;
            }

        }
        return sum;
    }
}

public class ThreadNew {
    public static void main(String[] args) {
        NumThread numThread = new NumThread();

        FutureTask<Integer> futureTask = new FutureTask<Integer>(numThread);

        new Thread(futureTask).start();
        try {
            //get()返回值为FutureTask构造器参数Callable实现类重写的call()的返回值
            Integer sum = futureTask.get();
            System.out.println("总和为"+sum);

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
