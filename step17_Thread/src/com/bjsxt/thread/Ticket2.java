package com.bjsxt.thread;

public class Ticket2 implements Runnable{

    private int sum = 10;
    private int count = 0;

    @Override
    public void run() {
        saleTick();
    }

    private synchronized void saleTick(){
        for (int i = 0; i < 50; i++) {
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
