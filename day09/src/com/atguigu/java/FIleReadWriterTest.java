package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 一、流的分类
 * 1、操作数据单位：字节流、字符流
 * 2、数据的流向：输入流、输出流
 * 3、流的角色：节点流、处理流
 *
 * 二、流的体系结构
 * 抽象基类             节点流（或文件流）      缓冲流（处理流的一种）
 * InputStream          FileInputStream       BufferedInputStream
 * OutputStream         FileOutputStream      BufferedOutPutStream
 * Reader               FileReader            BufferedReader
 * Writer               FileWriter            BufferedWriter
 *
 * @author pqq
 * @create ${year}-06-18 15:45
 */
public class FIleReadWriterTest {

    public static void main(String[] args) {
        File file = new File("hello.txt");//相较于当前工程
        System.out.println(file.getAbsolutePath());

        File file1 = new File("day09\\hello.txt");
        System.out.println(file1.getAbsolutePath());
    }

    /*
    将day09下的hello.txt文件内容读入程序中，并输出到控制台

    说明点：
    1、read()的理解：返回读入的一个字符，如果达到文件末尾，返回-1
    2、异常的理解：为了保证流资源一定可以执行关闭操作，需要使用try-catch-finally处理
    3、读入的文件一定要存在，否则会报FileNoteFoundException。

     */
    @Test
    public void test1() {
        FileReader fr = null;
        try {
            //1、实例化File类的对象，指明需要操作的文件
            File file = new File("hello.txt");  //相较于当前的module
            //2、提供具体的流
            fr = new FileReader(file);

            //3、数据的读入过程
            //read():返回读入的一个字符，如果达到文件末尾，返回-1
            //方式一
//        int data = fr.read();
//        while(data!=-1){
//            System.out.print((char)data);
//            data = fr.read();     //相当于i++或者迭代器的next()
//        }

            //方式二：
            int data;
            while((data = fr.read())!=-1){
                System.out.print((char)data);  //如果不转换类型，会以ascii码的形式进行输出
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            try {
                if(fr!=null){
                    fr.close();   //gc不会回收硫，若不主动关闭，可能会导致内存的泄露问题
                }
            } catch (IOException e) {
                e.printStackTrace();
            }

        }


    }

    //对read()方法的操作升级，使用read的重载方法
    @Test
    public void testFileReader1() {
        FileReader fr = null;
        try {
            //1、File类的实例化
            File file = new File("hello.txt");
//            System.out.println(file.getAbsolutePath());

            //2、FileReader流的实例化
            fr = new FileReader(file);

            //3、读入的操作
            //read(char[] cbuf):返回每次读入的cubf数组中的字符的个数。如果达到文件末尾，返回-1
            char[] cbuf = new char[5];

//            fr.read(cbuf);   //加上这一句就会先读取五个字符，导致后面的输出不正确

            int len;
            while((len=fr.read(cbuf))!=-1){
                //错误的写法
                //                for (int i = 0; i < cbuf.length; i++) {
//                    System.out.print(cbuf[i]);
//                }

                //正确的写法
//                for (int i = 0; i < len; i++) {
//                    System.out.print(cbuf[i]);
//                }
                
                //方式二
                //错误的写法
//                String str = new String(cbuf);
//                System.out.print(str);

                //正确的写法
                String str = new String(cbuf,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            //4、资源的关闭
            if(fr!=null){
                try {
                    fr.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /*
    从内存中写出数据到硬盘的文件里

    说明：
    1、输出操作，对应的File可以不存在，并不会报异常
    2、
        File对应的硬盘中的文件如果不存在，在输出的时候会自动创建文件
        File对应的硬盘中的文件如果存在，
            如果流使用的构造器是：FileWriter(file,false) / FileWriter(file):对原有文件的覆盖
            如果流使用的构造器是：FileWriter(file,true),不会对原有文件覆盖，而是在原有文件内容上进行内容的追加

     */

    @Test
    public void testFileWriter() {
        FileWriter fw = null;
        try {
            //1、提供File类对象，指明写出到的文件
            File file = new File("Hello1.txt");

            //2。提供FileWriter的对象，用于数据的写出
            fw = new FileWriter(file);

            //3、写出的操作
            fw.write("I have a dream!\n");
            fw.write("you need to have a dream!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、流资源的关闭
            if(fw!=null){
                try {
                    fw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        }

    }

    @Test
    public void testFileReaderFileWriter() {
        FileReader fr = null;
        FileWriter fw = null;
        try {
            //1、创建File类的对象，指明读入和写出文件
            File srcFile = new File("hello.txt");
            File destFile = new File("Hello2.txt");

            //不能使用字符流来处理图片等字节数据
            //            File srcFile = new File("美女.png");
//            File destFile = new File("565.png");

            //2、创建输入流和输出流的对象
            fr = new FileReader(srcFile);
            fw = new FileWriter(destFile);

            //3、数据的读入和写出操作
            char[] cbuf = new char[5];
            int len;  //记录每次读入到cbuf数组中的数据长度
            while((len=fr.read(cbuf))!=-1){
                //每次写出len个字符
                fw.write(cbuf,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流资源
            //方式一
//            try {
//                if(fw!=null)
//                    fw.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }finally {
//
//                try {
//                    if(fr!=null)
//                        fr.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }

            //方式二
            try {
                if(fw!=null)
                    fw.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

            try {
                if(fr!=null)
                    fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
