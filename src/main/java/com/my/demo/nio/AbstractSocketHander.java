package com.my.demo.nio;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

/**
 * Created by zhangzhile on 2018/3/1.
 * 银行分流接口
 */
public abstract class AbstractSocketHander {

    private static final Logger LOGGER= LoggerFactory.getLogger(AbstractSocketHander.class);

    public void processDefault(SelectionKey key,int headLen)throws Exception {
        //从NIO信道中读出的数据长度
        try {
            ByteBuffer headBuffer = ByteBuffer.allocate(headLen);    //读取INT头信息的缓存池
            SocketChannel channel = (SocketChannel)key.channel();
            //读出INT数据头
            if (channel.read(headBuffer) == headLen) {
                int headVal = Integer.valueOf(new String(headBuffer.array()).trim());
                headBuffer.clear();
                //清空有效数据缓存池设置有效缓存池的大小
                ByteBuffer contentBuffer = ByteBuffer.allocate(headVal);
                //循环读满缓存池以保证数据完整性
                int contentLen = channel.read(contentBuffer);
                while (contentLen != headVal) {
                    contentLen += channel.read(contentBuffer);
                }
                String content=new String(contentBuffer.array()).trim();
                LOGGER.info("socket 报文[{}]",content);
                //if(StringUtils.isNotBlank(content)){
                    String result=this.post(content);
                    // 返回数据
                    result = new String(ReportUtils.int2byte(result.getBytes("UTF-8").length, headLen)) + result;
                    ByteBuffer sBuffer = ByteBuffer.allocate(result.getBytes("UTF-8").length);
                    sBuffer.put(result.getBytes("UTF-8"));
                    sBuffer.flip();
                    channel.write(sBuffer);
                    channel.close();
                //}
            }
        } catch (Exception e) {
            LOGGER.error("socket error ",e);
        }
    }



    /**
     * 银行回调后统一回调内部网关
     * @return
     */
    public void hander(SelectionKey key)throws Exception{
        processDefault(key,8);
    }

    /**
     * 转http发送
     * @param message
     * @return
     * @throws Exception
     */
    public abstract String post(String message)throws Exception;



}
