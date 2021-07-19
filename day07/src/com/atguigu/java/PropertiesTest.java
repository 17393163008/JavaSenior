package com.atguigu.java;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author pqq
 * @create ${year}-06-17 9:58
 */
public class PropertiesTest {
    public static void main(String[] args) throws IOException {
        FileInputStream fis = null;
        try {
            Properties prop = new Properties();

            fis = new FileInputStream("jdbc.properties");
            prop.load(fis);  //加载流对应的文件

            String name = prop.getProperty("name");
            System.out.println(name);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if(fis!=null){

                fis.close();
            }
        }

    }
}
