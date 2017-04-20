package com.my.demo.scoket;

import java.io.IOException;

public class Threads implements Runnable{

    @Override
    public void run() {
       /* try {
            for (int i = 0; i < 3; i++) {
                ScoketClient.service();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }*/


        Thread current = Thread.currentThread();
        System.out.println("getPriority()="+current.getPriority());
        System.out.println("activeCount="+current.activeCount());
        System.out.println("getName()"+current.getName()+ " getId="+current.getId());
        System.out.println("getThreadGroup="+current.getThreadGroup());
        System.out.println("getStackTrace="+current.getStackTrace());
        System.out.println("hashCode="+current.hashCode());
        System.out.println("toString="+current.toString());
    }

}