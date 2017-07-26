package com.my.demo.volatile1;

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
        for (int i = 0; i < 50; i++) {
            VolatileTest volatileExample = new VolatileTest();
            Thread t1 = new Thread(volatileExample, "T1");
            Thread t2 = new Thread(volatileExample, "T2");
            Thread t3 = new Thread(volatileExample, "T3");

            t1.start();
            t2.start();
            t3.start();

            try {
                t1.join();
                t2.join();
                t3.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        /*List<String> list = volatileExample.getList();
        System.out.println(list.size());
        for (String str:list){
            System.out.println(str);
        }*/

            List<Integer> list2 = volatileExample.getList2();
            System.out.println(list2.size());
            Integer before = list2.get(0);
            for (Integer now : list2) {
                if (now < before) {
                    System.out.println("值有问题:"+list2.toString());
                }
                before = now;
            }
        }
        System.out.println("用时 ： " + (System.currentTimeMillis() - start));
    }
}
