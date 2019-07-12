package org.wm.bankversion2;

public class Account {
	
	private int balance;
	private String name;
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account(int balance, String name) {
		super();
		this.balance = balance;
		this.name = name;
	}
	public Account() {
		super();
	} 
	
	public synchronized void takeMoney(){
		if(this.getBalance() >= 200){
			this.setBalance(this.getBalance()-200);
			System.out.println(Thread.currentThread().getName()+"取款，余额为："+this.getBalance());
		} else {
			System.out.println(Thread.currentThread().getName()+"取款失败，余额为："+this.getBalance());
		}
	}
}
