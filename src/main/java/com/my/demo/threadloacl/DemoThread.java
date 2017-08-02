package com.my.demo.threadloacl;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by zhangzhile on 2017/5/17.
 */
public class DemoThread implements Runnable {

    // Atomic integer containing the next thread ID to be assigned
    private static final AtomicInteger nextId = new AtomicInteger(0);

    // Thread local variable containing each thread's ID
    private static final ThreadLocal<Integer> threadId =
            new ThreadLocal<Integer>() {
                @Override
                protected Integer initialValue() {
                    return nextId.getAndIncrement();
                }
            };

    // Returns the current thread's unique ID, assigning it if necessary
    public int getThreadId() {
        return threadId.get();
    }

    // Returns the current thread's starting timestamp
    private static final ThreadLocal<Long> startDate =
            new ThreadLocal<Long>() {
                protected Long initialValue() {
                    return System.currentTimeMillis();
                }
            };

    @Override
    public void run() {
        System.out.println(String.format("线程：%s ,自增：%s , 时间：%s",
                Thread.currentThread().getName(),getThreadId(), startDate.get()));
        LogFactory.setTxId(Thread.currentThread().getName());
        try {
            TimeUnit.SECONDS.sleep((int) Math.rint(Math.random() * 10));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if ("thread1".equals(LogFactory.getTxId())){
            LogFactory.setTxId("123");
        }

        System.out.println(String.format("线程：%s ,自增：%s , 时间：%s, txid:%s",
                Thread.currentThread().getName(),getThreadId(), startDate.get(),LogFactory.getTxId()));
    }
}

