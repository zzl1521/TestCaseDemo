package com.my.demo.objectStream.serializable;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhangzhile on 2017/5/25.
 */
public class Test {

    public static void main(String[] args) throws Exception {
        File f = new File("C:\\Users\\zhangzhile\\Desktop\\user.txt");
        ObjectOutputStream ops = new ObjectOutputStream(new FileOutputStream(f));
        //User user = new User("zhangsan", "15");
        Map map = new HashMap();
        map.put("userName", "lisi");
        map.put("age", "15");
        Object object = (Object) map;
        ops.writeObject(object);
        ops.close();

        HttpConnectionUtil.httpPostSerialObject("http://localhost:8180/webtest/UserServlet", 5000, 5000, object);


        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(f));//HttpServletRequest req对象
        Object value = ois.readObject();
        System.out.println("反序列化对象：" + value);
        Map user = (Map) value;
        System.out.println("反序列化对象getUserName：" + user.get("userName"));
        System.out.println("反序列化对象getAge：" + user.get("age"));


    }

    public void test(){
        notifyAll();
    }
}
