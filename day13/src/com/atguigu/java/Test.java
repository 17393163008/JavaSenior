package com.atguigu.java;

/**
 * @author pqq
 * @create ${year}-06-22 14:33
 */
public class Test {
    public static void main(String[] args) {

        Person san = new Person("san", 18);
        System.out.println(san);
    }
    static class Person{
        private String name;
        private Integer age;

        public Person(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }

}
