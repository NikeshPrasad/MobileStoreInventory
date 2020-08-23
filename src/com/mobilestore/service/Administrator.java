package com.mobilestore.service;

import java.util.ArrayList;
import java.util.Date;

import com.mobilestore.dao.SalesDao;
import com.mobilestore.dao.StockDao;
import com.mobilestore.model.Mobile;
import com.mobilestore.model.Sales;
import com.mobilestore.model.SalesReport;

public class Administrator {
	
	static StockDao stockDao = new StockDao();
	static SalesDao salesDao = new SalesDao();
	
	public String insertStock(Mobile mobile) {
		
		String result = "";
		
		if (mobile != null && mobile.getMobileName().length() >= 2) {
			String mobileId = stockDao.generateMobileId(mobile.getMobileName());
			mobile.setMobileId(mobileId);
			
			if (stockDao.insertStock(mobile)) result = mobile.getMobileId();
			else
				result = "Failed to add mobile in stock";
		} else 
			result = "Mobile not valid for insertion";
		
		return result;
	}
	
	
	
	public boolean increaseStock(String mobileId, int addedQuantity) {
		
		return increaseStock(mobileId, addedQuantity);
	}
	
	
	
	
	public boolean deleteStock(String mobileId) {
		
		boolean status = false;
		
		if (stockDao.deleteStock(mobileId)) status = true;
		
		return status;
	}
	
	
	
	public Mobile getStockById(String mobileId) {
		
		return stockDao.getStockById(mobileId);
	}
	
	
	
	
	public ArrayList<Mobile> getStocks() {
		
		return stockDao.getStocks();
	}
	
	
	
	
	public String insertSales(Sales sales) {
		
		String message = null;
		
		if (sales == null) message = "Object not valid for insertion";
		else {
			Mobile stock = stockDao.getStockById(sales.getMobileId());
			
			if (stock == null) message = "Unknown product for sales";
			else {
				if (stock.getQuantityOnHand() < sales.getQuantitySold()) message = "Not enough stock in hand for sales";
				else {
					if (sales.getSalesDate().after(new Date())) message = "Invalid date";
					else {
						String salesId = salesDao.generateSalesId(sales.getSalesDate());
						sales.setSalesId(salesId);
						
						if (salesDao.insertSales(sales)) {
							if (stockDao.updateStock(sales.getMobileId(), sales.getQuantitySold())) {
								message = "Sales completed successfully";
							} else {
								message = "Error";
							}
						} else message = "Error";
					}
				}
			}
		}
		return message;
	}
	
	
	
	public ArrayList<SalesReport> getSalesReport() {
		return salesDao.getSalesReport();
	}

}
