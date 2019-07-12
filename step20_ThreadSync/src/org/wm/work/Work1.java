package org.wm.work;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Work1 {

    public static void main(String[] args) {

        final Printer p = new Printer();
        new Thread(()->{
            for (int i = 1; i <= 52; i++) {
                p.printNumMethod(i);
            }
        }).start();
        new Thread(()->{
            for (char i = 'A'; i <= 'Z'; i++) {
                p.printCharMethod(i);
            }
        }).start();

    }
}

class Printer{
    private boolean printNum = true;
    private boolean printChar = false;
    private int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition numCond = lock.newCondition();
    private Condition charCond = lock.newCondition();


    public void printNumMethod(int num){
            String s = "NUM";
            lock.lock();
            try{
                if (flag % 3 == 0) {
                    try {
                        numCond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(num);
                flag++;
                //System.out.println(s+"-----"+flag);
                charCond.signal();
            }finally {
                lock.unlock();
            }
    }

    public void printCharMethod(char ch){
            lock.lock();
            try{
                if (flag % 3 != 0){
                    try {
                        charCond.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(ch);
                flag++;
                //System.out.println("-----"+flag);
                numCond.signal();
            }finally {
                lock.unlock();
            }
        }
}