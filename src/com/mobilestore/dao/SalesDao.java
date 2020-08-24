package com.mobilestore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import com.mobilestore.model.Sales;
import com.mobilestore.model.SalesReport;
import com.mobilestore.util.DBUtil;

public class SalesDao {
	
	public String generateSalesId(Date salesDate) {
		Connection conn = null;
		Statement stmt = null;
		
		int seqSalesId = 0;
		int salesDateLength = salesDate.toString().length();
		String generatedSalesId = salesDate.toString().substring(salesDateLength - 2, salesDateLength).toUpperCase();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO SalesIdSeq VALUES()");
			ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			rs.next();
			seqSalesId = rs.getInt(1);
			generatedSalesId += seqSalesId;
			return generatedSalesId;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public boolean insertSales(Sales sales) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean status = false;
		
		java.sql.Date salesDate = new java.sql.Date(sales.getSalesDate().getTime());
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO Sales VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, sales.getSalesId());
			pstmt.setDate(2,  salesDate);
			pstmt.setString(3, sales.getMobileId());
			pstmt.setInt(4, sales.getQuantitySold());
			pstmt.setDouble(5, sales.getSalesPricePerUnit());
			
			if (pstmt.executeUpdate() == 1) status = true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	
	
	public ArrayList<SalesReport> getSalesReport() {
		
		Connection conn = null;
		Statement stmt = null;
		
		ArrayList<SalesReport> salesList = new ArrayList<SalesReport>();
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM SalesReport");
			
			while (rs.next()) {
				SalesReport sr = new SalesReport();
				sr.setSalesID(rs.getString(1));
				sr.setSalesDate(rs.getDate(2));
				sr.setBrand(rs.getString(3));
				sr.setMobileId(rs.getString(4));
				sr.setMobileName(rs.getString(5));
				sr.setQuantitySold(rs.getInt(6));
				sr.setUnitPrice(rs.getDouble(7));
				sr.setSalesPricePerUnit(rs.getDouble(8));
				sr.setProfitPerUnit(rs.getDouble(9));
				sr.setTotalProfit(rs.getDouble(10));
				
				salesList.add(sr);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return salesList;
	}

}
