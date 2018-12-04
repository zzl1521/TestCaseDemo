package com.my.demo.threadloacl;

/**
 * Created by zhangzhile on 2017/5/17.
 */
public class DemoTest {

    public static void main(String[] args) {
        /*DemoThread demoThread = new DemoThread();
        Thread thread1 = new Thread(demoThread);
        thread1.setName("thread1");
        thread1.start();

        Thread thread2 = new Thread(demoThread);
        thread2.setName("thread2");
        thread2.start();

        Thread thread3 = new Thread(demoThread);
        thread3.setName("thread3");
        thread3.start();*/
        for (int i=0;i<2;i++){
            BankConThread bankConstants = new BankConThread();
            Thread thread1 = new Thread(bankConstants);
            thread1.start();
            Thread thread2 = new Thread(bankConstants);
            thread2.start();
            Thread thread3 = new Thread(bankConstants);
            thread3.start();
            Thread thread4 = new Thread(bankConstants);
            thread4.start();
            Thread thread5 = new Thread(bankConstants);
            thread5.start();
            Thread thread6 = new Thread(bankConstants);
            thread6.start();
        }


    }
}
