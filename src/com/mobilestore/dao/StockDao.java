package com.mobilestore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import com.mobilestore.model.Mobile;
import com.mobilestore.util.DBUtil;

public class StockDao {
	
	public boolean insertStock(Mobile mobile) {
		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("INSERT INTO STOCK VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, mobile.getBrand());
			pstmt.setString(2, mobile.getMobileId());
			pstmt.setString(3,  mobile.getMobileName());
			pstmt.setInt(4, mobile.getQuantityOnHand());
			pstmt.setDouble(5,  mobile.getUnitPrice());
			
			if (pstmt.executeUpdate() == 1) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	
	public String generateMobileId(String mobileName) {
		
		int seqMobileId = 0;
		String generatedMobileId = "";
		
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			stmt.executeUpdate("INSERT INTO SEQ_MOBILE_ID VALUES()");
			ResultSet rs = stmt.executeQuery("SELECT LAST_INSERT_ID()");
			
			if (rs.next())
				seqMobileId = rs.getInt(1);
			
			generatedMobileId += mobileName.substring(0, 2);
			generatedMobileId += seqMobileId;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return generatedMobileId;
	}
	
	
	
	public boolean increaseStock(String mobileId, int addedQuantity) {
		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE STOCK SET Quantity_On_Hand = Quantity_On_Hand + ? WHERE Mobile_Id = ?");
			pstmt.setInt(1, addedQuantity);
			pstmt.setString(2, mobileId);
			
			if (pstmt.executeUpdate() == 1) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
				
		return status;
	}
	
	
	
	
	public boolean updateStock(String mobileId, int soldQuantity) {
		
		boolean status = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("UPDATE STOCK SET Quantity_On_Hand = Quantity_On_Hand - ? WHERE Mobile_Id = ?");
			pstmt.setInt(1, soldQuantity);
			pstmt.setString(2, mobileId);
			
			if (pstmt.executeUpdate() == 1) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	
	
	public Mobile getStockById(String mobileId) {
		
		Mobile mobile = null;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("SELECT * FROM STOCK WHERE Mobile_Id = ?");
			pstmt.setString(1, mobileId);
			
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				mobile = new Mobile();
				mobile.setBrand(rs.getString(1));
				mobile.setMobileId(rs.getString(2));
				mobile.setMobileName(rs.getString(3));
				mobile.setQuantityOnHand(rs.getInt(4));
				mobile.setUnitPrice(rs.getDouble(5));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mobile;
	}
	
	
	
	public ArrayList<Mobile> getStocks() {
		
		ArrayList<Mobile> mobilesList = null;
		Connection conn = null;
		Statement stmt = null;
		
		try {
			conn = DBUtil.getConnection();
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM STOCK");
			
			mobilesList = new ArrayList<Mobile>();
			Mobile mobile = new Mobile();
			while (rs.next()) {
				mobile.setBrand(rs.getString(1));
				mobile.setMobileId(rs.getString(2));
				mobile.setMobileName(rs.getString(3));
				mobile.setQuantityOnHand(rs.getInt(4));
				mobile.setUnitPrice(rs.getDouble(5));
				
				mobilesList.add(mobile);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return mobilesList;
	}
	
	
	
	public boolean deleteStock(String mobileId) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		boolean status = false;
		
		try {
			conn = DBUtil.getConnection();
			pstmt = conn.prepareStatement("DELETE FROM STOCK WHERE Mobile_Id = ?");
			pstmt.setString(1, mobileId);
			
			if (pstmt.executeUpdate() == 1) status = true;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

}