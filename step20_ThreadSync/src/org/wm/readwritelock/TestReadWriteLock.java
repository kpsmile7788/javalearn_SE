package org.wm.readwritelock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestReadWriteLock {
    public static void main(String[] args) {
        final Operator o = new Operator();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true){
                    o.read();
                }
            },"读线程"+i).start();
            new Thread(()->{
                while (true){
                    o.write();
                }
            },"写线程"+i).start();
        }
    }
}

class Operator{
    private Lock lock = new ReentrantLock();

    public void read(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始读取数据。。。。。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取数据完毕。。。。。");
        }finally {
            lock.unlock();
        }
    }
    public void write(){
        lock.lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始写入数据。。。。。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写入数据完毕。。。。。");
        }finally {
            lock.unlock();
        }
    }
}
