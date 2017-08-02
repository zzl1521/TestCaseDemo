package com.my.demo.scoket3;

import com.my.demo.scoket2.ReportUtil;

import java.io.*;
import java.net.Socket;

/**
 * socket 工具类
 */
public class SocketUtils {

    //private final static Logger log = LoggerFactory.getLogger(SocketUtils.class);


    /**
     * socket客户端发送请求
     *
     * @param ip
     * @param port
     * @param context
     * @return
     */
    public static String sendSocketClient(String ip, String port, int headLen, String charset, String context) {
        Socket socket = null;
        PrintWriter printWriter = null;
        InputStream in = null;
        ByteArrayOutputStream stream = null;
        try {
            String dataLength = String.valueOf(context.getBytes().length);
            if (dataLength.length() > headLen) {
                throw new IllegalArgumentException("报文长度超限，最大长度不能超过" + headLen + "位数");
            }
            socket = new Socket(ip, new Integer(port));
            socket.setSoTimeout(5000);
            /**
             *  发送报文
             */
            byte[] b_context = context.getBytes();
            byte[] b_contextLength = ReportUtil.int2byte(b_context.length, headLen);
            stream = new ByteArrayOutputStream(b_context.length + headLen);
            stream.write(b_contextLength);// 交易报文长度
            stream.write(b_context);
            String message = new String(stream.toByteArray());
            /*if (log.isDebugEnabled()) {
                log.debug("发送报文为: " + message);
            }*/

            /**
             * socket发送请求
             */
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream(), charset), true);
            printWriter.print(message);
            printWriter.flush();
            socket.shutdownOutput();

            /**
             * 处理返回报文
             */
            // 读取报文头部
            in = socket.getInputStream();
            byte[] b_totalLength = new byte[headLen];// 报文总长度
            in.read(b_totalLength);
            int totalLength = ReportUtil.byte2int(b_totalLength);
            // 读取报文内容
            byte[] returnContent = new byte[totalLength];
            in.read(returnContent);
            String result = new String(returnContent, charset);
            /*if (log.isDebugEnabled()) {
                log.debug("返回报文总长度:" + totalLength + "，返回内容:" + result);
            }*/
            socket.shutdownInput();
            return result;
        } catch (Exception e) {
            //log.error("socket异常 , ip:" + ip + ",port:" + port + ",msg:" + context, e);
        } finally {
            try {
                if (printWriter != null) {
                    printWriter.close();
                }
                if (in != null) {
                    in.close();
                }
                if (stream != null) {
                    stream.close();
                }
                if (socket != null) {
                    socket.close();
                }
            } catch (IOException e) {
                //log.error("socket异常 , ip:" + ip + ",port:" + port + ",msg:" + context, e);
            }
        }
        return null;
    }


    /*public static void main(String[] args) {
        System.out.println(sendSocketClient("127.0.0.1", "8587", 8, "GBK", "您好123abc"));
    }*/

}
