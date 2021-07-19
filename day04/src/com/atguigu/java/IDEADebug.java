package com.atguigu.java;

import org.junit.Test;

/**
 * @author pqq
 * @create ${year}-06-10 9:03
 */
public class IDEADebug {
    @Test
    public void testStringBuffer(){
        String str = null;
        StringBuffer sb = new StringBuffer();
        sb.append(str);
        System.out.println(sb.length());  //sb

        System.out.println(sb);  //"null"
        StringBuffer sb1 = new StringBuffer(str);  //抛异常
        System.out.println(sb1);
    }
}
