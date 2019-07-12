package org.wm.pandc;

public class Goods {

	private String company;
	private String name;
	private boolean isProduce;
	
	public Goods() {
		super();
	}
	public Goods(String company, String name, boolean isProduce) {
		super();
		this.company = company;
		this.name = name;
		this.isProduce = isProduce;
	}

	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public boolean isProduce() {
		return isProduce;
	}
	public void setProduce(boolean isProduce) {
		this.isProduce = isProduce;
	}

	
}
