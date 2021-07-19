package com.atguigu.java;

import java.util.ArrayList;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-06-17 16:54
 */
public class SubOrder extends Order<Integer> {  //SubOrder不是泛型类
    public static <E> List<E> copyFromArrayToList(E[] arr){
        ArrayList<E> list = new ArrayList<>();
        for(E e: arr){
            list.add(e);
        }
        return list;

    }

}
