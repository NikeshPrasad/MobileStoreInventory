package com.mobilestore.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection conn = null;
	
	public static Connection getConnection() {

		String url = "jdbc:mysql://localhost:3306/schema";
		String user = "user";
		String password = "password";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
		
	}
	
	public static void closeConnection() {
		
		try {
			if ( ! conn.isClosed()) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
