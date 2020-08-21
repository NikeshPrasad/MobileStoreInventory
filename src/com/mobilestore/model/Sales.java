package com.mobilestore.model;

import java.util.Date;

public class Sales {
	
	String salesId;
	Date salesDate;
	String mobileId;
	int quantitySold;
	double salesPricePerUnit;
	
	public Sales() {
		super();
	}
	
	public Sales(String salesId, Date salesDate, String mobileId, int quantitySold, double salesPricePerUnit) {
		super();
		this.salesId = salesId;
		this.salesDate = salesDate;
		this.mobileId = mobileId;
		this.quantitySold = quantitySold;
		this.salesPricePerUnit = salesPricePerUnit;
	}

	public String getSalesId() {
		return salesId;
	}
	public void setSalesId(String salesId) {
		this.salesId = salesId;
	}
	public Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getMobileId() {
		return mobileId;
	}
	public void setMobileId(String mobileId) {
		this.mobileId = mobileId;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	
}