package com.my.demo.volatile1;

import java.util.List;
import java.util.Vector;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by zhangzhile on 2017/4/20.
 */
public class VolatileTest implements Runnable {

    private volatile int testValue;
    private Lock lock = new ReentrantLock();

    private List<String> list = new Vector<String>();
    private List<Integer> list2 = new Vector<Integer>();


    public void run() {
        for (int i = 0; i < 5; i++) {
            //System.out.println(Thread.currentThread().getName() + ": " + i);
            if (Thread.currentThread().getName().equalsIgnoreCase("T1")) {
                add();
                list.add("循环：" + i + " " + Thread.currentThread().getName() + " set: " + testValue);
                //System.out.println(Thread.currentThread().getName()+" set: " + testValue);
                set();
            }
            if (Thread.currentThread().getName().equalsIgnoreCase("T2")) {
                //System.out.println(Thread.currentThread().getName()+" get: " + testValue);
                list.add("循环：" + i + " " + Thread.currentThread().getName() + " get: " + testValue);
                set();
                add();
                list.add("循环：" + i + " " + Thread.currentThread().getName() + " set: " + testValue);
                set();
                //System.out.println(Thread.currentThread().getName()+" set: " + testValue);
            }
            if (Thread.currentThread().getName().equalsIgnoreCase("T3")) {
                list.add("循环：" + i + " " + Thread.currentThread().getName() + " get: " + testValue);
                set();
                //System.out.println(Thread.currentThread().getName()+" get: " + testValue);
            }
        }

    }

    public void add() {
        try {
            lock.lock();
            ++testValue;
        } finally {
            lock.unlock();
        }
    }

    public void set() {
        list2.add(getTestValue());
    }


    public List<String> getList() {

        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public List<Integer> getList2() {
        return list2;
    }

    public void setList2(List<Integer> list2) {
        this.list2 = list2;
    }

    public int getTestValue() {
        return testValue;
    }

    public void setTestValue(int testValue) {
        this.testValue = testValue;
    }
}
