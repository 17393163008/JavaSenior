package com.atguigu.java;

import org.junit.Test;

import java.util.*;

/**
 * 一、Map实现类的结构
 * |--Map：双列数据，存储key-value对的数据  --类似于高中的函数：y=f(x)
 *      |--HashMap：作为Map的主要实现类，线程不安全的，效率高，可以存储null的key和value
 *          |--LInkedHashMap:保证在遍历map元素时，可以按照添加的顺序实现遍历。
 *                  原因：在原有的HashMap底层结构基础上，添加了一对指针，指向前一个和后一个元素
 *                  适合频繁插入，删除
 *      |--TreeMap：保证按照添加的key-value对进行排序，实现排序遍历，此时考虑key的自然排序或者定制排序
 *                     底层使用红黑树
 *      |--Hashtable：作为古老的实现类：线程安全的，效率低，不可以存储null的key和value
 *          |--Properties：常用来处理配置文件，key和value都是String类型
 *
 *    HashMap的底层：数组+链表   （jdk7之前）
 *                  数组+链表+红黑树 （jdk8）
 *
 *    面试题
 *    1、HashMap的底层实现原理（重点、高频）？
 *
 *    2、HashMap和Hashtable的异同？
 *
 *    3、CurrentHashMap与Hashtable的异同：
 *
 *
 *   二、Map结构的理解
 *    Map中的key：无序的、不可重复的，使用Set存储所有的key  --> key所在的类要重写hashCode()和equals()方法
 *    Map中的Value：无序的、不可重复的，使用Collection存储所有的Value    -->value所在的类要重写equals()
 *    一个键值对，key-value构成了一个Entry对象
 *    Map中的entry：无序的、不可重复的，使用Set存储所有的entry
 *
 *   三、HashMap的底层实现原理：（以jdk7为例说明）
 *    HashMap map = new HashMap();
 *    在实例化之后，底层创建了长度为16的以为数组Entry[] table.
 *    ...可能已经执行过多次put...
 *    map.put(key1.value1);
 *    首先，调用key1所在类的hashCode（）机选key1的hash值，此哈希值通过某种那个算法计算以后，得到在Entry数组的存放位置
 *    如果此位置上的数据为空，此时的key1-value1添加成功  --情况一
 *    如果此位置上的数据不为空，（意味着此位置上存在一个或多个数据（以链表形式存在）。比较key1和已经存在的一个或多个数据的哈希值）
 *      如果key1的哈希值与已经存在的数据的哈希值都不相同，此刻key1-value1添加成功   --情况二
 *      如果key1的哈希值与已经存在的某一个数据的哈希值相同，继续比较：调用key1所咋的类的equals()方法
 *          如果equals()方法返回false，此时key1-value1添加成功   --情况三
 *          如果equals()方法返回true，使用value1替换value2。
 *
 *      补充：关于情况二和情况三，此时key1-value1和原来的数据以链表的形式存储。
 *
 *     在不断地添加过程中，会涉及到扩容过程，默认的扩容方式，扩容为原来数据的二倍，并将原来的数据复制过来
 *
 *     jdk8相较于jdk7在底层表现方面的不同：
 *     1、new HashMap();  底层没有创建一个长度为16的Entry数组
 *     2、jdk8底层的数组是：Node[],而非Entry[]
 *     3、首次调用put()方法时，底层创建长度为16的数组
 *     4、jdk7结构只有：数组+链表。jdk8中底层结构：数组+链表+红黑树
 *          当数组的某一个位置上的元素以链表形式存在的个数 > 8且当前数组的长度 > 64 时，此时此位置上的所有元素索引改为红黑树存储
 *
 *     DEFAULT_INITAL_CAPCITY：HashMap的默认容量：16
 *     DEFAULT_LOAD_FACTOR:hashMap的默认加载因子：0.75
 *     threshold：扩容的临界值，=容量*填充因子：16*0.75 => 12
 *     MIN_TREEFY_CAPCITY:桶中的Node被树同化是最小的hash表容量：64
 *
 *    四、LinkedHashMap的底层实现原理（了解）
 *      
 *    五、Map中常用的方法。
 *
 *      总结：常用方法
 *          添加：put(Object key, Object value)
 *          删除:remove(Object key)
 *          查询:get(Object,key)
 *          长度:size()
 *          遍历:keySet()/values()/entrySet()
 *
 * @author pqq
 * @create ${year}-06-16 17:27
 */
public class MapTest {
    @Test
    public void test1(){
//        HashMap map = new HashMap();

//        map.put(null,123);
        Map map = new Hashtable();
        map.put(null,null);

    }
    
    @Test
    public void test2(){
        HashMap map = new HashMap();
        map.put(123,"AA");
        map.put(345,"BB");
        map.put(12,"CC");

        System.out.println(map);

    }

    /*
    添加、删除、修改操作
    put(Object key, Object value)
    putAll(Map m)
    remove(Object key)
    clear()
     */
    @Test
    public void test3(){
        HashMap map = new HashMap();
        //添加
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);
        //覆盖
        map.put("AA", 87);

        System.out.println(map);

        HashMap map1 = new HashMap();
        map1.put("CC",123);
        map1.put("DD",123);

        System.out.println(map1);

        map.putAll(map1);
        //remove(Object key)
        Object cc = map.remove("CC");
        System.out.println(cc);

        //clear()
        map1.clear();
        System.out.println(map1.size());
    }

    @Test
    public void test4(){
        HashMap map = new HashMap();
        map.put("AA", 123);
        map.put(45, 123);
        map.put("BB", 56);


        System.out.println(map.get(45));

        //containsKey(Object key)
        boolean bb = map.containsKey("BB");
        System.out.println(bb);

        boolean isExit = map.containsValue(123);
        System.out.println(isExit);
    }


    @Test
    public void test5(){
        HashMap map = new HashMap();
        map.put("AA",123);
        map.put(45,123);
        map.put("BB",56);

        //遍历所有的key集:keySet()
        Set set =map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //遍历所有的value集：values()
        Collection values = map.values();
        for(Object obj:values){
            System.out.println(obj);
        }

        //遍历所有的key-value
        //方式一：entrySet()
        Set entrySet = map.entrySet();
        Iterator iterator1 = entrySet.iterator();
        while(iterator1.hasNext()){
            Object obj = iterator1.next();

            //entrySet集合中的元素都是entry
            Map.Entry entry = (Map.Entry)obj;
            System.out.println(entry.getKey() + "------>"+ entry.getValue());
        }

        //方式二：
        Set set1 = map.keySet();
        Iterator iterator2 = set1.iterator();
        while(iterator2.hasNext()){
            Object key = iterator2.next();
            Object value = map.get(key);
            System.out.println(key + "------>"+ value);
        }

    }

}
