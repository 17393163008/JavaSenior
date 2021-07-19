package com.atguigu.java;

import org.junit.Test;

/**
 * @author pqq
 * @create ${year}-06-01 19:21
 */
public class StringMethodTest {

    @Test
    public void test1(){
        String s1 = "HelloWorld";
        System.out.println(s1.length());
        System.out.println(s1.charAt(0));
        System.out.println(s1.charAt(9));

        System.out.println(s1.isEmpty());

        String s2 = s1.toLowerCase();
        System.out.println(s1);  //s1不可变的，仍然为原来的字符串
        System.out.println(s2);  //改成小写以后的字符串

        String s3 = " he llo world  ";
        String s4 = s3.trim();
        System.out.println("-----" + s3 + "------");
        System.out.println("-----" + s4 + "------");

    }

    @Test
    public void test2(){
        String s1 = "HelloWorld";
        String s2 = "helloWorld";
        System.out.println(s1.equals(s2));
        System.out.println(s1.equalsIgnoreCase(s2));

        String s3 = "abc";
        String s4 = s3.concat("def");
        System.out.println(s4);

        String s5 = "abc";
        String s6 = new String("abc");
        System.out.println(s5.compareTo(s6));  //涉及到字符串排序

        String s7 = "北京尚硅谷教育";
        System.out.println(s7.substring(2));
        String sub1 = s7.substring(2,5);
        System.out.println(sub1);

    }

    @Test
    public void test3(){
        String str1 = "helloworld";
        boolean b1 = str1.endsWith("ld");
        System.out.println(b1);

        boolean b2 = str1.startsWith("He");
        System.out.println(b2);

        boolean b3 = str1.startsWith("ll", 2);

        String str2 = "wor";
        System.out.println(str1.contains(str2));

        System.out.println(str1.indexOf("lol"));

        System.out.println(str1.indexOf("lo", 2));

        String str3 = "helloworld";

        System.out.println(str3.lastIndexOf("or"));
    }

    @Test
    public void test4(){
        String str1 = "北京尚硅谷教育北京";
        String str2 = str1.replace("北","东");

        System.out.println(str1);
        System.out.println(str2);

        String str3 = str1.replace("北京","上海");
        System.out.println(str3);

        System.out.println("************");
        String str = "12hello34world5java7891mysql46";

        //把字符串中的数字替换成，，如果结果和开头有，直接去掉
        String string = str.replace("\\d+",",");
        System.out.println(string);

        System.out.println("*********************");
        str = "12345";
        //判断str字符串中是否全部由数字组成，即有1-n个数字组成
        boolean matches = str.matches("\\d+");
        String tel = "0571-4534289";
        //判断这是否是杭州的一个固定号码
        boolean result = tel.matches("0571-\\d{7,8}");
        System.out.println(result);


        System.out.println("***********************");
        str = "hello|world|java";
        String[] strs = str.split("\\|");
        for (int i = 0; i < strs.length; i++) {
            System.out.println(strs[i]);

        }

        System.out.println();
        str2 = "hello.world.java";
        String[] strs2 = str2.split("\\.");
        for (int i = 0; i < strs2.length; i++) {
            System.out.println(strs2[i]);

        }


    }
}
