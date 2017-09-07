package com.my.demo.dubbo.spi;

/**
 * Created by zhangzhile on 2017/8/11.
 */
public class UserServiceBImpl implements IUserService {
    @Override
    public User getUser() {
        System.out.println(UserServiceBImpl.class.getName());
        return new User("B","21");
    }
}
