package org.wm.threadpandg;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestPool {
    public static void main(String[] args) {

//        ExecutorService es = Executors.newCachedThreadPool();
//        ExecutorService es = Executors.newSingleThreadExecutor();
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 20; i++) {
            final int finalI = i;
            es.submit(
                    ()->{
                        System.out.println("线程开始！"+ finalI);
                        try {
                            Thread.sleep(200);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        System.out.println("线程结束！"+ finalI);
                    }
            );
        }
        es.shutdown();

    }
}
