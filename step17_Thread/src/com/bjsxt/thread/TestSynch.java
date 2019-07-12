package com.bjsxt.thread;

public class TestSynch {
    public static void main(String[] args) {
        Ticket t = new Ticket();

        Thread t1 = new Thread(t,"A车站");
        Thread t2 = new Thread(t,"B车站");
        Thread t3 = new Thread(t,"C车站");

        t1.start();
        t2.start();
        t3.start();
    }
}
