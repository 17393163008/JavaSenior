package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 对象流的使用
 * 1、ObjectInputStream 和 ObjectOutputStream
 * 2、作用：用于存储和读取基本数据类型数据或对象的数据流，他的强大之处就是可以把Java中的对象写入到数据源中，也能把对象从数据源中还原回来。
 *
 * 3、要想一个java对象时可序列化的，需要满足相应的要求，见Person.java
 *
 *
 * @author pqq
 * @create ${year}-06-19 16:06
 */
public class ObjectInputOutputStreamTest {
    /*
    序列化过程：将内存中的java对象保存到磁盘中或通过网络传输出去
    使用ObjectOutputStream实现
     */

    @Test
    public void tetsObjectOutputStream(){
        ObjectOutputStream oos = null;
        try {
            //1、造文件、流对象
            oos = new ObjectOutputStream(new FileOutputStream("object.dat"));
            //2、文件写出
            oos.writeObject(new String("我爱北京天安门"));

            oos.flush();//刷新操作

            oos.writeObject(new Person("王二小",23));
            oos.writeObject(new Person("王san小",88));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //3、关闭流
            if(oos!=null){
                try {
                    oos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }


    }

    /*
    反系列化：将磁盘文件中的对象还原为内存中的一个java对象
    使用ObjectInputStream来实现
     */
    @Test
    public void testObjectInputStream(){
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream("object.dat"));
            Object obj = ois.readObject();
            String str = (String)obj;
            System.out.println(str);

            Person p = (Person) ois.readObject();
            System.out.println(p);
            Person p1 = (Person) ois.readObject();
            System.out.println(p1);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            if(ois!=null){

                try {
                    ois.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
