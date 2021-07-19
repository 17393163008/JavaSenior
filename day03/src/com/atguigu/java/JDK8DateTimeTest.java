package com.atguigu.java;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.TemporalAccessor;
import java.util.Date;

/**
 * jdk 8中日期时间api的测试
 *
 * @author pqq
 * @create ${year}-06-13 13:20
 */
public class JDK8DateTimeTest {
    @Test
    public void test(){

        //偏移量
        Date date1 = new Date(2020, 9, 8);
        System.out.println(date1); //Fri Oct 08 00:00:00 CST 3920

    }

    /*
    LocalDate、LocalTime、LocalDateTime的使用
    说明：
        1、LocalDateTime的使用相较于LocalDate、LocalTime频率要高
        2、类似于Calendar

     */
    @Test
    public void test1(){
        //获取当前的日期、时间、日期+时间

        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);

        //of（）：设置指定的年月日时分秒，没有偏移量
        LocalDateTime localDateTime1 = LocalDateTime.of(2020, 10, 6, 22, 13, 13);
        System.out.println(localDateTime1);

        //getXxx()：获取相关的属性
        System.out.println(localDateTime.getDayOfMonth());
        System.out.println(localDateTime.getDayOfWeek());
        System.out.println(localDateTime.getMonth());
        System.out.println(localDateTime.getMonthValue());
        System.out.println(localDateTime.getMinute());

        //体现不可变性
        //withXXX:设置相关的属性
        LocalDate localDate1 = localDate.withDayOfMonth(22);
        System.out.println(localDate);
        System.out.println(localDate1);

        LocalDateTime localDateTime2 = localDateTime.withHour(4);
        System.out.println(localDateTime);
        System.out.println(localDateTime2);

        //不可变性
        LocalDateTime localDateTime3 = localDateTime.plusMonths(3);
        System.out.println(localDateTime3);

        LocalDateTime localDateTime4 = localDateTime.minusDays(6);
        System.out.println(localDateTime4);

    }

    /*
    Instant的使用
    类似于java.util.Date类
     */
    @Test
    public void test2(){
        //now():获取本初子午线对应的标准时间
        Instant instant = Instant.now();
        System.out.println(instant);  //2021-06-13T05:48:17.743Z

        //添加时间的偏移量
        OffsetDateTime offsetDateTime = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(offsetDateTime);  //2021-06-13T13:52:34.293+08:00

        //获取自1970年1月1日0时0分0秒（UTC）开始的毫秒数
        long milli = instant.toEpochMilli();
        System.out.println(milli);

        //ofEpochMilli():通过给定的毫秒数计算、获取一个Instance实例  --> Date类的getTime()
        Instant instant1 = Instant.ofEpochMilli(1556565465L);
        System.out.println(instant1);
    }


    /*
    DateTimeFormatter：格式化或解析日期、时间，
    类似于SimpleDateFormat
     */

    @Test
    public void test3(){

        //方式一：预定义的标准格式：如：ISO_LOCAL_DATE_TIME
        DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
        //格式化：日期-->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String str1 = formatter.format(localDateTime);
        System.out.println(localDateTime);
        System.out.println(str1);

        //解析：字符串-->日期
        TemporalAccessor parse = formatter.parse("2019-02-18T15:42:18.797");
        System.out.println(parse);


        //方式二：本地化相关的模式。如：ofLocalizedDateTime(FormatStyle.LONG)
        DateTimeFormatter formatter1 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
        //格式化
        String str2 = formatter1.format(localDateTime);
        System.out.println(str2);

        DateTimeFormatter formatter2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
        String str3 = formatter2.format(LocalDate.now());
        System.out.println(str3);

        //重点：方式三：自定义的格式：如，ofPattern("yyyy-MM-dd hh:mm:ss E)
        DateTimeFormatter formatter3 = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");
        //格式化
        String str4 = formatter3.format(LocalDateTime.now());
        System.out.println(str4); //2021-06-13 05:48:05

        //解析
        TemporalAccessor parse1 = formatter3.parse("2021-06-13 05:48:05");
        System.out.println(parse1);


    }
}
