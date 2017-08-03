package com.my.demo.schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by zhangzhile on 2017/8/3.
 */
public class Test {

    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-config.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person.getId());
        System.out.println(person.getName());
        System.out.println(person.getAge());
    }
}
