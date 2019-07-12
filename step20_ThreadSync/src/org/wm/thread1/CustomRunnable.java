package org.wm.thread1;

public class CustomRunnable implements Runnable {

    private ProduceFactory pf;

    public CustomRunnable(ProduceFactory pf) {
        this.pf = pf;
    }

    @Override
    public void run() {
    	while(true){
    		 pf.custome();
    	        try {
    				Thread.sleep(1000);
    			} catch (InterruptedException e) {
    				// TODO Auto-generated catch block
    				e.printStackTrace();
    			}
    	}
       
    }
}
