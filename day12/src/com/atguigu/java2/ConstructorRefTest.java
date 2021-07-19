package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一、构造器引用
 *      和方法引用类似，函数式接口的抽象方法的形参列表和构造器的形参列表一致
 *      抽象方法的返回值类型即为构造器所属的类型
 *
 * 二、数组引用
 *      可以把数组看做一个特殊的类，则写法与构造器引用
 *
 * @author pqq
 * @create ${year}-06-21 12:08
 */
public class ConstructorRefTest {
    //构造器引用
    //Supplier中的get()
    //Employee的空参构造器：Employee()
    @Test
    public void test1(){
        Supplier<Employee> sup = new Supplier<Employee>() {

            @Override
            public Employee get() {
                return new Employee();
            }
        };
        System.out.println(sup.get());

        System.out.println("**********************");

        Supplier<Employee> sup1 = () -> new Employee();

        System.out.println("**********************");

        Supplier<Employee> sup2 = Employee::new;
    }

    //Function中的R apply（T t）
    @Test
    public void test2(){
        Function<Integer,Employee> fun1 = id -> new Employee(id);
        Employee employee = fun1.apply(1001);
        System.out.println(employee);

        System.out.println("*****************");

        Function<Integer,Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1002));
    }

    //BiFunction中的R apply(T t,U u)
    @Test
    public void test3(){
        BiFunction<Integer,String,Employee> fun1 = (id,name) -> new Employee(id,name);
        System.out.println(fun1.apply(1001,"Tom"));

        System.out.println("************");

        BiFunction<Integer,String,Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(1003,"pan"));
    }

    //数组引用
    //Function的R apply（T t）
    @Test
    public void test4(){
        Function<Integer,String[]> fun1 = (length) -> new String[length];
        String[] arr1 = fun1.apply(13);
        System.out.println(Arrays.toString(arr1));

        System.out.println("**************");

        Function<Integer,String[]> fun2 = String[]::new;
        String[] arr2 = fun1.apply(3);
        System.out.println(Arrays.toString(arr2));
    }
}
