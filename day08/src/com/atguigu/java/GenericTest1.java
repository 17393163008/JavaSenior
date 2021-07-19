package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 * 1、关于自定义泛型类、泛型接口：
 *
 *
 * @author pqq
 * @create ${year}-06-17 16:46
 */
public class GenericTest1 {
    @Test
    public void test1(){
        //如果定义了泛型类，但是没有指明类的泛型，则认为此泛型为Object类型
        //要求：如果大家定义了类时带泛型的，建议在实例化时指明泛型的类型。
        Order order = new Order();
        order.setOrderT(123);
        order.setOrderT("AbC");

        //建议：实例化时指明类的泛型
        Order<String> order1 = new Order<String>("orderAAA",1001,"order:AA");
        order1.setOrderT("AA:hello");

    }

    @Test
    public void test2(){
        SubOrder subOrder = new SubOrder();
        //由于子类在继承父类时，指明了泛型类型，则实例化子类的时候不需要再指明泛型的类型。
        subOrder.setOrderT(1122);

    }

    @Test
    public void test3(){
        //泛型不同的引用不能相互赋值

        ArrayList<String> list1 = null;
        ArrayList<Integer> list2 = new ArrayList<>();

        //泛型不同的引用不能相互赋值
//        list1 = list2;


    }

    //静态方法不能使用类的泛型
//    public void show(T OrderT){
//        System.out.println(OrderT);
//
//    }

    //测试泛型方法
    @Test
    public void test4(){
        Order<String> order = new Order<>();
        Integer[] arr = new Integer[]{1,2,3,4};
        //泛型方法在调用时，指明泛型参数的类型
        List<Integer> list = order.copyFromArrayToList(arr);

        System.out.println(list);
    }
}
