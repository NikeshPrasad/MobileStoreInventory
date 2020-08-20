package com.mobilestore.model;

public class Mobile {

	String brand;
	String mobileId;
	String mobileName;
	int quantityOnHand;
	double unitPrice;
	
	public Mobile() {
		super();
	}

	public Mobile(String brand, String mobileId, String mobileName, int quantityOnHand, double unitPrice) {
		super();
		this.brand = brand;
		this.mobileId = mobileId;
		this.mobileName = mobileName;
		this.quantityOnHand = quantityOnHand;
		this.unitPrice = unitPrice;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getMobileId() {
		return mobileId;
	}

	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}

	public String getMobileName() {
		return mobileName;
	}

	public void setMobileName(String mobileName) {
		this.mobileName = mobileName;
	}

	public int getQuantityOnHand() {
		return quantityOnHand;
	}

	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
}