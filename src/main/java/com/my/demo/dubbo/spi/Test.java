package com.my.demo.dubbo.spi;

/**
 * Created by zhangzhile on 2017/8/11.
 */
public class Test {

    public static void main(String[] args) throws Exception{
        IUserService userService =(IUserService) ExtensionLoader.getExtension(IUserService.class,"A");
        User user = userService.getUser();
        System.out.println(user.getUserName());
    }
}
