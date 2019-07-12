package org.wm.bankversion3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ATMBank implements Runnable{

	private Account acc;

	private Lock lock = new ReentrantLock();

	public ATMBank(Account acc) {
		super();
		this.acc = acc;
	}

	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			lock.lock();
			if(acc.getBalance() >= 200){
				acc.setBalance(acc.getBalance()-200);
				System.out.println(Thread.currentThread().getName()+"取款，余额为："+acc.getBalance());
			} else {
				System.out.println(Thread.currentThread().getName()+"取款失败，余额为："+acc.getBalance());
			}
			lock.unlock();
		}
	}

}
