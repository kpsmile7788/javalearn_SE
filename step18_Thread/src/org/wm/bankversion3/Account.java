package org.wm.bankversion3;

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
}
