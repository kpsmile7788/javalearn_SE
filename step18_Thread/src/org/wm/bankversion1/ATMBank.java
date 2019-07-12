package org.wm.bankversion1;

public class ATMBank implements Runnable{

	private Account acc;
	
	public ATMBank(Account acc) {
		super();
		this.acc = acc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			synchronized (acc) {
				if(acc.getBalance() >= 200){
					acc.setBalance(acc.getBalance()-200);
					System.out.println(Thread.currentThread().getName()+"取款，余额为："+acc.getBalance());
				} else {
					System.out.println(Thread.currentThread().getName()+"取款失败，余额为："+acc.getBalance());
				}
			}
		}
	}

}
