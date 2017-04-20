package com.my.demo.scoket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.lang.management.ManagementFactory;
import java.net.Socket;


public class ScoketClient {

    public static void main(String[] args) throws Exception, Throwable {

        /*Threads tt = new Threads();
        // 线程1
        new Thread(tt).start();
        // 线程2
        new Thread(tt).start();
        // 线程3
        new Thread(tt).start();
        */

        service();


    }

    public static String service() throws  IOException {

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        ScoketClient s = new ScoketClient();
        //向服务器端发送请求，服务器IP地址和服务器监听的端口号   119.253.49.219
        Socket client = new Socket("localhost", 8585);
        client.setSoTimeout(5 * 1000);
        //通过printWriter 来向服务器发送消息
        PrintWriter printWriter = new PrintWriter(new OutputStreamWriter(client.getOutputStream(),"UTF-8"),true);
        System.out.println("连接已建立...");
        //发送消息
        //printWriter.println("{'txnType':'12','enterpriseNo':'10000','respCode':'00','accNo':'6216261000000000018',' queryId':'100263335649','merId':'777290058111103','version':'1.0','settleDate':'1105','txnAmt':'100','signMethod':'01','signature':'tjoqQIbeqi3P8uoC/NOWKxpGr0DhRZ+FZN4QldjEx1/a5cayqZ2cTkbvC1tnvvMrLCikAv6lT5b/sRPcJb2FFod7wwNkezoR7ntoZ4X2VPbtUML6kYJBzGBXRH2Hw0pBCuAHCI+AWxoou6JigYTFBFdYLl/oie9grQQ4Wpdg3u0=','settleAmt':'100','settleCurrencyCode':'156','traceTime':'1106125620','respMsg':'成功[0000000]','traceNo':'263137','orderId':'2015110612025852010000','txnTime':'20151106125620',' settType':'0',' oldMerid':'898120053110001'} ");
        //printWriter.println("{'accNo':'6216261000000000018','enterpriseNo':'11001','merId':'777290058111103','orderId':'100263336649521413','respCode':'Z13','respMsg':'报文格式错误,txnTime有误','settType':'1','signMethod':'01','signature':'ckZ1QlJreTc4M1pEcDkydWpWMVZaaWZDOTBDbElWdTBVOE8vUEx5cVlEZUtlUWtkNmxkV2dGK3lY\r\nTDB3aE16bW12V254QnV0bVpmYk54VlU4QTVuM0FXazVWSjhzeEwranF2YURHZlJOcVUrL001OUNr\r\nZ3NVWXNEaHF5cDBaYStlM1A1MkRHcTZVMFFOeTJpOWRidEtCUWRpTnViK0dUZFNOQ0ZaWmE2RkRr\r\nPQ==','txnAmt':'1','txnTime':'20160926125626','txnType':'12','version':'1.0'}");
        //printWriter.println("{'txnType':'12','enterpriseNo':'10000','respCode':'00','accNo':'6216261000000000018',' queryId':'100263335649','merId':'777290058111103','version':'1.0','settleDate':'1105','txnAmt':'100','signMethod':'01','signature':'tjoqQIbeqi3P8uoC/NOWKxpGr0DhRZ+FZN4QldjEx1/a5cayqZ2cTkbvC1tnvvMrLCikAv6lT5b/sRPcJb2FFod7wwNkezoR7ntoZ4X2VPbtUML6kYJBzGBXRH2Hw0pBCuAHCI+AWxoou6JigYTFBFdYLl/oie9grQQ4Wpdg3u0=','settleAmt':'100','settleCurrencyCode':'156','traceTime':'1106125620','respMsg':'成功[0000000]','traceNo':'263137','orderId':'2015110612025852010000','txnTime':'20151106125620',' settType':'0',' oldMerid':'898120053110001'} ");
        printWriter.println("{'enterpriseNo':'11001','merId':'777290058111103','orderId':'100263336649521413','origRespCode':'00','origRespMsg':'成功','queryId':'2016101117550244010103','respCode':'00','respMsg':'成功[000000]','settleAmt':'1','settleCurrencyCode':'156','settleDate':'1011','signMethod':'01','signature':'ZmF2bld1Y2tNTkx3M1IrcGs2QnBubmc0c3ZkOTZUUWc1WTFYRDZHT0tBRVFNaXBJQzA1M3RwRFo4bVhmUWQxR1RydlRJaUtrbFFaSHhSNnh3V0NKQTBXaVZqL2VrTktxN0kyZ0krWlhOR0Y3UGVBTGd3bVk1d3BIVTQxb3R0eitPTkVOVFpxbjU1VzBGWkJwTTdTWGxTdUV1Mmpjd0RlNFBVckpjWlQwMjRVPQ==','traceTime':'161011175507','txnAmt':'1','txnTime':'20161011175507','txnType':'00','version':'1.0'}");

        printWriter.flush();
        client.shutdownOutput();
        //InputStreamReader是低层和高层串流之间的桥梁
        //client.getInputStream()从Socket取得输入串流
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());
        //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder
        BufferedReader reader = new BufferedReader(streamReader);
        String advice ="";
        String reply = null;
        while (!((reply = reader.readLine()) == null)) {
            advice += reply;
        }
        System.out.println("接收到服务器的消息 ："+advice);
        reader.close();
        return advice;
    }















    /**
     * 服务器通知
     * @throws IOException
     */
    public static void notifyed() throws  IOException {

        //向服务器端发送请求，服务器IP地址和服务器监听的端口号   119.253.49.219
        Socket client = new Socket("192.168.1.87", 8289);

        //通过printWriter 来向服务器发送消息
        PrintWriter printWriter = new PrintWriter(client.getOutputStream());
        System.out.println("连接已建立...");

        //发送消息
        // printWriter.println("{'txnType':'12','enterpriseNo':'10000','respCode':'00','accNo':'6216261000000000018',' queryId':'100263335649','merId':'777290058111103','version':'1.0','settleDate':'1105','txnAmt':'100','signMethod':'01','signature':'tjoqQIbeqi3P8uoC/NOWKxpGr0DhRZ+FZN4QldjEx1/a5cayqZ2cTkbvC1tnvvMrLCikAv6lT5b/sRPcJb2FFod7wwNkezoR7ntoZ4X2VPbtUML6kYJBzGBXRH2Hw0pBCuAHCI+AWxoou6JigYTFBFdYLl/oie9grQQ4Wpdg3u0=','settleAmt':'100','settleCurrencyCode':'156','traceTime':'1106125620','respMsg':'成功[0000000]','traceNo':'263137','orderId':'2015110612025852010000','txnTime':'20151106125620',' settType':'0',' oldMerid':'898120053110001'} ");
        printWriter.println("{'accNo':'6216261000000000018','enterpriseNo':'11001','merId':'777290058111103','orderId':'100263336649521413','respCode':'Z1','respMsg':'企业流水号重复','settType':'1','signMethod':'01','signature':'dlFjVWxTalU3ZXZISHN5SDQwMTJSVWU0Rm40b25jemFrdG1vckdKOHpUMnFDWVpKejRJSzNHaUE3\r\nSjZEOUFvZGszNUlMOVEvdzloWHZhanh5TEtFckx4Y2dqSEdXY3FWQ3JaUi9rQU5JemI4SVE0a1kr\r\nYTVQdVN3RWdpcVZJaFUzakE3WUQweDZjVWw2NTlWTUtIbkUwTCswYVJNLzBWeTJ1WFNxSlhhM2JZ\r\nPQ==','txnAmt':'1','txnTime':'20160926125626','txnType':'12','version':'1.0'}");
        //printWriter.println("您好");
        printWriter.flush();

        //InputStreamReader是低层和高层串流之间的桥梁
        //client.getInputStream()从Socket取得输入串流
        InputStreamReader streamReader = new InputStreamReader(client.getInputStream());

        //链接数据串流，建立BufferedReader来读取，将BufferReader链接到InputStreamReder
        BufferedReader reader = new BufferedReader(streamReader);
        String advice ="";
        String reply = null;
        while (!((reply = reader.readLine()) == null)) {
            advice += reply;
        }

        System.out.println("接收到服务器的消息 ："+advice);
        reader.close();
    }

}
