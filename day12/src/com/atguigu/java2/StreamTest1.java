package com.atguigu.java2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 测试Stream的中间操作
 *
 * @author pqq
 * @create ${year}-06-21 15:16
 */


public class StreamTest1 {
    //1、筛选与切片
    @Test
    public void test1(){
        List<Employee> list = EmployeeData.getEmployees();

        //filter(Predicate p) --接收 lambda，从流中排除某些元素。
        Stream<Employee> stream = list.stream();
        //练习：查询员工表中薪资大于7000的员工信息
        stream.filter(e -> e.getSalary()>7000).forEach(System.out::println);

        //limit(n) -- 截断流，使元素不超过给定数量
        list.stream().limit(3).forEach(System.out::println);


        //skip(n)  -- 跳过元素，返回一个扔掉了前n个元素的流，若流中元素不足n个，则返回一个负数
        list.stream().skip(3).forEach(System.out::println);

        //distinct()  -- 筛选，通过流锁生成元素的hashCode()和equals()去除重复元素
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));
        list.add(new Employee(1010,"刘强东",40,8000));

        list.stream().distinct().forEach(System.out::println);

    }

    //映射
    @Test
    public void test2(){
        //map(Function f) - 接收一个函数作为参数，将元素转换为其他形式或提取信息，该函数会应用到每个元素上，并将其映射成一个新的元素。
        List<String> list = Arrays.asList("aa", "bb", "cc", "dd");
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //练习：获取员工姓名长度大于3的员工的姓名
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<String> stringStream = employees.stream().map(Employee::getName);
        stringStream.filter(name->name.length()>3).forEach(System.out::println);


        //练习2：
        Stream<Stream<Character>> streamStream = list.stream().map(StreamTest1::fromStringToStream);
        streamStream.forEach(s -> {
            s.forEach(System.out::println);
        });

        System.out.println();
        //flatMap(Function f) -- 接收一个函数作为参数，将流中的每一个值都转换为另一个流，然后把所有的流连成一个流
        Stream<Character> characterStream = list.stream().flatMap(StreamTest1::fromStringToStream);
        characterStream.forEach(System.out::println);

    }

    //将字符串中的多个字符构成的集合转换成对应的Stream实例
    public static Stream<Character> fromStringToStream(String str){
        ArrayList<Character> list = new ArrayList<>();
        for(Character c:str.toCharArray()){
            list.add(c);
        }
        return list.stream();
    }

    @Test
    public void test3(){
        ArrayList list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);

        ArrayList list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(6);

//        list1.add(list2);
        list1.addAll(list2);
        System.out.println(list1);
    }

    //3、排序
    @Test
    public void test4(){
        //sorted()---自然排序
//        List<Integer> list = Arrays.asList(12, 45, 65, 34, 84, 0, -4);
//        list.stream().sorted().forEach(System.out::println);

        //抛异常，原因：Employee没有实现Comparable接口
//        List<Employee> employees = EmployeeData.getEmployees();
//        employees.stream().sorted().forEach(System.out::println);
        List<Employee> employees = EmployeeData.getEmployees();
        employees.stream().sorted((e1,e2)->{
            return Integer.compare(e1.getAge(),e2.getAge());
        }).forEach(System.out::println);
    }
}
