package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author pqq
 * @create ${year}-06-17 10:40
 */
public class CollectionsTest {
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);
        list.add(-97);
        list.add(0);

        System.out.println(list);

//        Collections.reverse(list);  //反转
//        System.out.println(list);
//        Collections.shuffle(list);  //随机排序，打乱顺序
//        System.out.println(list);
//
//        Collections.sort(list);
        Collections.swap(list,1,2);  //交换两个位置的元素
        int frequency = Collections.frequency(list, 765);  //返回指定元素的出现次数



        System.out.println(list);

    }

    @Test
    public void test2(){
        ArrayList list = new ArrayList();
        list.add(123);
        list.add(43);
        list.add(765);

        //报异常：indexOutOfBoundsException
//        List dest = new ArrayList();
//        Collections.copy(dest, list);

        //正确的
        List<Object> dest = Arrays.asList(new Object[list.size()]);
        System.out.println(dest.size());
        Collections.copy(dest, list);
        System.out.println(dest);
    }
}
