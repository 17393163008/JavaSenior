package com.atguigu.java1;

import org.junit.Test;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

/**
 * 注解的使用
 *
 * 1、理解Annotation
 * ① jdk5.0新增的功能
 * ② Annotation其实就是代码里的特殊标记，这些标记可以在编译、类加载，运行时读取，并执行相应的处理，通过使用Annotation，
 *      程序员可以在不改变原有逻辑的情况下，在源文件中嵌入一些补充信息
 * ③ 在javaSE中，注解的使用目的比较简单，例如标记过时的功能，忽略警告等。
 *      在JavaEE/Android中注解占据了
 *      旧版中所遗留的繁荣代码和XML配置等。
 *
 * 2、Annotation的使用实例
 * 示例一：生成文档相关的注解
 * 示例二：在编译时进行格式检查（JDK内置的三个基本注解）
 *      @Override:限定重写父类方法，该注解只能用于方法
 *      @Deprecated：用于表示所修饰的元素（类、方法等）一过时
 *      @SuppressWarnings：抑制编译器警告
 * 实例三：跟踪代码依赖性，实现替代配置文件功能。
 *
 *
 * 3、如何自定义注解
 *  ① 注解声明为：@interface
 *  ② 内部成员定义，通常使用value表示
 *  ③ 可以使用成员的默认值，使用default定义
 *  ④ 如过自定义的注解没有成员，表示是一个标识作用。
 *
 *  如果注解有成员，在使用注解时，需要指明成员的值。
 *  自定义注解必须配上注释的信息处理流程（使用反射）才有意义
 *  自定义注解通常都会指明两个元注解：Retention、Target
 *
 * 4、JDK提供四种元注解
 *  元注解：对现有的注解进行解释说明的注释
 *  Retention：指定所修饰的Annotation的生命周期：SOURCE/CLASS（默认行为）/RUNTIME（只有声明为RUNTIME声明周期的注解，才能通过反射获取）
 *  Target:用于指定被修饰的Annotation能用于修饰哪些程序元素
 *
 *  /*下面两个出现的频率比较低
 *  Documentd：表示所修饰的注解在被javadoc解释时，保留下来
 *  Inherited：被它修饰的Annotation将具有继承性。
 *
 * 5、通过反射获取注解信息 --- 到反射内容系统讲解
 *
 * 6、jdk 8 中注解的新特性：可重复注释、类型注释
 *
 * 6.1 可重复注解：
 *  ① 在MyAnnotation上声明@Repeatable，成员值为MyAnnotation.class
 *  ② MyAnnotation的Target和RetentionMyAnnotations相同。
 *
 * 6.1类型注解
 *
 * @author pqq
 * @create ${year}-06-14 11:39
 */
public class AnnotationTest {
    public static void main(String[] args) {
        Person p = new Student();
        p.walk();

        Date date = new Date(2020, 10, 11);
        System.out.println(date);

        int num = 10;

        @SuppressWarnings("unused")
        ArrayList list = new ArrayList();
    }

    @Test
    public void testGetAnnotation(){
        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);


        }
    }

}

@MyAnnotation(value = "hi")
@MyAnnotation(value = "abc")
//jdk8之前的写法
//@MyAnnotations({@MyAnnotation(value = "hi"),@MyAnnotation(value = "hi2")})
class Person{
    private String name;
    private String age;

    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void walk(){
        System.out.println("人走路");
    }

    public void eat(){
        System.out.println("人吃饭");
    }
}

interface Info{
    void show();
}

class Student extends Person implements Info{
    @Override
    public void walk() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {

    }
}

class Generic<@MyAnnotation T>{
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }
}