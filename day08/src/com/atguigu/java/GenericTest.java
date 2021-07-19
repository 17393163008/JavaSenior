package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 泛型的使用
 * 1、jdk5.0新增的特性
 *
 * 2、在集合中使用泛型：
 * 总结：
 *      ① 集合接口或集合类在jdk5.0时都修改为带泛型的结构。
 *      ② 在实例化集合类时，可以指明具体的泛型类型
 *      ③ 指明完以后，在集合类或借楼中凡是定义类或接口时，内部结构使用到类的泛型的位置，都指定为实例化时的泛型类型
 *          比如：add(E e)  --> 实例化以后：add(Integer e)
 *      ④ 注意点：泛型的类型必须是类，不能是基本数据类型
 *      ⑤ 如果实例化时没有指定泛型的类型。默认类型为java.lang.Object类型。
 *
 *  3、如何自定义泛型结构：泛型类、泛型接口、泛型方法
 *
 *
 *
 * @author pqq
 * @create ${year}-06-17 13:50
 */
public class GenericTest {
    //在集合中使用泛型之前的情况
    @Test
    public void test1(){
        ArrayList list = new ArrayList();
        //需求：存放学生的成绩
        list.add(78);
        list.add(79);
        list.add(88);
        list.add(98);

        //问题一：类型不安全
        list.add("Tom");
        for(Object score : list){
            //问题二：强转时，可能出现ClassCastException
            int studentScore = (Integer) score;
            System.out.println(studentScore);
        }

    }

    //在集合中使用泛型的情况：以ArrayList为例
    @Test
    public void test2(){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(78);
        list.add(79);
        list.add(88);
        list.add(98);

        //编译时，就会进行类型的检查，保证数据的安全
//        list.add("aa");

        //方式一
//        for(Integer score:list){
//            //避免了强转操作
//            int stuScore = score;
//            System.out.println(stuScore);
//        }

        //方式二
        Iterator<Integer> iterator = list.iterator();
        while(iterator.hasNext()){
            Integer next = iterator.next();
            System.out.println(next);
        }
    }


    //在集合中使用泛型的情况：以HashMap为例
    @Test
    public void test3(){
        HashMap<String, Integer> map = new HashMap<>();

        map.put("Tom",87);
        map.put("To",8);
        map.put("Tomm",187);
        map.put("om",7);

//        map.put(123,456);
        //泛型的嵌套
        Set<Map.Entry<String, Integer>> set = map.entrySet();
        Iterator<Map.Entry<String, Integer>> iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry<String, Integer> next = iterator.next();
            System.out.println(next);
        }
    }

}
