package com.atguigu.exer;

/**
 * @author pqq
 * @create ${year}-06-02 18:42
 */
public class StringTest {

    public static void main(String[] args) {
        System.out.println(text("asdafghjka","aaasdfg"));
    }

    public static String text(String str1, String str2){
        String max = "";
        String min = "";

        max = (str1.length()>str2.length())?str1:str2;
        min = (max == str1)?str2:str1;

        for (int i = 0; i < min.length(); i++) {
            for(int j = 0,k = min.length()-i; k != min.length()+1; j++, k++){
                String temp = min.substring(j,k);

                if(max.contains(temp)){
                    return temp;
                }
            }


        }
        return null;
    }

}

