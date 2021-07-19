package com.atguigu.exer;

import org.junit.Test;

/**
 * @author pqq
 * @create ${year}-06-02 18:06
 */
public class StringTest1 {
    
    //方法一
    public String reverse(String str,int beginIndex, int endIndex){
        if(str!=null){
            char[] chars = str.toCharArray();
            for (int i = beginIndex, j = endIndex; i < j; i++,j--) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
            }
            return new String(chars);
        }
        return null;
    }
    
    @Test
    public void test1(){
        StringTest1 t1 = new StringTest1();
        String str = "abcdefg";

        String s = t1.reverse(str,2,5);
        System.out.println(s);
    }
}
