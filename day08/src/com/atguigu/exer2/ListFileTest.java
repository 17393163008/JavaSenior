package com.atguigu.exer2;

import java.io.File;

/**
 * @author pqq
 * @create ${year}-06-18 11:40
 */
public class ListFileTest {
    //递归：文件目录
    //打印出指定目录下的所有文件名称，包括子文件目录下的文件


    public static void main(String[] args) {
        //1、创建目录对象
        File dir = new File("D:\\io");

        //2、打印目录的子文件
        printFile(dir);
    }

    private static void printFile(File dir) {
        //打印目录的子文件
        File[] files = dir.listFiles();

        for(File f: files){
            if(f.isDirectory()){   //文件目录
                printFile(f);
            }else{
                System.out.println(f.getAbsolutePath());
            }
        }
    }
}
