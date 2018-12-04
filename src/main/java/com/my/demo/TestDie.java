package com.my.demo;

/**
 * @author: ZhangZhiLe
 * @date: Created in 2018/11/21 12:43
 */
public class TestDie {

    public static void test1(TestDie testDie,TestDie testDie2)throws Exception{
        synchronized (testDie){
            System.out.println("1111");
            Thread.sleep(200);
            synchronized (testDie2){
                System.out.println("2222");
            }
        }
    }

    public static void test2(TestDie testDie,TestDie testDie2)throws Exception{
        synchronized (testDie2){
            System.out.println("33333");
            Thread.sleep(200);
            synchronized (testDie){
                System.out.println("44444");
            }
        }
    }

    public static void main(String[] args) {
        TestDie testDie = new TestDie();
        TestDie testDie1 = new TestDie();

        new Thread(){
            @Override
            public void run() {
                try {
                    test1(testDie,testDie1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    test2(testDie,testDie1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }.start();


    }
}
