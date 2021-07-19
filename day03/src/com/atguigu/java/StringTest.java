package com.atguigu.java;

import org.junit.Test;

/**
 *
 * String的使用
 *
 *
 * @author pqq
 * @create ${year}-06-01 14:58
 */
public class StringTest {
    /*
    String:字符串，使用""引起来表示
    1、String是final的，不可以被继承
    2、String实现了Serializable接口，表示字符串是可以序列化的
             实现了Comparable接口，表示String可以比较大小
    3、String内部定义了final char[] value用于存储字符串数据
    4、String：代表不可变的字符序列。简称:不可变性。
        体现：1、当对字符串重新复制时，需要重新指定内存区域赋值，不能使用原有的value进行赋值
             2、当对现有的字符串进行连接操作时，也需要重新指定内存区域赋值
             3、当调用String的replace（）方法修改指定字符或者字符串时，不能在原有的value上赋值。
    5、通过字面量给一个字符串赋值，此时字符串值声明在字符串常量池中。
    6、字符串常量池中是不会存储相同内容的字符串的。

     */

    @Test
    public void test1(){
        String s1 = "abc";  //字面量
        String s2 = "abc";
        //s1 = "hello";

        System.out.println(s1 == s2);
        System.out.println(s1);
        System.out.println(s2);

        System.out.println("**********");
        String s4 = "abc";
        String s5 = s4.replace('a','m');
        System.out.println(s4);
        System.out.println(s5);

    }


    @Test
    public void test2(){
        //此时的s1和s2的数据javaEE声明在方法区的常量池内
        String s1 = "javaEE";
        String s2 = "javaEE";

        //通过new + 构造器的方式：此时的s3和s4保存的地址值，是数据在堆空间中开辟空间以后对应的地址值
        String s3 = new String("javaEE");
        String s4 = new String("javaEE");

        System.out.println(s1 == s2);
        System.out.println(s1 == s3);
        System.out.println(s1 == s4);
        System.out.println(s3 == s4);
    }

    /*

    结论：
    1、常量与常量拼接的结果仍在常量池中，且常量池不会存在相同的内容
    2、只有其中有一个是变量，结果接在堆中
    3、如果拼接的结果中调用intern方法，返回值就会在常量池中。
     */
    @Test
    public void test3(){
        String s1 = "javaee";
        String s2 = "hadoop";

        String s3 = "javaeehadoop";
        String s4 = s1+s2;
        String s5 = "javaee" + "hadoop";
        System.out.println(s1 == s2);
        System.out.println(s2 == s3);
        System.out.println(s4==s3);
        System.out.println(s5==s3);

        String s6 = s4.intern();  //返回值得到的s6使用的常量值中已经存在的“javaeehadoop”
        System.out.println(s6 == s3);
    }
}

