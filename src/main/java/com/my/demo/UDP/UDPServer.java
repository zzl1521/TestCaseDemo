package com.my.demo.UDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

/**
 * Created by zhangzhile on 2017/10/13.
 */
public class UDPServer {

    static final int INPORT = 1712;
    private byte[] buf = new byte[1000];
    private DatagramPacket dp = new DatagramPacket(buf, buf.length);
    private DatagramSocket socket;

    public UDPServer() {
        try {
            socket = new DatagramSocket(INPORT);// ����һ������Ϣ�Ķ��󣬶�����ÿ�ν�����Ϣ������һ��
            System.out.println("Server started");
            while (true) {
                socket.receive(dp);
                //���յ��ͻ��˵���Ϣ
                String rcvd = Dgram.toString(dp) + ",from address:" + dp.getAddress() + ",port:" + dp.getPort();
                System.out.println("From Client:" + rcvd);

                String echoString = "From Server Echoed:" + rcvd;
                DatagramPacket echo = Dgram.toDatagram(echoString,
                        dp.getAddress(), dp.getPort());
                //�����ݰ����͸��ͻ���
                socket.send(echo);
            }
        } catch (SocketException e) {
            System.err.println("Can't open socket");
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Communication error");
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UDPServer();
    }
}
