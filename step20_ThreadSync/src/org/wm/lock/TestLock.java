package org.wm.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {
    public static void main(String[] args) {
        final ProduceFactory pf = new ProduceFactory();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                int finalI = 1;
                while(true){
                    pf.produce("商品"+ finalI);
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    finalI++;
                }
            }).start();
            new Thread(()->{
                while(true){
                    pf.custom();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }
    }
}

class ProduceFactory{
    private List<String> list = new ArrayList<String>();
    private final int MAX_LIST_SIZE = 100;

    private Lock lock = new ReentrantLock();
    private Condition produceCond = lock.newCondition();
    private Condition customCond = lock.newCondition();

    public void custom(){
        lock.lock();
        try {
            while (list.size() == 0){
                try {
                    customCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            String s = list.remove(0);
            System.out.println(Thread.currentThread().getName()+"消费，编号为："+s+",当前数量为："+list.size());
            produceCond.signalAll();
        }finally {
            lock.unlock();
        }
    }

    public void produce(String name){
        lock.lock();
        try {
            while (list.size() == MAX_LIST_SIZE){
                try {
                    produceCond.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            list.add(name);
            System.out.println(Thread.currentThread().getName()+"生产，编号为："+name+",当前数量为："+list.size());
            customCond.signal();
        }finally {
            lock.unlock();
        }
    }

}
