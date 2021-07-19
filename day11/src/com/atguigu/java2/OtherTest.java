package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author pqq
 * @create ${year}-06-20 14:09
 */
public class OtherTest {
    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        //getConstructors():获取当前运行时类中声明public的构造器
        Constructor<?>[] constructors = clazz.getConstructors();
        for(Constructor c : constructors){
            System.out.println(c);
        }

        System.out.println();
        //getDeclaredConstructors():获取当前运行时类中声明的所有的构造器
        Constructor<?>[] declaredConstructors = clazz.getDeclaredConstructors();
        for(Constructor c :declaredConstructors){
            System.out.println(c);
        }
    }

    /*
    获取运行时类的父类
     */
    @Test
    public void test2(){
        Class<Person> clazz = Person.class;

        Class superclass = clazz.getSuperclass();
        System.out.println(superclass);
    }

    /*
    获取运行时类带泛型的父类
     */
    @Test
    public void test3(){
        Class<Person> clazz = Person.class;
        Type superclass = clazz.getGenericSuperclass();
        System.out.println(superclass);
    }

    /*
    获取运行时类带泛型的父类的泛型

    代码：逻辑性代码 vs 功能性代码
     */
    @Test
    public void test4(){
        Class<Person> clazz = Person.class;
        Type genericSuperclass = clazz.getGenericSuperclass();

        ParameterizedType paramType = (ParameterizedType)genericSuperclass;

        //获取泛型类型
        Type[] actualTypeArguments = paramType.getActualTypeArguments();

        System.out.println(actualTypeArguments[0]);
    }

    /*
    获取当前运行时类的接口
     */
    @Test
    public void test5(){
        Class<Person> clazz = Person.class;

        Class<?>[] interfaces = clazz.getInterfaces();
        for(Class c: interfaces){
            System.out.println(c);
        }

        System.out.println();

        //获取当前运行时类父类的接口
        Class<?>[] interfaces1 = clazz.getSuperclass().getInterfaces();
        for(Class c: interfaces1){
            System.out.println(c);
        }
    }

    /*
    获取当前运行时类所在的包
     */
    @Test
    public void test6(){
        Class<Person> clazz = Person.class;

        Package aPackage = clazz.getPackage();
        System.out.println(aPackage);
    }

    /*
    获取当前运行时类的注解

     */
    @Test
    public void test7(){
        Class<Person> clazz = Person.class;
        Annotation[] annotations = clazz.getAnnotations();
        for(Annotation a : annotations){
            System.out.println(a);
        }
    }
}
