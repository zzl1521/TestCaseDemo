package com.my.demo.scoket2;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class ScoketClient {

    public static void main(String[] args) throws Exception, Throwable {

        Threads tt = new Threads();
        // 线程1
        new Thread(tt).start();
        // 线程2
        new Thread(tt).start();
        // 线程3
        new Thread(tt).start();

    }

    public static String service() throws IOException {

        OutputStream out = null;
        ByteArrayOutputStream stream = null;

        // 向服务器端发送请求，服务器IP地址和服务器监听的端口号 119.253.49.219
        Socket client = new Socket("192.168.18.74", 8587);
        client.setSoTimeout(5 * 1000);
        out = client.getOutputStream();

        byte[] b_version = "4".getBytes();
        byte[] b_merchantNo = "1120".getBytes();

        int totalLength = b_version.length + b_merchantNo.length ;
        byte[] b_totalLength = ReportUtil.int2byte(totalLength, 8);
        // stream = new ByteArrayOutputStream(totalLength);//TODO
        // 这里长度是否应该是totalLength+8?
        stream = new ByteArrayOutputStream(totalLength + 8);// TODO
        // 这里长度是否应该是totalLength+8?

        stream.write(b_totalLength);// 报文总长度
        stream.write(b_version);
        stream.write(b_merchantNo);
        System.out.println("【浦发代扣-本行交易】发送报文为:" + new String(stream.toByteArray()));
        out.write(stream.toByteArray());
        //out.flush();
        client.shutdownOutput();
        return null;
    }












    public String execute(String timeStamp, String merchantNo, String tradeContext) {

        Socket socket = null;
        OutputStream out = null;
        InputStream in = null;
        ByteArrayOutputStream stream = null;
        try {
            socket = new Socket("192.168.18.74", 8586);
            out = socket.getOutputStream();

            byte[] b_version = "1.0".getBytes();
            byte[] b_merchantNo = merchantNo.getBytes();
            byte[] b_timeStamp = timeStamp.getBytes();// 根据密钥交易获取
            byte[] b_tradeContext = tradeContext.getBytes();
            byte[] b_tradeLength = ReportUtil.int2byte(b_tradeContext.length, 8);

            int totalLength = b_version.length + b_merchantNo.length + b_timeStamp.length + b_tradeLength.length
                    + b_tradeContext.length;
            byte[] b_totalLength = ReportUtil.int2byte(totalLength, 8);
            // stream = new ByteArrayOutputStream(totalLength);//TODO
            // 这里长度是否应该是totalLength+8?
            stream = new ByteArrayOutputStream(totalLength + 8);// TODO
            // 这里长度是否应该是totalLength+8?

            stream.write(b_totalLength);// 报文总长度
            stream.write(b_version);
            stream.write(b_merchantNo);
            stream.write(b_timeStamp);
            stream.write(b_tradeLength);// 交易报文长度
            stream.write(b_tradeContext);
            System.out.println("【浦发代扣-本行交易】发送报文为:" + new String(stream.toByteArray()));
            out.write(stream.toByteArray());
            out.flush();
            socket.shutdownOutput();

            // 处理返回
            in = socket.getInputStream();
            // 报文总长度
            b_totalLength = new byte[8];
            in.read(b_totalLength);
            totalLength = ReportUtil.byte2int(b_totalLength);
            // 返回码
            byte[] b_returnCode = new byte[2];
            in.read(b_returnCode);

            String returnCode = new String(b_returnCode);// 系统返回码
            System.out.println("【浦发代扣-本行交易】返回报文总长度:" + totalLength + ":返回码:" + returnCode);

            if ("00".equals(returnCode)) {
                // 报文
                int respContextLength = totalLength - b_returnCode.length;
                byte[] b_respContext = new byte[respContextLength];
                in.read(b_respContext);

                return new String(b_respContext);
            } else {
                // 失败
                System.out.println("【浦发代扣-本行交易】返回报文失败");
            }
            socket.shutdownInput();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (in != null) {
                    in.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

}
