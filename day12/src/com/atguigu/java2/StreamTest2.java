package com.atguigu.java2;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Stream终止操作
 *
 * @author pqq
 * @create ${year}-06-21 16:07
 */
public class StreamTest2 {
    //1、匹配与查找
    @Test
    public void test1(){
        List<Employee> employees = EmployeeData.getEmployees();

        //allMatch(Predicate p)--检查是否匹配所有元素
        //练习：是否所有的员工年龄都大于18
        boolean allMatch = employees.stream().allMatch(e -> e.getAge() > 18);
        System.out.println(allMatch);

        //anyMatch(Predicate p) -- 检查是否匹配一个元素。
        //练习，是否存在员工工资大于10000
        boolean anyMatch = employees.stream().anyMatch(e -> e.getSalary() > 10000);
        System.out.println(anyMatch);

        //noneMatch(Predicate p)--检查是否没有匹配的元素
        //练习：是否存在员工“雷”
        boolean noneMatch = employees.stream().noneMatch(e -> e.getName().contains("雷"));
        System.out.println(noneMatch);

        //findFirst--返回第一个元素
        Optional<Employee> first = employees.stream().findFirst();
        System.out.println(first);

        //findAby
        Optional<Employee> any = employees.stream().findAny();
        System.out.println(any);




    }

    @Test
    public void test2(){
        List<Employee> employees = EmployeeData.getEmployees();

        //count--返回流中元素总个数
        Stream<Employee> stream = employees.stream().filter(e -> e.getSalary() > 5000);
        System.out.println(stream);

        //max（Comparator c）--返回流中的最大值
        //练习：返回最高的工资
        Stream<Integer> salaryStream = employees.stream().map(e -> e.getSalary());
        Optional<Integer> maxSalary = salaryStream.max(Double::compare);
        System.out.println(maxSalary);

        //min(Comparator c)--返回最小值、
        //练习：返回最低工资的员工
        //forEach(Consumer c)--内部迭代
        Optional<Employee> employee = employees.stream().min((e1, e2) -> Double.compare(e1.getSalary(), e2.getSalary()));
        System.out.println(employee);

        //forEach(Consumer c)--内部迭代
        employees.stream().forEach(System.out::println);

    }

    //2、归约
    @Test
    public void test3(){
        //reduce(T identity,BinaryOperator) -- 可以将流中元素反复结合起来，得到一个值，返回T
        //练习1：计算1-10的自然数之和
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
        Integer sum = list.stream().reduce(0, Integer::sum);
        System.out.println(sum);


        //reduce(BinaryOperator)--可以将流中元素反复结合起来，得到一个值。返回Optional<T>
        //练习2：计算公司所有员工工资的和
        List<Employee> employees = EmployeeData.getEmployees();
        Stream<Integer> salaryStream = employees.stream().map(Employee::getSalary);
        Optional<Integer> sumMoney = salaryStream.reduce(Integer::sum);
        System.out.println(sumMoney);

    }

    //3-收集
    @Test
    public void test4(){
        //collect(Collector c)--将流转换为其他形式，接收一个Collector接口的实现，用于
        //练习1：查找员工工资大于6000的员工，结果返回一个List或Set
        List<Employee> employees = EmployeeData.getEmployees();
        List<Employee> list = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toList());

        list.forEach(System.out::println);

        Set<Employee> set = employees.stream().filter(e -> e.getSalary() > 6000).collect(Collectors.toSet());
        set.forEach(System.out::println);
    }

}
