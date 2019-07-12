package org.wm.threadpandg;

public class TestGroup {
    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();
        ThreadGroup tg = new ThreadGroup("ONE");

        Thread t = new Thread(tg,myRunnable);
        Thread t1 = new Thread(myRunnable);
        System.out.println(t.getName()+"---->"+t);
        System.out.println(t1.getName()+"---->"+t1);

        t.start();
        t1.start();
    }
}
