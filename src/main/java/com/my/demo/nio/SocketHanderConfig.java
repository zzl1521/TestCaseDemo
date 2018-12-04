package com.my.demo.nio;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

import java.util.Map;

/**
 * Created by zhangzhile on 2018/3/1.
 */
public class SocketHanderConfig implements ApplicationContextAware {

    //IFacadeExchange 接口实例配置
    private Map<Integer, String> socketHander;

    private static ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    public static <T> T getObject(String id) {
        return (T)applicationContext.getBean(id);
    }

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }




    public Map<Integer, String> getSocketHander() {
        return socketHander;
    }

    public void setSocketHander(Map<Integer, String> socketHander) {
        this.socketHander = socketHander;
    }
}
