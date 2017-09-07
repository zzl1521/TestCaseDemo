package com.my.demo.proxy.factory;

import com.my.demo.proxy.IUserService;
import com.my.demo.proxy.MyInvocationHandler;
import com.my.demo.proxy.UserServiceImpl;
import org.springframework.beans.factory.FactoryBean;

/**
 * Created by zhangzhile on 2017/8/16.
 */
public class ProxyFactoryBean implements FactoryBean {

    @Override
    public Object getObject() throws Exception {
        IUserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        return (IUserService)handler.getProxy();
    }

    @Override
    public Class<?> getObjectType() {
        return null;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
