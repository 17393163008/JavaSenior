package com.atguigu.java2;

import com.atguigu.java1.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 调用运行时类中指定的结构、属性、方法、构造器
 * @author pqq
 * @create ${year}-06-20 15:04
 */
public class ReflectionTest {

    /*
    不需要掌握，只能获取public标识的属性
     */
    @Test
    public void testField() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //获取指定的属性:要求运行时类中的属性声明为public
        //通常不采用此方法
        Field id = clazz.getField("id");

        //设置当前属性的值
        /*
        set():参数一：指明设置那个对象的属性
              参数二：将属性值设置为多少
         */
        id.set(p,1001);

        /*
        获取当前属性的值
        get():参数一：获取那个对象的当前属性值
         */
        int Pid = (int)id.get(p);
        System.out.println(Pid);
    }

    /*、
    如何操作运行时类中指定的属性  --  需要掌握
     */
    @Test
    public void testField1() throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        //1、getDeclaredField(String fieldName):获取运行时类中指定变量名的属性
        Field name = clazz.getDeclaredField("name");

        //2、保证当前属性时可访问的
        name.setAccessible(true);

        //3、设置、获取当前对象的属性值
        name.set(p,"Tom");
        System.out.println(name.get(p));
    }

    /*、
    如何操作运行时类中指定的属性  --  需要掌握
     */

    @Test
    public void testMethod() throws IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class<Person> clazz = Person.class;

        //创建运行时类的对象
        Person p = clazz.newInstance();

        /*
        1、获取指定的某个方法
        getDeclaredMethod():
        参数一：指明获取的方法的名称，参数二，指明获取的方法的形参列表
         */
        Method show = clazz.getDeclaredMethod("show", String.class);

        //2、保证方法是可访问的
        show.setAccessible(true);
        /*
        3、调用invoke()
        invoke():参数一：方法的调用者 参数二:给方法形参赋值的实参
         */
        Object chn = show.invoke(p, "CHN");
        System.out.println(chn);

        System.out.println("******如何调用静态方法********");

        //private static void showDesc()
        Method showDesc = clazz.getDeclaredMethod("showDesc");
        showDesc.setAccessible(true);

        //如果调用的invoke方法没有返回值，则此invoke()返回null
        Object invoke = showDesc.invoke(clazz);
        System.out.println(invoke);
    }

    /*
    如何调用运行时类中指定的构造器
     */
    @Test
    public void testConstructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<Person> clazz = Person.class;

        //private Person(String name)
        //1、获取指定的构造器
        //getDeclaredConstructor:参数：指明构造起的参数列表
        Constructor<Person> constructor = clazz.getDeclaredConstructor(String.class);

        //2、保证构造器是可以访问的
        constructor.setAccessible(true);

        //3、调用此构造器创建运行时类的对象
        Person per = constructor.newInstance("tom");
        System.out.println(per);
    }

}
