package com.my.demo.proxy.factory;

import com.my.demo.proxy.IUserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangzhile on 2017/8/3.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        IUserService userService = (IUserService) ctx.getBean("proxyFactoryBean"); //如果 加上&符号 "&proxyFactoryBean" 获取的是proxyFactoryBean本身的对象
        System.out.println("代理类："+userService.getClass()+"\n");
        userService.add("hello");
    }
}
