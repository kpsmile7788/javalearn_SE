package org.wm.pandc;

public class Test1 {

	public static void main(String[] args) {
		Goods good = new Goods();
		
		Customer c = new Customer(good);
		Producer p = new Producer(good);
		
		Thread t1 = new Thread(c);
		Thread t2 = new Thread(p);
		
		t1.start();
		t2.start();
	}
}
