package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 1、Stream关注的是对数据的运算，与CPU打交道
 *      集合关注的是数据的存储，与内存打交道
 *
 * 2、
 *    ① Stream 自己不会存储元素
 *    ② Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream
 *    ③ Stream 操作时延迟执行的，这意味着他们会等到需要结果的时候才执行。
 *
 * 3、Stream执行流程
 * ①Stream的实例化
 * ②一系列的中间操作
 * ③终止操作
 *
 * 4、说明
 * 4.1 一个中间操作链，对数据源的数据进行处理
 * 4.2 一旦执行操作终止，就执行中间操作链，并产生结果，之后，不会再被使用
 *
 *
 * 测试Stream的实例化
 *
 * @author pqq
 * @create ${year}-06-21 12:42
 */
public class StreamTest {
    //创建方式一：通过集合
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //default Stream<E> stream():返回一个顺序流
        Stream<Employee> stream = employees.stream();

        //default Stream<E> parallelStream():返回一个并行流
        Stream<Employee> parallelStream = employees.parallelStream();


    }

    //创建Stream的方式二：通过数组
    @Test
    public void test2(){
        int[] arr = new int[]{1,2,3,4,5,6};
        //调用Arrays类的static<T> Stream<T> Stream(T[] array):返回一个流
        Arrays.stream(arr);

        Employee e1 = new Employee(1001,"Tom");
        Employee e2 = new Employee(1002,"jerry");

        Employee[] arr1 = {e1, e2};
        Stream<Employee> stream = Arrays.stream(arr1);

    }

    //创建Stream的方式三：通过Stream的of()
    @Test
    public void test3(){
        Stream<Integer> stream = Stream.of(1, 2, 3, 4, 5, 6);

    }

    //创建Stream方式四：创建无限流
    @Test
    public void test4(){
        //迭代
        //public static<T> Stream<T> iterate(final T seed, final UnaryOperator<T> f)
        //遍历前十个偶数
        Stream.iterate(0,t->t+2).limit(10).forEach(System.out::println);

        //生成
        //public static<T> Stream<T> generate(Supplier<T> s)

        System.out.println();
        Stream.generate(Math::random).limit(10).forEach(System.out::println);
    }



}
