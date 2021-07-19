package com.atguigu.java1;

import java.io.Serializable;

/**
 * @author pqq
 * @create ${year}-06-20 12:58
 */
public class Creatrue<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃东西！");
    }



}
