package com.my.demo.volatile1;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by zhangzhile on 2017/6/2.
 */
public class VolatileTest2 {

    private static boolean flag = false;
    private static Set<String> set = new HashSet<String>();
    int a = 1;
    int b = 2;

    public void change() {
        a = 3;
        b = a;
    }

    public void print() {
        System.out.println("b=" + b + ";a=" + a);
        set.add("b=" + b + ";a=" + a);
        System.out.println("------------------"+set.toString());
    }

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                flag = true;
            }
        }).start();
        while (!flag) {
            final VolatileTest2 test = new VolatileTest2();
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.change();
                }
            }).start();

            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    test.print();
                }
            }).start();
        }

        System.out.println("------------------"+set.toString());
    }
}
