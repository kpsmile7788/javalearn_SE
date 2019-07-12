package org.wm.blockingqueue;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class TestBlockingQueue {
    public static void main(String[] args) {
        final ProduceFactory o = new ProduceFactory();

        for (int i = 0; i < 5; i++) {
            new Thread(()->{
                while (true){
                    o.custom();
                }
            },"消费"+i).start();
            int finalI = i;
            new Thread(()->{
                while (true){
                    o.produce(""+ finalI);
                }
            },"生产"+i).start();
        }
    }
}

class ProduceFactory {

    private BlockingDeque bd;
    private int max_size = 10;

    public ProduceFactory() {
        bd = new LinkedBlockingDeque(max_size);
    }

    public ProduceFactory(int max_size) {
        this.max_size = max_size;
        bd = new LinkedBlockingDeque(max_size);
    }

    public void custom() {

        String s = null;
        try {
            s = (String) bd.take();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "消费，编号为：" + s + ",当前数量为：" + bd.size());
    }

    public void produce(String name){
        try {
            bd.put(name);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"生产，编号为："+name+",当前数量为："+bd.size());
    }

}
