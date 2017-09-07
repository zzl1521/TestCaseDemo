package com.my.demo.proxy;

/**
 * Created by zhangzhile on 2017/7/25.
 */
public class UserServiceImpl implements IUserService {


    @Override
    public void add(String str) throws Exception {
        System.out.println("收到参数 -- "+str);
    }
}
