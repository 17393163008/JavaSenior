package com.atguigu.java;

import org.junit.Test;

import java.io.*;

/**
 *  测试FileInputStream和FileOutputStream的使用
 *
 *  结论：
 *      1、对于文本文件（.txt, .java, .c, .cpp），使用字符流来处理文件
 *      2、对于非文本文件(.jpg, .mp3, .mp4, .avi, ...)，使用字节流来处理文件
 *
 *
 * @author pqq
 * @create ${year}-06-18 17:37
 */
public class FileInputOutputStreamTest {
    //使用字节流FileInputStream可能出现文本乱码
    @Test
    public void testFileInputStream() {
        FileInputStream fis = null;
        try {
            //1.造文件
            File file = new File("hello.txt");

            //2.造流
            fis = new FileInputStream(file);

            //3.读数据
            byte[] buffer = new byte[5];
            int len;   //记录每次读取的字节的个数
            while((len = fis.read(buffer))!=-1){
                String str = new String(buffer, 0, len);
                System.out.print(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭资源
            if(fis!=null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    /*
    实现对图片的复制操作
     */
    @Test
    public void testFileInputOutputStream() {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、造文件
            File srcFile = new File("美女.png");
            File destFile = new File("美女1.png");

            //2.造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3、复制的过程
            byte[] buffer = new byte[5];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            if(fos!=null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    //指定路径下文件的复制

    public void copyFile(String srcPath, String destPath){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            //1、造文件
            File srcFile = new File(srcPath);
            File destFile = new File(destPath);

            //2.造流
            fis = new FileInputStream(srcFile);
            fos = new FileOutputStream(destFile);

            //3、复制的过程
            byte[] buffer = new byte[1024];
            int len;
            while((len=fis.read(buffer))!=-1){
                fos.write(buffer,0,len);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //4、关闭流
            if(fos!=null){

                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fis!=null){

                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    @Test
    public void testCopyFile(){
        long start = System.currentTimeMillis();
        String srcPath = "E:\\影音\\视频\\爱奇艺\\经典美剧鉴赏-越狱\\01视频.qsv";
        String destPath = "E:\\影音\\视频\\爱奇艺\\经典美剧鉴赏-越狱\\02视频.qsv";
        copyFile(srcPath,destPath);
        long end = System.currentTimeMillis();
        System.out.println("复制操作花费的时间为："+(end-start));
    }
}
