package com.atguigu.exer1;

import org.junit.Test;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @author pqq
 * @create ${year}-06-15 21:26
 */
public class EmployeeTest {

    //问题一，使用自然排序
    @Test
    public void test1(){
        TreeSet set = new TreeSet();

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1969,11,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1972,7,4));
        Employee e4 = new Employee("liming",51,new MyDate(1978,9,12));
        Employee e5 = new Employee("liangchaowei",55,new MyDate(1964,8,6));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }


    //问题二：按照生日的顺序进行排序
    @Test
    public void test2(){
        TreeSet set = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof Employee && o2 instanceof Employee){
                    Employee e1 = (Employee)o1;
                    Employee e2 = (Employee)o2;

                    MyDate b1 = e1.getBirthday();
                    MyDate b2 = e2.getBirthday();

                    //方式一

//                    //比较年
//                    int minusYear = b1.getYear() - b2.getYear();
//                    if(minusYear != 0){
//                        return minusYear;
//                    }
//
//                    //比较月
//                    int minusMonth = b1.getMonth() - b2.getMonth();
//                    if(minusMonth != 0){
//                        return minusMonth;
//                    }
////                    int minusDay = b1.getDay()-b2.getDay();
////                    if(minusDay!=0){
////                        return minusDay;
////                    }
//                    //比较日
//                    return b1.getDay()-b2.getDay();

                    //方式二：
                    return b1.compareTo(b2);
                }
                throw new RuntimeException("传入的数据类型不一致！");
            }
        });

        Employee e1 = new Employee("liudehua",55,new MyDate(1965,5,4));
        Employee e2 = new Employee("zhangxueyou",43,new MyDate(1969,11,4));
        Employee e3 = new Employee("guofucheng",44,new MyDate(1972,7,4));
        Employee e4 = new Employee("liming",51,new MyDate(1978,9,12));
        Employee e5 = new Employee("liangchaowei",55,new MyDate(1964,8,6));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        set.forEach(System.out::println);
    }
}
