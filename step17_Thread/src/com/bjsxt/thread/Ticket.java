package com.bjsxt.thread;

public class Ticket implements Runnable{

    private int sum = 10;
    private int count = 0;

    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            synchronized (this){
                if(sum > 0 ){
                    System.out.println(Thread.currentThread().getName()+"出了第"+(++count)+"张票！");
                    sum--;
                }

                long a = (long)(Math.random()*400);
                try {
                    Thread.sleep(a);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
