package com.my.demo.scoket2;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ScoketServer {

    private static ServerSocket ss=null;

    public static void main(String[] args) throws Exception, Throwable {
        server();
    }

    static {
        // 让服务器端程序开始监听来自4242端口的客户端请求
        if (ss == null) {
            try {
                ss = new ServerSocket(8586);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("服务器启动...");
        }
    }

    public static void server() {

        // 服务器无穷的循环等待客户端的请求
        while (true) {

            try {
				
				/*
				 * accept()方法会在等待用户的socket连接时闲置着，当用户链接
				 * 上来时，此方法会返回一个socket(在不同的端口上)以便与客户端
				 * 通信。Socket与ServerSocket的端口不同，因此ServerSocket可以 空闲出来等待其他客户端
				 */
                // 这个方法会停下来等待要求到达之后再继续
                Socket s = ss.accept();
                InputStream inputStream = s.getInputStream();

                byte[] totals=new byte[8];
                inputStream.read(totals);

                byte[] len=new byte[1];
                inputStream.read(len);

                byte[] content=new byte[Integer.valueOf(new String(len))];
                inputStream.read(content);
                System.out.println("报文总长度="+new String(totals)+" 内容长度="+new String(len)+" 内容="+new String(content));

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
