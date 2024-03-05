package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Myteststatement {
	
	public static void main(String[] args) throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result" , "root" , "root");
		
		Statement stmt = conn.createStatement();
		

		String sql = "Delete from marksheet where id = 2 ";
		
		int i = stmt.executeUpdate(sql);
		
		System.out.println("delete succesfully !!" + i);
	}

}
