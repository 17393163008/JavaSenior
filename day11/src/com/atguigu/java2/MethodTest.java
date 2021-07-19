package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Method;

/**
 * 获取运行时类的方法结构
 * @author pqq
 * @create ${year}-06-20 13:25
 */
public class MethodTest {

    @Test
    public void test1(){
        Class<Person> clazz = Person.class;

        //获取当前运行时类及其所有父类中声明为public权限的方法
        Method[] methods = clazz.getMethods();
        for(Method m : methods){
            System.out.println(m);
        }
        System.out.println();

        //获取当前运行时类中声明的所有方法
        Method[] methods1 = clazz.getDeclaredMethods();
        for(Method m1 : methods1){
            System.out.println(m1);
        }
    }
}
