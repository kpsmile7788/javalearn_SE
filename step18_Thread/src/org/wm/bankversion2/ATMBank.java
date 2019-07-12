package org.wm.bankversion2;

public class ATMBank implements Runnable{

	private Account acc;
	
	public ATMBank(Account acc) {
		super();
		this.acc = acc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			acc.takeMoney();
		}
	}

}
