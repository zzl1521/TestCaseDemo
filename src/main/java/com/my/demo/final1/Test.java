package com.my.demo.final1;

/**
 * Created by zhangzhile on 2017/5/24.
 */
public class Test {


    public User test1(final User user,final String string){
        System.out.println(string);
        User user1=user;
        user.setUserName("zhangsan");
        user1.setSex("女");
        return user1;
    }

    static class Thread1 implements Runnable{

        private User user;

        public Thread1(User user) {
            this.user = user;
        }

        public void run() {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            user.setUserName("zhangsan1");
            System.out.println("线程内1 - "+user.toString());
            user=new User();
            user.setUserName("zhangfan");
            System.out.println("线程内2 - "+user.toString());
        }
    }

    public static void main(String[] args) {
        User user = new User();
        user.setUserName("12345");
        user.setSex("男");
        new Thread(new Thread1(user)).start();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("线程外 - "+user.toString());
        User user1 = new Test().test1(user,null);
        if (user==user1){
            System.out.println(true);
        }else{
            System.out.println(false);
        }
        System.out.println(user.toString());
        System.out.println(user1.toString());
    }
}
