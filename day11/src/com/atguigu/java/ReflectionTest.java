package com.atguigu.java;

import org.junit.Test;

import java.lang.annotation.ElementType;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author pqq
 * @create ${year}-06-20 9:47
 */
public class ReflectionTest {
    //反射之前，对于Person类的操作

    @Test
    public void test(){
        //1、创建Person类的对象
        Person p1 = new Person("Tom", 12);

        //2、通过对象，调用其内部的属性，方法
        p1.setAge(10);
        System.out.println(p1.toString());

        p1.show();

        //在Person类的外部，不能够通过Person类的对象调用其内私有结构。
        //比如：name、showNation()以及私有的构造器

    }

    //反射之后，对Person的操作
    @Test
    public void test2() throws Exception{
        Class clazz = Person.class;
        //1、通过反射去创建Peron类的对象
        Constructor cons = clazz.getConstructor(String.class, int.class);
        Object obj = cons.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());
        //2、通过反射去调用对象指定的属性。方法
        //调用属性
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);      //需要更改必须加这一句
        name.set(p,"张华");


//        age.set(obj,20);
        System.out.println(p.toString());

        //调用方法
        Method show = clazz.getDeclaredMethod("show");

        show.invoke(p);

        System.out.println("******************");

        //通过反射，可以调用Person类的私有化结构。比如私有的属性，私有的方法
        //调用私有的构造器
        Constructor cons1 = clazz.getDeclaredConstructor(String.class);
        cons1.setAccessible(true);
        Object p1 = cons1.newInstance("jerry");
        System.out.println(p1);

        //调用私有的属性
        Field name1 = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"hanhan");
        System.out.println(p1);

        //调用私有的方法
        Method showNation = clazz.getDeclaredMethod("showNation", String.class);
        showNation.setAccessible(true);

        String nation = (String) showNation.invoke(p1, "中国");//相当于p1.showNation("中国")
        System.out.println(nation);

    }

    //疑问1：通过直接new的方式或反射都可以调用公共的结构，开发中到底用哪个？
        //建议：直接new的方式
        //什么时候会使用：反射的方式。    反射的特征：动态性
    //疑问2：反射与面向对象的封装性是不是冲突的？如何看待两个技术？
        //不矛盾。

    /*
    关于java.lang.Class类的理解
    1、类的加载过程：
        程序在经过java.exe命令以后，会生成一个或多个字节码文件（.class结尾），接着我们使用java.exe命令对某个字节码文件进行解释运行
        相当于将某个字节码文件加载到内存中，此过程就称为类的加载
        加载到内存中的类，我们就称为运行时类，就作为class的一个实例

    2、换句话说，Class对象的实例就对应着一个运行时类
    3、加载到内存中的运行时类，会缓存一段时间。在此时间内，我们可以通过不同的方式来获取此运行时类

    //获取Class的实例的前三种方式需要掌握
     */

    //获取Class类的实例的方式
    @Test
    public void test3() throws ClassNotFoundException {
        //方式一
        Class<Person> clazz1 = Person.class;
        System.out.println(clazz1);
        
        //方式二：通过运行时累的对象
        Person p1 = new Person();
        Class clazz2 = p1.getClass();
        System.out.println(clazz2);

        //方式三在开发中用的最多
        //方式三：调用Class的静态方法：forName（String classPath）
        Class clazz3 = Class.forName("com.atguigu.java.Person");
        System.out.println(clazz3);

        System.out.println(clazz1==clazz2);
        System.out.println(clazz3==clazz2);

        //方式四、使用类的加载器，classLoader（了解）
        ClassLoader classLoader = ReflectionTest.class.getClassLoader();
        Class clazz4 = classLoader.loadClass("com.atguigu.java.Person");
        System.out.println(clazz4);

        System.out.println(clazz2==clazz4);
    }
    

    @Test
    public void test4(){
        Class<Object> c1 = Object.class;
        Class<Comparable> c2 = Comparable.class;
        Class<String[]> c3 = String[].class;
        Class<int[][]> c4 = int[][].class;
        Class<ElementType> c5 = ElementType.class;
        Class<Override> c6 = Override.class;
        Class<Integer> c7 = int.class;
        Class<Void> c8 = void.class;
        Class<Class> c9 = Class.class;

        int[] a = new int[10];
        int[] b = new int[100];

        Class<? extends int[]> c10 = a.getClass();
        Class<? extends int[]> c11 = b.getClass();

        //只要数组的元素类型和维度一样，就是同一个class
        System.out.println(c11==c10);


    }

    //万事万物皆对象？对象.Xxx,File,URL，反射，前端，数据库操作


}
