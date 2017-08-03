package com.my.demo.objectStream.serializable;

import java.io.Serializable;

/**
 * Created by zhangzhile on 2017/5/25.
 */
public class User implements Serializable{

    private String userName;

    private String age;

    public User(String userName, String age) {
        this.userName = userName;
        this.age = age;
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
