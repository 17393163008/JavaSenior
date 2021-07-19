package com.atguigu.java1;

/**
 * @author pqq
 * @create ${year}-05-27 17:32
 */
public class BankTest {
}

class Bank{
    private Bank(){

    }

    private static Bank instance = null;

    //一、处理方法一：同步方法（静态方法的锁是当前类本身）
    //    与下面的处理方法二中的方式1一样，效率不高
//    public synchronized static Bank getInstance(){
//        if (instance == null) {
//            instance = new Bank();
//
//        }
//        return instance;
//    }

    //处理方法二：同步代码块
    public static Bank getInstance(){

        //方式1：效率较差
//        synchronized(Bank.class) {
//            if (instance == null) {
//                instance = new Bank();
//
//            }
//            return instance;
//        }

        //方式2：效率更高
        if(instance == null) {
            synchronized (Bank.class) {
                if (instance == null) {
                    instance = new Bank();

                }
            }
        }
        return instance;
    }
}