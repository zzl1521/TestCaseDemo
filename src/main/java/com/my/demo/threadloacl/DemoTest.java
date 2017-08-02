package com.my.demo.threadloacl;

/**
 * Created by zhangzhile on 2017/5/17.
 */
public class DemoTest {

    public static void main(String[] args) {
        DemoThread demoThread = new DemoThread();
        Thread thread1 = new Thread(demoThread);
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(demoThread);
        thread2.setName("thread2");
        thread2.start();

        Thread thread3 = new Thread(demoThread);
        thread3.setName("thread3");
        thread3.start();
    }
}
