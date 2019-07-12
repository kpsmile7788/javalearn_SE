package org.wm.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class TestReadWriteLock2 {
    public static void main(String[] args) {
        final Operator2 o = new Operator2();

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

class Operator2{
    //private Lock lock = new ReentrantLock();
    private ReentrantReadWriteLock rw = new ReentrantReadWriteLock();

    public void read(){
        rw.readLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始读取数据。。。。。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"读取数据完毕。。。。。");
        }finally {
            rw.readLock().unlock();
        }
    }
    public void write(){
        rw.writeLock().lock();
        try{
            System.out.println(Thread.currentThread().getName()+"开始写入数据。。。。。");
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName()+"写入数据完毕。。。。。");
        }finally {
            rw.writeLock().unlock();
        }
    }
}
