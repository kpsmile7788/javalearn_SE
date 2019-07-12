package org.wm.pandc;

public class Producer implements Runnable{

	private Goods good;
	
	public Producer(Goods good) {
		super();
		this.good = good;
	}
	public Producer() {
		super();
	}

	@Override
	public void run() {
		while(true){
			synchronized (good) {
				if(!good.isProduce()){
					try {
						good.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				try {
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("消费："+good.getCompany()+"---------"+good.getName());
				good.setProduce(false);
				good.notify();
			}
		}
	}

}
