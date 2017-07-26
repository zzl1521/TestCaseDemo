package com.my.demo.volatile1;

/**
 * Created by zhangzhile on 2017/6/2.
 */
public class TestVolatile {

    private static boolean flag = false;

    public static void main(String[] args) {

        new Thread() {
            int i = 0;

            public void run() {
                long tm = System.currentTimeMillis();
                while (!flag) {
                    i++;
                    System.out.println(i);
                }

                System.out.println(System.currentTimeMillis() - tm);
            }
        }.start();

        new Thread() {
            public void run() {
                try {
                    Thread.sleep(1000);
                    flag = true;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}
