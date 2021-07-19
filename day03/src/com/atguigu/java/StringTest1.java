package com.atguigu.java;

import org.junit.Test;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

/**
 * 涉及到String类及其他结构之间的转换
 *
 * @author pqq
 * @create ${year}-06-02 11:50
 */
public class StringTest1 {
    /*
    String与byte[]之间的转换
    String  --> char[]:调用String的getBytes()

    编码：字符串 ---> 字节（看得懂  --->  看不懂的二进制数据）
    解码：编码的逆过程，字节 --> 字符串 (看不懂的二进制串 --> 看得懂)
     */
    @Test
    public void test3() throws UnsupportedEncodingException {
        String str1 = "abc123";
        byte[] bytes = str1.getBytes();  //使用默认的字符集进行转换
        System.out.println(Arrays.toString(bytes));

        byte[] gbks = str1.getBytes("gbk");
        System.out.println(Arrays.toString(gbks));
    }


    /*
    String 与 char[]之间的转换

    String --> char[]:调用String的toCharArray()
    char[]   -->  String : 调用String的构造器
     */

    @Test
    public void test2(){
        String str1 = "abc123";

        char[] charArray = str1.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            System.out.println(charArray[i]);

        }

        char[] arr = new char[]{'h', 'e', 'l', 'l', 'o'};
        String str2 = new String(arr);
        System.out.println(str2);

    }


    /*
    复习
    String和基本数据类型包装类的转换

    String --> 基本数据类型、包装类：调用包装的静态方法：parseXxx(str)
    基本数据类型、包装类   -->  String:调用String重载的ValueOf（xxx）
     */

    @Test
    public void test1(){
        String str1 = "123";
//        int num = (int)str1;    错误的使用方法
        int num = Integer.parseInt(str1);

        String str2 = String.valueOf(num);   //"123"
        String str3 = num + "";

        System.out.println(str1==str2);

        System.out.println(str1 == str3);
    }
}
