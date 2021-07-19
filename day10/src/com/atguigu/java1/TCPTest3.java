package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP的网络编程
 * 例题三、从客户端发送文件给服务器，服务器保存到本地，并返回“发送成功”给客户端
 * 并关闭相应的连接
 *
 * @author pqq
 * @create ${year}-06-19 22:56
 */
public class TCPTest3 {
    /*

    这里涉及到的异常应该使用try-catch-finally进行处理
     */

    @Test
    public void client() throws IOException {
        //1
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

        //2
        OutputStream os = socket.getOutputStream();

        //3
        FileInputStream fis = new FileInputStream(new File("美女.png"));

        //4
        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        //关闭数据的输出
        socket.shutdownOutput();

        //5、接收来自服务器端的数据，并显示在控制台上
        InputStream is = socket.getInputStream();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        byte[] buffer1 = new byte[20];
        int len1;
        while((len=is.read(buffer1))!=-1){
            baos.write(buffer1,0,len);
        }

        System.out.println(baos.toString());

        //6

        baos.close();
        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        //1
        ServerSocket ss = new ServerSocket(9090);
        //2
        Socket socket = ss.accept();
        //3
        InputStream is = socket.getInputStream();
        //4
        FileOutputStream fos = new FileOutputStream(new File("美女3.png"));
        //5
        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }
        //6、服务器端给予客户端反馈
        OutputStream os = socket.getOutputStream();
        os.write("你好，美女，照片已收到，非常漂亮！".getBytes());


        os.close();
        fos.close();
        is.close();
        ss.close();
        socket.close();

    }
}
