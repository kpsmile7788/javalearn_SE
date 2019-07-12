package org.wm.bankversion3;

public class TestM {
	public static void main(String[] args) {
		Account acc = new Account(1000,"张三");
		
		ATMBank atm = new ATMBank(acc);
		
		Thread t1 = new Thread(atm,"张三");
		Thread t2 = new Thread(atm,"张三妈");
		
		t1.start();
		t2.start();
	}
}
