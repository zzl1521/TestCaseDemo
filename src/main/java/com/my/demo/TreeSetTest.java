package com.my.demo;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/8/14 15:47
 */
public class TreeSetTest {

    public AtomicInteger inc = new AtomicInteger();
    //public volatile int inc = 0;

    public void increase() {
        inc.getAndIncrement();
        //inc++;
    }

    public static void tet() throws InterruptedException {
//1、 创建CountDownLatch 对象， 设定需要计数的子线程数目
        final CountDownLatch latch = new CountDownLatch(3);
        System.out.println("主线程开始执行....");
        for (int i = 0; i < 3; i++) {
            new Thread() {
                @Override
                public void run() {
                    try {
                        System.out.println(Thread.currentThread().getName() + "  开始执行存储过程..");
                        Thread.sleep(2000);
                        System.out.println(Thread.currentThread().getName() + "  存储过程执行完毕...");
                        //2、子线程执行完毕，计数减1
                        latch.countDown();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                ;
            }.start();
        }
        System.out.println("等待子线程执行完毕...");
        //3、 当前线程挂起等待
        latch.await();
        System.out.println("主线程执行完毕....");
    }


    public void syscTest() {
        synchronized (this) {
            System.out.println("开始打印。。。。。" + Thread.currentThread().getName());
            try {
                System.out.println("开始等待："+System.currentTimeMillis());
                Thread.sleep(1000);
                System.out.println("结束等待："+System.currentTimeMillis());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println("主线程开始执行....");
        Integer count = 0;
        TreeSetTest treeSetTest = new TreeSetTest();
        for (int i = 0; i < 3; i++) {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    treeSetTest.syscTest();
                }

            };
            thread.start();
            thread.join();

        }

        //3、 当前线程挂起等待
        System.out.println("主线程执行完毕....");
    }
}
