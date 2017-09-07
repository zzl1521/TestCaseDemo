package com.my.demo.dubbo.spi;


/**
 * Created by zhangzhile on 2017/8/11.
 */
public class UserServiceAImpl implements IUserService{

    @Override
    public User getUser() {
        System.out.println(UserServiceAImpl.class.getName());
        return new User("A","21");
    }
}
