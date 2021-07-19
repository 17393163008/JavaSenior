package com.atguigu.java1;

import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 实现TCP网络编程
 * 例题二：客户端发送文件到服务端，服务端将文件保存在本地
 *
 *
 * @author pqq
 * @create ${year}-06-19 22:41
 */
public class TCPTest2 {
    /*

    这里涉及到的异常应该使用try-catch-finally进行处理
     */

    @Test
    public void client() throws IOException {
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);

        OutputStream os = socket.getOutputStream();

        FileInputStream fis = new FileInputStream(new File("美女.png"));

        byte[] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer))!=-1){
            os.write(buffer,0,len);
        }

        fis.close();
        os.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket socket = ss.accept();

        InputStream is = socket.getInputStream();

        FileOutputStream fos = new FileOutputStream(new File("美女2.png"));

        byte[] buffer = new byte[1024];
        int len;
        while((len=is.read(buffer))!=-1){
            fos.write(buffer,0,len);
        }

        fos.close();
        is.close();
        socket.close();

    }
}
