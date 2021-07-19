package com.atguigu.java;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 了解类的加载器
 *
 * @author pqq
 * @create ${year}-06-20 11:34
 */
public class ClassLoaderTest {
    @Test
    public void test1(){
        //对于自定义类，使用系统类加载器进行加载
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        System.out.println(classLoader);

        //调用系统类的加载器的getParent():获取扩展引导类加载器
        ClassLoader classLoader1 = classLoader.getParent();
        System.out.println(classLoader1);

        //调用系统类的加载器的getParent():获取扩展引导类加载器
        //引导类加载器主要湖泽加载java的核心类库，无法加载自定义类的        ClassLoader classLoader2 = classLoader1.getParent();
        ClassLoader classLoader2 = classLoader1.getParent();
        System.out.println(classLoader2);


        ClassLoader classLoader3 = String.class.getClassLoader();
        System.out.println(classLoader3);
    }

    /*
    需要掌握
    Properties:用来读取配置文件。
     */

    @Test
    public void test2() throws IOException {
        Properties pros = new Properties();
        //此时的配置文件默认在当前module下

        //读取配置文件的方式一
//        FileInputStream fis = new FileInputStream("src\\jdbc1.properties");
//        pros.load(fis);

        //读取配置文件的方式二：使用classLoader
        //配置文件默认识别为：当前module的src下
        ClassLoader classLoader = ClassLoaderTest.class.getClassLoader();
        InputStream is = classLoader.getResourceAsStream("jdbc1.properties");
        pros.load(is);

        String user = pros.getProperty("user");
        Object password = pros.get("password");
        System.out.println("user="+user+"\npw="+password);
    }
}
