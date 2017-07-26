package com.my.demo.lock;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhangzhile on 2017/4/20.
 */
public class TestMain {

    /**
     * @param args
     */
    public static void main(String[] args) {

        long start = System.currentTimeMillis();
        VolatileTest volatileExample = new VolatileTest();
        List<Thread> threads = new ArrayList<Thread>();
        for (int i = 0; i < 300; i++) {
            Thread t1 = new Thread(volatileExample, "T" + i);
            threads.add(t1);
        }
        for (Thread thread : threads) {
            thread.start();
        }
        try {
            for (Thread thread : threads) {
                thread.join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        List<Integer> list = volatileExample.getList();
        System.out.println("一共："+list.size());
        System.out.println("用时 ： "+(System.currentTimeMillis()-start));

    }
}
