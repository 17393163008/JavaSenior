package com.atguigu.exer2;

import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * @author pqq
 * @create ${year}-06-18 11:07
 */
public class FileDemo {
    @Test
    public void test1() throws IOException {
        File file = new File("D:\\io\\io1\\hello.txt");
        //创建一个与file同目录的一个文件，文件名：haha.txt
        File file1 = new File(file.getParent(), "haha.txt");
        boolean newFile = file1.createNewFile();
        if(newFile){
            System.out.println("创建成功！");
        }
    }

    //输出目录下文件名为jpg的文件
    @Test
    public void test2(){
        File file = new File("d:\\code");
        String[] list = file.list();
        for(String filename:list){
            if(filename.endsWith(".jpg")){
                System.out.println(filename);
            }
        }
    }

}
