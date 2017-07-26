package com.my.demo.socket3;

import java.io.*;
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
                ss = new ServerSocket(8597);
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
                //客户端通知数据
                String clientData="";
                StringBuffer strBuffer=new StringBuffer(clientData);
				/*
				 * accept()方法会在等待用户的socket连接时闲置着，当用户链接
				 * 上来时，此方法会返回一个socket(在不同的端口上)以便与客户端
				 * 通信。Socket与ServerSocket的端口不同，因此ServerSocket可以 空闲出来等待其他客户端
				 */
                // 这个方法会停下来等待要求到达之后再继续
                Socket s = ss.accept();

                //接收客户端消息
                BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream(),"GBK"));
                String str = in.readLine().toString();
                System.out.println("read:" + str);

               /* InputStreamReader inputStream = new InputStreamReader(s.getInputStream(),"UTF-8");
                //InputStream inputStream = s.getInputStream();

                BufferedReader bufferedReader = new BufferedReader(inputStream);
                // 获得输出流，用于写回给客户端
                //读取数据
                String reply = null;
                while (!((reply = bufferedReader.readLine()) == null)) {
                    strBuffer.append(reply);
                }*/

               // System.out.println("报文总长度="+strBuffer);

                //向服务器发送消息
                PrintWriter out = new PrintWriter( new BufferedWriter( new OutputStreamWriter(s.getOutputStream(),"GBK")),true);
                for (int i=0;i<20;i++){
                    out.println("00000021您好server message0");
                }
                //关闭流
                out.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
