package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 * 处理流之一：缓冲流的使用
 *
 * 1.缓冲流
 * BufferedInputStream
 * BufferedOutputStream
 * BufferedReader
 * BufferedWriter
 *
 * 2.作用：提供流的读取、写入的速度
 *  提高读写速度的原因：内部提供了一个缓冲区
 *
 * 3、处理流就是“套接”在已有流的基础上
 *
 *  * 一、流的分类
 *  * 1、操作数据单位：字节流、字符流
 *  * 2、数据的流向：输入流、输出流
 *  * 3、流的角色：节点流、处理流
 *  *
 *  * 二、流的体系结构
 *  * 抽象基类             节点流（或文件流）                                  缓冲流（处理流的一种）
 *  * InputStream          FileInputStream (read(byte[] buffer))             BufferedInputStream(read(byte[] buffer))
 *  * OutputStream         FileOutputStream (writer(byte[] buffer,0,len))    BufferedOutPutStream(writer(byte[] buffer,0,len))
 *  * Reader               FileReader(read(char[] cbuf))                     BufferedReader(read(char[] cbuf) / readdLine())
 *  * Writer               FileWriter (writer(char[] cbuf,0,len))            BufferedWriter(writer(char[] cbuf,0,len))
 *
 * @author pqq
 * @create ${year}-06-19 8:28
 */
public class BufferedTest {

    /*
    实现非文本文件的复制
     */
    @Test
    public void BufferedStreamTest() {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File("美女1.png");
            File destFile = new File("美女2.png");

            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3、复制的细节：读取、写入
            byte[] buffer = new byte[10];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);

//                bos.flush();  //刷新缓冲区
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭
            //要求，先关闭外层的流，再关闭内层的流
            if(bos!=null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            //说明，在关闭外层流的时候，内层流也会自动进行关闭，关于内层流的关闭，我们可以省略。
//        fos.close();
//        fis.close();
        }


    }

    //实现文件复制的方法
    public void copyFileWithBuffered(String srcPath,String destPath){
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            //1.造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.造流
            //2.1 造节点流
            FileInputStream fis = new FileInputStream(srcFile);
            FileOutputStream fos = new FileOutputStream(destFile);
            //2.2 造缓冲流
            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            //3、复制的细节：读取、写入
            byte[] buffer = new byte[1024];
            int len;
            while((len=bis.read(buffer))!=-1){
                bos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、资源关闭
            //要求，先关闭外层的流，再关闭内层的流
            if(bos!=null){

                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if(bis!=null){
                try {
                    bis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

            //说明，在关闭外层流的时候，内层流也会自动进行关闭，关于内层流的关闭，我们可以省略。
//        fos.close();
//        fis.close();
        }
    }

    @Test
    public void testCopyFileWithBuffered(){
        long start = System.currentTimeMillis();
        String srcPath = "E:\\影音\\视频\\爱奇艺\\经典美剧鉴赏-越狱\\01视频.qsv";
        String destPath = "E:\\影音\\视频\\爱奇艺\\经典美剧鉴赏-越狱\\02视频.qsv";
        copyFileWithBuffered(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));   //161,字节流需要700
    }

    /*
        使用BufferedReader和BufferedWriter实现文本文件的复制
     */
    @Test
    public void testBufferedReaderBufferedWriter(){
        BufferedReader br = null;
        BufferedWriter bw = null;
        try {
            //创建文件和相应的流
            br = new BufferedReader(new FileReader(new File("dbcp.txt")));
            bw = new BufferedWriter(new FileWriter(new File("dbcp1.txt")));

            //读写操作

            //方式一：使用char[]数组
//            char[] cbuf = new char[1024];
//            int len;
//            while((len=br.read(cbuf))!=-1){
//                bw.write(cbuf,0,len);
//                bw.flush();
//            }

            //方式二：使用String
            String data;
            while((data=br.readLine())!=null){
                //方法一：不包含换行符
                //                bw.write(data);     //data中不包含换行符

                //方法二：
                bw.write(data);
                bw.newLine();  //提供换行的操作

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭资源
            if(bw!=null){

                try {
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(br!=null){

                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }

}
