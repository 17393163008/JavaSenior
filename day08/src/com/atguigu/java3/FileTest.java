package com.atguigu.java3;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * File类的使用
 * 1、File类的一个对象，代表一个文件或一个文件目录(俗称：文件夹)
 * 2、File类声明在java.io包下
 * 3、File类中涉及到关于文件或文件目录的创建、删除、重命名、修改时间、文件大小等方法
 *  并未涉及写入或读取文件内容的操作，如果涉及到文件的读写操作，必须使用io流来完成。
 * 4、后续File类的对象常会作为参数传递到流的构造器中，指明读取或写入的“终点”
 *
 * @author pqq
 * @create ${year}-06-17 19:51
 */
public class FileTest {
    /*
    1、如何创建File类
        File(String filename)
        File(String parentPath,String chilePath)
        File(File parentFile, String childpPath)

    2、
    相对路径：相较于某个路径下，指明的路径
    绝对路径：包含盘符在内的文件或文件目录的路径

    3、路径分隔符：
        windows：\\
        unix:/
     */

    @Test
    public void test1(){
        //构造器一
        File file = new File("hello.txt");//相对于当前module
        File file1 = new File("D:\\ProgrammingEnvironment\\IDEA\\JavaSenior\\day08\\he.txt");

        System.out.println(file);
        System.out.println(file1);

        //构造器二
        File file2 = new File("D:\\ProgrammingEnvironment\\IDEA", "JavaSenior");
        System.out.println(file2);

        //构造器三
        File file3 = new File(file2, "hi.txt");
        System.out.println(file3);
    }

    @Test
    public void test2(){
        File file1 = new File("hello.txt");
        File file2 = new File("D:\\io\\hi.txt");

        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getPath());
        System.out.println(file1.getName());
        System.out.println(file1.getParent());
        System.out.println(file1.length());
        System.out.println(new Date(file1.lastModified()));

        System.out.println();

        System.out.println(file2.getAbsolutePath());
        System.out.println(file2.getPath());
        System.out.println(file2.getName());
        System.out.println(file2.getParent());
        System.out.println(file2.length());
        System.out.println(file2.lastModified());

    }

    //文件目录下的列表显示
    @Test
    public void test3(){
        File file = new File("D:\\ProgrammingEnvironment\\IDEA\\JavaSenior");
        String[] list = file.list();
        for(String s:list){
            System.out.println(s);
        }

        File[] files = file.listFiles();
        for(File f: files){
            System.out.println(f);
        }

    }

    /*
    public boolean renameTo(File dest):把文件重命名为指定的文件路径
        比如：file1.renameTo(file2)为例
        要想保证返回true，需要file1在硬盘中是存在的，且file2在硬盘中不存在
     */
    @Test
    public void test4(){
        File file = new File("hello.txt");
        File file1 = new File("D:\\io\\hi.txt");
        boolean b = file1.renameTo(file);
        System.out.println(b);

    }

    //文件/文件夹是否存在的方法
    @Test
    public void test5(){
        File file = new File("hello.txt");

        System.out.println(file.isDirectory());
        System.out.println(file.isFile());
        System.out.println(file.exists());
        System.out.println(file.canRead());
        System.out.println(file.canWrite());
        System.out.println(file.isHidden());

        System.out.println();
        File file1 = new File("D:\\io");
        System.out.println(file1.isDirectory());
        System.out.println(file1.isFile());
        System.out.println(file1.exists());
        System.out.println(file1.canRead());
        System.out.println(file1.canWrite());
        System.out.println(file1.isHidden());

    }

    //创建相关的方法

    @Test
    public void test6() throws IOException {
        File file = new File("hi.txt");
        if(!file.exists())
        {
            //文件的创建
            file.createNewFile();
            System.out.println("创建成功！");
        }else{
            file.delete();
            System.out.println("删除成功！");
        }
    }

    @Test
    public void test7(){
        //文件目录的创建
        //boolean mkdir():创建文件目录，如果文件目录存在，则不进行创建，如果文件的上层目录不存在，也不创建
        //boolean mkdirs():创建文件目录，如果文件目录存在，则不进行创建，如果文件的上层目录不存在，创建整个目录

        File file = new File("D:\\io\\io1\\io3");
        boolean mkdir = file.mkdir();
        if(mkdir == true){
            System.out.println("创建成功1");
        }

        File file1 = new File("D:\\io\\io1\\io4");
        boolean mkdir1 = file1.mkdirs();
        if(mkdir1 == true){
            System.out.println("创建成功2");
        }




    }
}
