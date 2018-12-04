package com.my.demo.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.*;

/**
 * TCP/IP的NIO非阻塞方式
 * 服务器端
 */
public class ServerSocket implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServerSocket.class);

    private Set<Integer> ports;
    private Map<Integer, ServerSocketChannel> serverSocketChannelMap;
    private Map<Integer, SocketChannel> socketChannelMap;
    //选择器，主要用来监控各个通道的事件
    private Selector selector;

    public ServerSocket(Set<Integer> ports) {
        this.serverSocketChannelMap = new HashMap<Integer, ServerSocketChannel>();
        this.socketChannelMap = new HashMap<Integer, SocketChannel>();
        this.ports = ports;
        init();
    }

    /**
     * 这个method的作用
     * 1：是初始化选择器
     * 2：打开多个通道
     * 3：给通道上绑定一个socket
     * 4：将选择器注册到通道上
     */
    public void init() {
        try {
            //创建选择器
            this.selector = SelectorProvider.provider().openSelector();
            for (Integer port : ports) {
                ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
                serverSocketChannel.configureBlocking(false);
                serverSocketChannel.socket().bind(new InetSocketAddress(port));
                serverSocketChannel.register(this.selector, SelectionKey.OP_ACCEPT);
                serverSocketChannelMap.put(port, serverSocketChannel);
                LOGGER.info("Socket started on port(s):[{}]",port);
            }
        } catch (Exception e) {
            LOGGER.info("Socket init error",e);
        }
    }

    /**
     * 这个方法是连接
     * 客户端连接服务器
     *
     * @throws IOException
     */
    public void accept(SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();
        Set<Integer> integers = serverSocketChannelMap.keySet();
        for (Integer port : integers) {
            ServerSocketChannel serverSocketChannel = serverSocketChannelMap.get(port);
            if (serverSocketChannel.equals(server)) {
                SocketChannel clientchannel = server.accept();
                clientchannel.configureBlocking(false);
                //OP_READ用于读取操作的操作集位
                clientchannel.register(this.selector, SelectionKey.OP_READ);
                socketChannelMap.put(port, clientchannel);
            }
        }
    }


    @Override
    public void run() {
        while (true) {
            try {
                //选择一组键，其相应的通道已为 I/O 操作准备就绪。
                this.selector.select();
                //返回此选择器的已选择键集
                Iterator selectorKeys = this.selector.selectedKeys().iterator();
                while (selectorKeys.hasNext()) {
                    //这里找到当前的选择键
                    SelectionKey key = (SelectionKey) selectorKeys.next();
                    //然后将它从返回键队列中删除   
                    selectorKeys.remove();
                    if (!key.isValid()) { // 选择键无效
                        continue;
                    }
                    if (key.isAcceptable()) {
                        //如果遇到请求那么就响应   
                        this.accept(key);
                    } else if (key.isReadable()) {
                        //读取客户端的数据   
                        this.read(key);
                    }
                }
            } catch (Exception e) {
                LOGGER.info("Socket 监听接受请求处理异常,",e);
            }
        }
    }

    /**
     * 从通道中读取数据
     * 并且判断是给那个服务通道的
     *
     * @throws IOException
     */
    public void read(SelectionKey key) throws IOException {
        //从NIO信道中读出的数据长度
        try {
            SocketHander.hander(key, socketChannelMap);
        } catch (Exception e) {
            LOGGER.info("Socket read error,",e);
        }
    }


    public void close() {
        try {
            Set<Integer> integers = serverSocketChannelMap.keySet();
            for (Integer port : integers) {
                ServerSocketChannel serverSocketChannel = serverSocketChannelMap.get(port);
                if (null != serverSocketChannel && !serverSocketChannel.isOpen()) {
                    serverSocketChannel.close();
                    LOGGER.info("Socket stoped on port(s):[{}]",port);
                }
            }
        } catch (Exception e) {
            LOGGER.info("Socket close error,",e);
        }
    }


    public static void main(String[] args) {
        Set<Integer> ports = new HashSet<Integer>();
        ports.add(8081);
        ports.add(8082);
        ServerSocket server = new ServerSocket(ports);
        Thread thread = new Thread(server);
        thread.start();
    }
}

