package com.atguigu.java;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * JDK 8之前日期和时间的API测试
 *
 * @author pqq
 * @create ${year}-06-09 20:18
 */
public class DataTimeTesr {
    //1、System类中的currentTimeMillis()
    @Test
    public void test1(){
        long time = System.currentTimeMillis();
        //返回当前时间与1970年0时0分0秒之间以毫秒为单位的时间差
        //称为时间戳
        System.out.println(time);
    }

    /*
    java.util.Data类
      1.两个构造器的使用

      2.两个方法的使用
        toString():显示当前的  年月日时分秒
        getTime()：获取当前Date对象对应的毫秒数（时间戳）
     */
    @Test
    public void test2(){
        //构造器一：Data()：创建一个对应当前时间的Date对象
        Date date1 = new Date();
        System.out.println(date1.toString());

        System.out.println(date1.getTime());

        //构造器二:创建指定毫秒数的Date对象
        Date date2 = new Date(155030620410L);
        System.out.println(date2.toString());

        //创建java.sql.Date对象
        java.sql.Date date3 = new java.sql.Date(35235325345L);
        System.out.println(date3);

        //如何将java.util.Date对象转换为java.sql.Date对象
        //情况一：
//        java.sql.Date date4 = new java.sql.Date(234324324232L);
//        java.sql.Date date5 = (java.sql.Date)date4;
        //情况二
        Date date6 = new Date();
        java.sql.Date date7 = (java.sql.Date)date6;


    }

    /*
    练习一：字符串“2020-09-08”转换为java.sql.Date

    练习二：“三天打鱼，两天晒网”  1990-01-01 xxxx-xx-xx 打鱼？晒网？

    举例：2020-09-08 ？ 总天数

    总天数 % 5 == 1,2,3：打鱼
    总天数 % 5 == 4,0：晒网

    总天数的计算？
    方式一：(date2.getTime - date1.getTime()) / (1000*60*60*24)
    方式二：1990-01-01  --> 2019-12-31 + 2020 - 01 - 01 --> 2020-09-
     */

    @Test
    public void testExer() throws ParseException {
        String birth = "2020-09-08";

        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date = sdf1.parse(birth);

        java.sql.Date birthDate = new java.sql.Date(date.getTime());
        System.out.println(birthDate);
    }

    /*
    Calendar日历类（抽象类）的使用
     */
    @Test
    public void testCalendar(){
        //1、实例化
        //方式一：创建其子类（GregorianCalendar）的对象
        //方式二：调用其静态方法getInstance（）
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        //2.常用方法
        //get()
        int days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set()
        calendar.set(Calendar.DAY_OF_MONTH,22);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //add()
        calendar.add(Calendar.DAY_OF_MONTH,-3);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);

        //getTime():日历类 --> Date
        Date date = calendar.getTime();
        System.out.println(date);

        //setTime()
        Date date1 = new Date();
        calendar.setTime(date1);
        days = calendar.get(Calendar.DAY_OF_MONTH);
        System.out.println(days);
    }



}
