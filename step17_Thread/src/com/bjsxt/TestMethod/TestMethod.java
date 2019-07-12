package com.bjsxt.TestMethod;

import com.bjsxt.thread.MyThread;

public class TestMethod {
    public static void main(String[] args) {

        Thread t = Thread.currentThread();
        MyThread myThread = new MyThread();
        myThread.setPriority(Thread.MAX_PRIORITY);
        System.out.println(t);
        myThread.isAlive();
        myThread.start();
        myThread.isAlive();
        System.out.println(myThread);

        System.out.println("主线程优先级为："+t.getPriority());
        System.out.println("线程优先级最大值为："+Thread.MAX_PRIORITY);
        System.out.println("线程优先级最小值为："+Thread.MIN_PRIORITY);
        System.out.println("线程优先级默认值为："+Thread.NORM_PRIORITY);

//        t.setPriority(Thread.MAX_PRIORITY);
        System.out.println("主线程优先级为："+t.getPriority());

    }
}
