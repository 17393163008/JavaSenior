package com.atguigu.java1;


import com.atguigu.java.Person;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * 1、Set接口的框架：
 *
 * |----Collection接口:单列集合，用来存储一个一个的对象
 *  *     |---Set接口：存储无序的、不可重复的数据。  --> 高中讲的“集合”
 *            |---HashSet：作为Set接口的主要实现类，线程不安全的，可以存储null值
 *                  |---LinkedHashSet：作为HashSet的子类；遍历内部数据时，可以按照添加的顺序遍历
 *                      对于频繁的遍历操作，LinkedHashSet效率高于HashSet
 *            |---TreeSet：可以按照添加对象指定属性，进行排序
 *
 *  1、Set接口中没有额外定义新的方法，使用的都是Collection中声明过的方法。
 *
 *  2、要求：向Set中添加的数据，其所在的类一定要重写hashCode（）和equal（）
 *     要求：重写的hashCode（）和equals（）尽可能保持一致性。
 *
 *
 * @author pqq
 * @create ${year}-06-15 14:44
 */
public class SetTest {
    /*
    Set：存储无序的、不可重复的数据
    1、无序性：不等于随机性。存储的数据在底层数组中并非按照数组索引的顺序添加。而是根据数据的哈希值决定

    2、不可重复性：保证添加的方法按照equals判断时，不能返回true。即相同的元素只能添加一个。

    二、添加元素的过程：以HashSet为例：
        我们像HashSet中添加元素a，首先调用a所在类的()方法，计算元素a的哈希值
        此哈希值接着通过某种算法计算出HashSet在底层数组中的存放位置（即为：索引位置），
        判断数组此位置上是否已经有元素：
        如果此位置上没有其他元素，则a添加成功，   -->情况一
        如果此位置上有其他元素b（或以链表形式存在多个元素），则比较元素a与元素b的hash值
            如果hash值不相同，则元素a添加成功    -->情况二
            如果hash值相同，进而需要调用元素所在类的equals()方法，
                equals（）返回true，则元素a添加失败
                equals（）返回false，则元素a添加成功。  -->情况三

        对于添加成功的情况2和情况3而言：元素a与已经存在指定位置上的数据以链表的形式存储，
        jdk7：元素a放到数组中，指向原来的元素。
        jdk8：原来的元素在数组中，指向元素a
        总结：七上八下





     */

    @Test
    public void test1(){
        HashSet set = new HashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    //LinkedHashSet的使用
    //LinkedHashSet作为HashSet的子类，在添加数据的同时，每个数据还维护了两个引用，记录此数据前一个
    //数据和后一个数据。
    //优点：对于频繁的遍历操作，LinkedHashSet效率高于HashSet
    @Test
    public void test2(){
        HashSet set = new LinkedHashSet();
        set.add(123);
        set.add(123);
        set.add(456);
        set.add("AA");
        set.add("CC");
        set.add(new Person("Tom",12));
        set.add(new User("Tom",12));
        set.add(new User("Tom",12));

        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
