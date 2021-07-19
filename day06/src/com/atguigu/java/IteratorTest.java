package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * 集合元素的遍历操作，使用迭代器Iterator接口
 * 1、内部的方法：hasNext()和next()
 * 2、集合对象每次调用Iterator()方法都得到一个全新的迭代器对象
 *    默认游标都在集合的一个元素之前
 * 3、内部定义一个remove()，就可以遍历的时候，删除集合中的元素。此方法不同意集合直接调用remove()
 *
 * @author pqq
 * @create ${year}-06-14 23:17
 */
public class IteratorTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);


        Iterator iterator = coll.iterator();
        //方式一
        //        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());

        //方式二:不推荐
//        for (int i = 0; i < coll.size(); i++) {
//            System.out.println(iterator.next());
//
//        }

        //方式三：推荐
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    @Test
    public void test2(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        Iterator iterator = coll.iterator();

        //错误方式一：
//        while(iterator.next()!=null){
//            System.out.println(iterator.next());
//        }

        //错误方式二
        while(coll.iterator().hasNext()){
            System.out.println(coll.iterator().next());
        }
    }

    //测试Iterator中的remove()
    //如果还未调用next()或在上一次调用next方法之后已经调用了remove方法
    //再次调用remove都会报错IllegalStateException
    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        //删除集合中的“Tom”

        Iterator iterator = coll.iterator();
        while(iterator.hasNext()){
            Object obj = iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }
        }

        //遍历集合
        iterator = coll.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
