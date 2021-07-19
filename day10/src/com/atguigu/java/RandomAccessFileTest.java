package com.atguigu.java;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * RandomAccessFileTest的使用
 * 1、RandomAccessFile直接继承了java.lang.Object类，实现了DataInput和DataOutPut接口
 * 2、RandomAccessFile既可以作为一个输入流，也可以作为一个输出流
 *
 * 3、如果RandomAccessFile作为输出流时，写出到的文件如果不存在，则在执行过程中自动创建
 *      如果写出到的文件存在，则会对原有的文件内容从头覆盖。
 *
 * 4、可以通过相关的操作，实现RandomAccessFile“插入数据的效果”
 *
 *
 * @author pqq
 * @create ${year}-06-19 16:50
 */
public class RandomAccessFileTest {
    @Test
    public void test1() {
        RandomAccessFile raf1 = null;
        RandomAccessFile raf2 = null;
        try {
            raf1 = new RandomAccessFile(new File("美女.png"),"r");
            raf2 = new RandomAccessFile(new File("美女1.png"),"rw");

            byte[] buffer = new byte[1024];
            int len;
            while ((len=raf1.read(buffer))!=-1){
                raf2.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(raf1!=null){
                try {
                    raf1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
            if(raf2!=null){

                try {
                    raf2.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

    @Test
    public void test2() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt","rw");
        raf1.seek(3); //将指针调到角标为3的位置

        raf1.write("xyz".getBytes());
        raf1.close();
    }

    /*
    使用RandomAccessFile实现数据的插入效果
     */
    @Test
    public void test3() throws IOException {
        RandomAccessFile raf1 = new RandomAccessFile("hello.txt", "rw");
        raf1.seek(3); //将指针调到角标为3的位置

        //保存指针三后面的所有数据到StringBuilder中
        StringBuilder sb = new StringBuilder((int) new File("hello.txt").length());
        byte[] buffer = new byte[20];
        int len;
        while((len=raf1.read(buffer))!=-1){
            sb.append(new String(buffer,0,len));
        }

        //调回指针，写入“xyz”
        raf1.seek(3);
        raf1.write("abc".getBytes());

        //将StringBuilder中的数据再写入文件中
        raf1.write(sb.toString().getBytes());

        raf1.close();

        //思考，将StringBuilder替换为ByteArrayOutPutStream
    }
}
