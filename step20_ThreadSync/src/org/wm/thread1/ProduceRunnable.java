package org.wm.thread1;

public class ProduceRunnable implements Runnable {

    private ProduceFactory pf;

    public ProduceRunnable(ProduceFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
        int i = 0;
        while(true){
            pf.produce("商品"+i);
            i++;
            try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
    }
}
