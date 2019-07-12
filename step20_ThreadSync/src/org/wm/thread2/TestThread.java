package org.wm.thread2;

import java.util.ArrayList;
import java.util.List;

public class TestThread {


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

class ProduceFactory {

    private List<String> list = new ArrayList<String>();
    private int max_size = 10;

    public ProduceFactory() {
    }

    public ProduceFactory(int max_size) {
        this.max_size = max_size;
    }

    public synchronized void custom(){
        while (list.size() == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        String s = list.remove(0);
        System.out.println(Thread.currentThread().getName()+"消费，编号为："+s+",当前数量为："+list.size());
        this.notify();
    }

    public synchronized void produce(String name){
        while(list.size() >= max_size){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        list.add(name);
        System.out.println(Thread.currentThread().getName()+"生产，编号为："+name+",当前数量为："+list.size());
        this.notify();
    }

}