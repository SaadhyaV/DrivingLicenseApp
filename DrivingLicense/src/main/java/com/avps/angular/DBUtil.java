package com.avps.angular;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	public static Connection getConnection() {
		Connection conn =null;
		String jdbcUrl="jdbc:mysql://localhost/DrivingLicenseApp";
		try {
			String driverName = "com.mysql.cj.jdbc.Driver";
			Class.forName(driverName);
			conn = DriverManager.getConnection(jdbcUrl, "root", "Kanha@2527");
			System.out.println("Connection Established!");
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("connection not established!:)");
		}
		return conn;
	}

	public static void main(String[] args) {
		new DBUtil();
		DBUtil.getConnection();
	}
	
}
