package com.my.demo.threadloacl;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by zhangzhile on 2017/5/17.
 */
public class BankConThread implements Runnable {

    @Override
    public void run() {
        SimpleDateFormat sdf_time2 = BankConstants.getSdf_time2();
        try {
            Thread.sleep(1093);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Date date = new Date();
        System.out.println(sdf_time2.format(date));
        try {
            Thread.sleep(122);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            System.out.println(sdf_time2.format(sdf_time2.parse("2013-05-24 06:02:20")));
            Thread.sleep(1023);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(BankConstants.sdf_time2.format(new Date()));
        try {
            Thread.sleep(19);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(BankConstants.sdf_time2.format(date));
    }
}

