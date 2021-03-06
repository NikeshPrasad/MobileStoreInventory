package com.mobilestore.model;

import java.util.Date;

public class SalesReport {

	private String salesID;
	private Date salesDate;
	private String brand;
	private String mobileId;
	private String mobileName;
	private int quantitySold;
	private double unitPrice;
	private double salesPricePerUnit;
	private double profitPerUnit;
	private double totalProfit;
	
	public SalesReport() {
		super();
	}
	
	public String getSalesID() {
		return salesID;
	}
	
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	
	public Date getSalesDate() {
		return salesDate;
	}
	
	public void setSalesDate(Date salesDate) {
		this.salesDate = salesDate;
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
	
	public int getQuantitySold() {
		return quantitySold;
	}
	
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	
	public double getUnitPrice() {
		return unitPrice;
	}
	
	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}
	
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}

	public double getProfitPerUnit() {
		return profitPerUnit;
	}

	public void setProfitPerUnit(double profitPerUnit) {
		this.profitPerUnit = profitPerUnit;
	}

	public double getTotalProfit() {
		return totalProfit;
	}

	public void setTotalProfit(double totalProfit) {
		this.totalProfit = totalProfit;
	}
	
}