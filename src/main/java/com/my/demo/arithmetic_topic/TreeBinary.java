package com.my.demo.arithmetic_topic;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/11/14 17:21
 */
public class TreeBinary {


    public class User extends Thread{

        public User(String name) {
            super(name);
        }

        @Override
        public void run() {
            try {
                sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName());
        }

    }

   /* public static void main(String[] args) throws Exception{
        for (int i=0;i<10;i++){
            User user = new TreeBinary().new User(i+"线程");
            user.start();
            user.join();
        }
        User user1 = new TreeBinary().new User("线程1");
        user1.start();
        Thread user2=new Thread(() -> {
            System.out.println("线程2-start");
            try {
                user1.join();
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("现程2-end");
        });
        user2.start();
        user2.join();

        System.out.println("all 所有线程");
    }*/

    public static void main(String[] args)throws Exception {
            System.out.println("main is begin");
            for (int i = 0; i < 5; i++) {
                User user = new TreeBinary().new User(i+"线程");
                user.start();
                synchronized (user) {
                    user.wait();
                }
            }
            System.out.println("main is end");
    }

}
