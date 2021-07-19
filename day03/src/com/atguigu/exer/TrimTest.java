package com.atguigu.exer;

/**
 * @author pqq
 * @create ${year}-06-02 17:33
 */
public class TrimTest {

    public static void main(String[] args) {
        String str = "   abc   ";
        String str1 = "     ";
        TrimTest t1 = new TrimTest();
        System.out.println(t1.myTrim(str));
        System.out.println(t1.myTrim(str1));
        System.out.println(" a");

    }

    public String myTrim(String str){
        if(str != null){
            int start = 0;
            int end = str.length()-1;

            while(start < end && str.charAt(start) == ' '){
                start++;
            }

            while(start < end && str.charAt(end) == ' '){
                end--;
            }

            if(str.charAt(start)==' '){
                return "";
            }
            return  str.substring(start,end+1);
        }
        return null;
    }



}


