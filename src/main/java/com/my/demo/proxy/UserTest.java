package com.my.demo.proxy;

import java.lang.reflect.Method;

/**
 * Created by zhangzhile on 2017/7/25.
 */
public class UserTest {

    public static void main(String[] args) throws Throwable{
        IUserService userService = new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(userService);
        /*Method enclosingMethod = userService.getClass().getDeclaredMethod("add",String.class);
        handler.invoke(null,enclosingMethod,new Object[]{"a"});*/
        IUserService userServices = (IUserService)handler.getProxy();
        userServices.add("123");
    }
}
