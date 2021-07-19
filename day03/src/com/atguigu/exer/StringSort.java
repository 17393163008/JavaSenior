package com.atguigu.exer;

import java.util.Arrays;

/**
 * @author pqq
 * @create ${year}-06-02 19:00
 */
public class StringSort {
    public static void main(String[] args) {
        String s="helsdfjkshf";
        String result = getSort(s);
        System.out.println(result);
    }

    public static String getSort(String str){
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        String str1 = new String(chars);
        return str1;
    }
}
