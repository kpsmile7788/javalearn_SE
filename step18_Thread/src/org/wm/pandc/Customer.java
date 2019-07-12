package org.wm.pandc;

public class Customer implements Runnable{

	private Goods good;
	
	public Customer(Goods good) {
		super();
		this.good = good;
	}
	public Customer() {
		super();
	}

	@Override
	public void run() {
		while(true){
			synchronized (good) {
				if(good.isProduce()){
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
				good.setCompany("wahaha");
				good.setName("矿泉水");
				good.setProduce(true);
				System.out.println("生产："+good.getCompany()+"---------"+good.getName());
				good.notify();
			}
		}
	}

}
