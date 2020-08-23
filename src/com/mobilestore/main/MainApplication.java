package com.mobilestore.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.mobilestore.model.*;
import com.mobilestore.service.Administrator;

public class MainApplication {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		Administrator admin = new Administrator();
		int choice = 0;
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
		ArrayList<SalesReport> salesReport = null;
		
		do {
			System.out.println("1. Insert new stock");
			System.out.println("2. Delete Stock");
			System.out.println("3. Insert Sales");
			System.out.println("4. View Sales Report");
			System.out.println("0. Exit");
			
			System.out.print("Enter your Choice: ");
			choice = Integer.parseInt(br.readLine());
			
			switch (choice) {
			case 1:	Mobile mobile = new Mobile();
					System.out.print("Enter the brand name: ");
					mobile.setBrand(br.readLine());
					System.out.print("Enter mobile name: ");
					mobile.setMobileName(br.readLine());
					System.out.print("Enter quantity on hand: ");
					mobile.setQuantityOnHand(Integer.parseInt(br.readLine()));
					System.out.print("Enter price of each unit: ");
					mobile.setUnitPrice(Double.parseDouble(br.readLine()));
					
					String result = admin.insertStock(mobile);
					if(result.length() == 6) System.out.println("Mobile inserted successfully in the stock with id: " + result);
					else System.out.println(result);
					break;
					
					
			case 2:	System.out.print("Enter mobile id to be deleted: ");
					String mobileId = br.readLine();
					
					if (admin.deleteStock(mobileId)) System.out.println("Mobile deleted successfully from stock");
					else System.out.println("Failed to delete mobile from stock");
					break;
					
					
			case 3:	Sales salesObject = new Sales();
					System.out.print("Enter date (dd-mm-yyyy): ");
				    Date date = dateFormat.parse(br.readLine()); 
					salesObject.setSalesDate(date);
					System.out.print("Enter product id: ");
					salesObject.setMobileId(br.readLine());
					System.out.print("Enter quantity sold: ");
					salesObject.setQuantitySold(Integer.parseInt(br.readLine()));
					System.out.print("Enter sales price per unit: ");
					salesObject.setSalesPricePerUnit(Double.parseDouble(br.readLine()));
					System.out.println(admin.insertSales(salesObject));
					break;
					
					
			case 4:	salesReport = admin.getSalesReport();
					Iterator<SalesReport> iter = salesReport.listIterator();
					System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-22s | %-14s | %-16s | %-18s | %-16s |%n", "Sales ID", "Sales Date", "Brand", "Mobile Id", "Mobile Name", "Quantity sold", "Price per unit", "Sales price/unit", "Profit amount");
					while(iter.hasNext()) {
						SalesReport sr = iter.next();
						System.out.printf("| %-12s | %-12s | %-12s | %-12s | %-22s | %-14d | %-16.2f | %-18.2f | %-16.2f |%n", sr.getSalesID(), dateFormat.format(sr.getSalesDate()), sr.getBrand(), sr.getMobileId(), sr.getMobileName(), sr.getQuantitySold(), sr.getUnitPrice(), sr.getSalesPricePerUnit(), sr.getProfitAmount());
					}
					break;
					
			case 0: System.out.println("Exiting...");
					break;
					
					
			default:System.out.println("Please enter a valid option.");
					break;
			}
			
		} while (choice != 0);
		
		br.close();
	}

}