package com.my.demo.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
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
                ss = new ServerSocket(8585);
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

                InputStreamReader inputStreamReader=null;
                BufferedReader bufferedReader=null;
				/*
				 * accept()方法会在等待用户的socket连接时闲置着，当用户链接
				 * 上来时，此方法会返回一个socket(在不同的端口上)以便与客户端
				 * 通信。Socket与ServerSocket的端口不同，因此ServerSocket可以 空闲出来等待其他客户端
				 */
                // 这个方法会停下来等待要求到达之后再继续
                Socket s = ss.accept();
                inputStreamReader = new InputStreamReader(s.getInputStream());
                bufferedReader = new BufferedReader(inputStreamReader);
				/*while ((request = bufferedReader.readLine()) != null) {
					request += request;
					System.out.println("接收到了客户端的请求2.1:" + request);
				}*/
                String advice ="";
                String reply = null;
                while (!((reply = bufferedReader.readLine()) == null)) {
                    advice += reply;
                }
                advice=new String(advice.getBytes("GBK"),"UTF-8");
                System.out.println("接收到了客户端的请求:" + advice);
                PrintWriter printWriter = new PrintWriter(s.getOutputStream());
                //String advice = "I am Server";
                printWriter.println("{'accNo':'6216261000000000018','enterpriseNo':'11001','merId':'777290058111103','orderId':'100263336649521413','respCode':'Z1','respMsg':'企业流水号重复','settType':'1','signMethod':'01','signature':'dlFjVWxTalU3ZXZISHN5SDQwMTJSVWU0Rm40b25jemFrdG1vckdKOHpUMnFDWVpKejRJSzNHaUE3\r\nSjZEOUFvZGszNUlMOVEvdzloWHZhanh5TEtFckx4Y2dqSEdXY3FWQ3JaUi9rQU5JemI4SVE0a1kr\r\nYTVQdVN3RWdpcVZJaFUzakE3WUQweDZjVWw2NTlWTUtIbkUwTCswYVJNLzBWeTJ1WFNxSlhhM2JZ\r\nPQ==','txnAmt':'1','txnTime':'20160926125626','txnType':'12','version':'1.0'}");

                //printWriter.println(advice);
                printWriter.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }

    }

}
