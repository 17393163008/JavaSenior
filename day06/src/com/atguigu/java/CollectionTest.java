package com.atguigu.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * Collection接口中声明的测试
 *
 * 向Collection接口的实现类的对象添加数据obj时，要求obj所在类要重写equals().
 *
 * @author pqq
 * @create ${year}-06-14 17:07
 */
public class CollectionTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);
        //1、contains(Object obj):判断当前集合中是否包含obj
        //我们在判断时会调用obj对象所在类的equals()。
        boolean contains = coll.contains(123);
        System.out.println(contains);

        System.out.println(coll.contains(new String("Tom")));
        System.out.println(coll.contains(new Person("Jerry", 20)));  //false

        //2、containsAll(Collection coll1):判断形参coll1中的所有元素是否都存在与当前集合中。

        Collection coll1 = Arrays.asList(123, 456);
        System.out.println(coll.containsAll(coll1));

    }

    @Test
    public void test2(){
        //3、remove(Object obj):从当前集合中移除obj元素。
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        coll.remove(123);
        System.out.println(coll);

        //4、removeAll（Collection coll1）：差集：从当前集合中移除所有的元素
        Collection coll1 = Arrays.asList(123,456);
        coll.removeAll(coll1);
        System.out.println(coll);


    }


    @Test
    public void test3(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        //5、retainAll(Collection coll1):求交集,获取当前集合coll1集合的交集，并返回给当前集合
//        Collection coll1 = Arrays.asList(123, 456, 789);
//        coll.retainAll(coll1);
//        System.out.println(coll);

        //6、equals(Object obj):要想返回true，需要当前集合和形参集合的元素都相同
        Collection coll1 = new ArrayList();
        coll1.add(123);
        coll1.add(456);
        coll1.add(new String("Tom"));
        coll1.add(false);
        coll1.add(p);

        System.out.println(coll.equals(coll1));

    }

    @Test
    public void test4(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new String("Tom"));
        coll.add(false);
        Person p = new Person("Jerry", 20);
        coll.add(p);

        //7、hashCode():返回当前对象的hash值
        System.out.println(coll.hashCode());

        //8、集合 --> 数组：toArrray()
        Object[] arr = coll.toArray();
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }

        //拓展：数组 --> 集合
        List<String> list = Arrays.asList(new String[]{"AA", "BB", "CC"});
        System.out.println(list);

        List ints = Arrays.asList(new int[]{123, 456});
        System.out.println(ints);
        List ints1 = Arrays.asList(new Integer[]{123, 456});
        System.out.println(ints1);

        //9、iterator():返回Iterator接口的实例，用于遍历集合元素。放在IteratorTest.java中测试

    }
}
