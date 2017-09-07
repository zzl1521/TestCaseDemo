package com.my.demo.xlsx;

import java.lang.reflect.Field;

/**
 * Created by zhangzhile on 2017/8/30.
 */
public class test {

    public static void main(String[] args) {
        Class<User> userClass = User.class;
        Field[] declaredFields = userClass.getDeclaredFields();
        for (Field field : declaredFields) {
            System.out.println(field.getName());
        }
    }
}
