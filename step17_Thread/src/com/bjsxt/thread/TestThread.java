package com.bjsxt.thread;

public class TestThread {
    public static void main(String[] args) {
        MyThread myThread = new MyThread();
        myThread.start();
        for (int j = 0; j < 100; j++) {
            System.out.println("++>j="+j);
        }
    }
}
