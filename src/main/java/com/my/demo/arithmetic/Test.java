package com.my.demo.arithmetic;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/10/26 15:33
 */
public class Test {

    private static boolean flag=false;

    private static String obj="123";

    private static class Thread1 implements Runnable{
        @Override
        public void run() {
            synchronized (obj){
                System.out.println("生产消息");
                try {
                    Thread.sleep(200);
                    flag=true;
                    obj.notify();
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("生产消息-退出");
            }
        }
    }

    public static class Thread2 implements Runnable{
        @Override
        public void run() {
            synchronized (obj){
                while (!flag){
                    System.out.println("消费消息");
                    try {
                        Thread.sleep(200);
                        obj.wait();
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("消费消息-退出");
                }
                System.out.println("消费成功");
            }
        }
    }



    public static void main(String[] args)throws Exception {
        Thread thread1 = new Thread(new Thread2());
        thread1.start();
        Thread.sleep(100);
        Thread thread2 = new Thread(new Thread1());
        thread2.start();
        thread1.join();
        thread2.join();
        System.out.println("消费完成-end");
    }
}
