package com.my.demo.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangzhile on 2017/4/20.
 */
public class VolatileTest implements Runnable {

    private Lock lock = new ReentrantLock();
    private List<Integer> list = new ArrayList<Integer>();

    public int tickets = 1000000;
    String str = new String("哈哈");

    public void run() {
        get();
    }

    public void get() {
        while (true) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (str) {
                if (tickets > 0) {
                    System.out.printf("%s线程正在卖出第%d张票\n", Thread.currentThread().getName(), tickets);
                    --tickets;
                    list.add(tickets);
                } else {
                    break;
                }
            }
        }
    }

    public void get1() {
        while (true) {
            try {
                Thread.sleep(0);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            try {
                lock.lock();
                if (tickets > 0) {
                    System.out.printf("%s线程正在卖出第%d张票\n", Thread.currentThread().getName(), tickets);
                    --tickets;
                    list.add(tickets);
                } else {
                    break;
                }
            } finally {
                lock.unlock();
            }
        }
    }

    public List<Integer> getList() {
        return list;
    }
}
