package com.bjsxt.runnable;

public class TestRunnable {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        Thread myThread = new Thread(myRunnable);
        myThread.start();
        for (int j = 0; j < 100; j++) {
            System.out.println("++>j="+j);
        }
    }
}
