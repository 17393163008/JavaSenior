package com.atguigu.java;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * 其他常用类的使用
 * 1、System
 * 2、Math
 * 3、BigInteger
 *
 * @author pqq
 * @create ${year}-06-14 6:45
 */
public class OtherClassTest {
    @Test
    public void test1(){
        String javaVersion = System.getProperty("java.version");
        System.out.println("java的version："+javaVersion);

        String javaHome = System.getProperty("java.home");
        System.out.println("java的Home："+javaHome);

        String osName = System.getProperty("os.name");
        System.out.println("os的name："+osName);

        String osVersion = System.getProperty("os.version");
        System.out.println("os的version："+osVersion);

        String username = System.getProperty("user.name");
        System.out.println("user.name："+username);


    }

    @Test
    public void test2(){
        BigInteger bi = new BigInteger("12433241123");
        BigDecimal bd = new BigDecimal("12453.351");
        BigDecimal bd2 = new BigDecimal("11");
        System.out.println(bi);
        System.out.println(bd.divide(bd2, BigDecimal.ROUND_HALF_UP));
        System.out.println(bd.divide(bd2,15,BigDecimal.ROUND_HALF_UP));

    }
}
