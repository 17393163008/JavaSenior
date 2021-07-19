package com.atguigu.java;

import org.junit.Test;

/**
 * 关于StringBuffer和StringBuilder的使用
 *
 * 对比String、StringBuffer、StringBuilder三者的效率：
 * 从高到低排列：StringBuilder > StringBuffer > String
 *
 * @author pqq
 * @create ${year}-06-09 17:20
 */
public class StringBufferBuilder {
    /*
    String、StringBuffer、StringBuilder三者的异同？
    String：不可变的字符序列
    StringBuffer：可变的字符序列：线程安全，效率偏低，底层使用char[]存储
    StringBuilder：可变的字符序列：jdk5.0新增，线程不安全，效率高，底层使用char[]存储

    源码分析：
    String str = new String();   //new char[0]
    String str1 = new String("abc");    //new char[]{'a','b','c'};

    StringBuffer sb1 = new StringBuffer(); //char[] value = new char[16]; 底层创建了一个长度为16的字符数组
    sb1.append('a');   //value[0]='a';
    sb1.append('b');   //value[1]='b';

    StringBuffer sb2 = new StringBuffer("abc"); //char[] value = new char["abc".length()+16];
    //问题一：System.out.println(sb2.length());   //3
    //问题二：扩容问题：如果添加的数据底层数组盛不下了，那就需要扩容底层数组
             默认情况下。扩容为原来容量的2倍+2，同时将原有数组中的元素复制到新的数组中。

             指导意义：开发中建议使用：StringBuffer(int capacity)或StringBuilder(int capacity)
                        指定容量，防止之后再次进行扩容
     */


    @Test
    public void test1(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.setCharAt(0,'m');
        System.out.println(sb1);

        StringBuffer sb2 = new StringBuffer();
        System.out.println(sb2.length());
    }


    /*
    String Buffer的常用方法：

    总结：
    增删改查、遍历
     */

    @Test
    public void test2(){
        StringBuffer sb1 = new StringBuffer("abc");
        sb1.append(1);
        sb1.append('1');
        System.out.println(sb1);
//        sb1.delete(2,4);    //左闭右开
        sb1.replace(2,4,"hello");
        System.out.println(sb1);

        sb1.insert(2,false);
        System.out.println(sb1);
        sb1.reverse();
        System.out.println(sb1);
        String s2 = sb1.substring(1, 3);
        System.out.println(sb1);
        System.out.println(s2.length());
        System.out.println(s2);

    }


}

