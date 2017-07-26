package com.my.demo.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;
import java.net.InetAddress;

/**
 * *****启动完成客户端 ，从控制台输入消息，服务器便可接受*****
 * *****可以打开 cmd ： telnet 127.0.0.1 9099 输入即可接受*****
 * TCP/IP的NIO非阻塞方式
 * 客户端  
 * */
public class Client {

    //创建缓冲区   
    private ByteBuffer buffer = ByteBuffer.allocate(512);
    //访问服务器   

    public void query(String host, int port) throws IOException {
        InetSocketAddress address = new InetSocketAddress(InetAddress.getByName(host), port);
        SocketChannel socket = null;
        byte[] bytes = new byte[512];
        //byte[] bytes ="123".getBytes();
        while (true) {
            try {
                System.in.read(bytes);
                socket = SocketChannel.open();
                socket.connect(address);
                buffer.clear();
                buffer.put(bytes);
                buffer.flip();
                socket.write(buffer);
                buffer.clear();
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                if (socket != null) {
                    socket.close();
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Client().query("localhost", 9099);

    }
}
