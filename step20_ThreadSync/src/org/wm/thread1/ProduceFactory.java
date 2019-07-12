package org.wm.thread1;

import java.util.ArrayList;
import java.util.List;

public class ProduceFactory {

    private List<String> list = new ArrayList<String>();
    private final int MAX_LIST_SIZE = 100;
    
    public List<String> getList() {
        return list;
    }

    public void setList(List<String> list) {
        this.list = list;
    }

    public synchronized void produce(String proName){
    	while(list.size() >= MAX_LIST_SIZE){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        list.add(proName);
        System.out.println("当前线程为："+Thread.currentThread().getName()+",目前生产的商品数量为："+list.size());
        this.notify();
    }

    public synchronized void custome(){
    	while(list.size()==0){
    		try {
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
        String cus = list.remove(0);
        System.out.println("当前线程为："+Thread.currentThread().getName()+",目前消费的商品为："+cus);
        this.notify();
    }
}
