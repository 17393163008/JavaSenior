package com.atguigu.java1;

/**
 * @author pqq
 * @create ${year}-06-20 12:57
 */

@MyAnnotation
public class Person extends Creatrue<String> implements Comparable<String>,MyInterface {
    private String name;
    int age;
    public int id;

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Person() {
    }

    public Person(String name, int age, int id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    Person(String name, int id) {
        this.name = name;
        this.id = id;
    }

    @MyAnnotation(value = "abc")
    private Person(String name){
        this.name = name;
    }

    @MyAnnotation
    private String show(String nation){
        System.out.println("我的国籍是"+nation);
        return nation;
    }

    public String display(String interests){
        return interests;

    }

    private static void showDesc(){
        System.out.println("我是一个可爱的人");
    }

    @Override
    public void info() {
        System.out.println("我是一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
