package com.my.demo.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.util.Map;
import java.util.Set;

/**
 * Created by zhangzhile on 2018/3/7.
 */
public class SocketHander {

    private static final Logger LOGGER = LoggerFactory.getLogger(SocketHander.class);

    private static Map<Integer, String> socketHander;

    private static SocketHanderConfig socketHanderConfig;

    public SocketHander(SocketHanderConfig socketHanderConfig){
        this.socketHanderConfig=socketHanderConfig;
        socketHander = socketHanderConfig.getSocketHander();
    }

    public static void hander(SelectionKey key, Map<Integer, SocketChannel> socketChannelMap) {
        SocketChannel channel = (SocketChannel) key.channel();
        try {
            Set<Integer> integers = socketChannelMap.keySet();
            for (Integer port : integers) {
                SocketChannel socketChannel = socketChannelMap.get(port);
                if (channel.equals(socketChannel)) {
                    String handerName = socketHander.get(port);
                    AbstractSocketHander abstractSocketHander = socketHanderConfig.getObject(handerName);
                    abstractSocketHander.hander(key);
                    return;
                }
            }
        } catch (Exception e) {
            LOGGER.error("socket 消息处理异常 ", e);
        } finally {
            try {
                if (channel != null) {
                    channel.close();
                }
                if (key != null) {
                    key.cancel();
                }
            } catch (IOException e) {
                LOGGER.error("socket channel and key 关闭异常 ", e);
            }
        }
    }
}
