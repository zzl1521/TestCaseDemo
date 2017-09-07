package com.my.demo.dubbo.spi;

/**
 * Created by zhangzhile on 2017/5/24.
 */
public class User {

    private String userName;

    private String age;

    public User(String userName,String age){
        this.age=age;
        this.userName=userName;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
