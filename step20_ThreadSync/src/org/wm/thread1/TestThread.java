package org.wm.thread1;

public class TestThread {

    public static void main(String[] args) {

        ProduceFactory pf = new ProduceFactory();
        Runnable pro = new ProduceRunnable(pf);
        Runnable cus = new CustomRunnable(pf);

        for (int i = 0; i < 10; i++) {
            new Thread(pro,"生产者"+i).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(cus,"消费者"+i).start();
        }
    }
}
