package com.bjsxt.thread;

public class TestControlThread {
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread1 = new MyThread();
        MyThread myThread2 = new MyThread();

        myThread1.start();
        myThread2.start();

        for (int i = 0; i < 5; i++) {
            if (i == 3){
                myThread1.join();
            }
            System.out.println("-------->"+Thread.currentThread());
        }
    }
}
