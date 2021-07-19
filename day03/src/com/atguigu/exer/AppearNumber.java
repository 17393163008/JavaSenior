package com.atguigu.exer;

/**
 * @author pqq
 * @create ${year}-06-02 18:18
 */
public class AppearNumber {

    public static int count(String str1, String str2){
        int count = 0;
        int i = 0;
        while(str1.contains(str2)){
            count++;
            i = str1.indexOf(str2);
            str1 = str1.substring(i+str2.length());   //将出现过该字符串的片段截取掉
        }
        return count;
    }
    public static void main(String[] args) {
        String str1 = "abkkcadkabkebfkabkskab";
        String str2 = "ab";

        System.out.println(count(str1, str2));
    }

}

