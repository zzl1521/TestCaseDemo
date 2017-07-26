package com.my.demo.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.Map;

/**
 * Created by zhangzhile on 2017/5/25.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//read object from stream 反序列化将stream生成Object对象
        ObjectInputStream ois = new ObjectInputStream(request.getInputStream());//HttpServletRequest req对象
        try {
            Object value = ois.readObject();
            System.out.println("反序列化对象：" + value);
            Map user = (Map) value;
            System.out.println("反序列化对象getUserName：" + user.get("userName"));
            System.out.println("反序列化对象getAge：" + user.get("age"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
