package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class TestStatement {
	public static void main(String[] args) throws Exception {
		add();
//		search();
//    	update();
//		delete();

	}

	private static void delete() throws Exception {
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root" , "root");
		
		Statement st = conn.createStatement();
		
		String sql = "delete from marksheet where roll_no = 101";
		
		int i = st.executeUpdate(sql);
		
		conn.close();
		st.close();
		
		System.out.println("Data deleted Sucessfully..." + i);
		
	}

	private static void update() throws Exception {
	 Class.forName("com.mysql.cj.jdbc.Driver");
	 
	 Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result","root" , "root");
	 
	 Statement st = conn.createStatement();
	 
	 String sql = "update marksheet set name = 'Lala',maths = 78 where roll_no = 104";
	 
	 int i = st.executeUpdate(sql);
	 
	 conn.close();
	 st.close();
	 
	 System.out.println("Update syucessfully!!!");
		
	}

	private static void search() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/rsult" , "root" , "root");
		
		Statement st = conn.createStatement();
		
		String sql = "select * from marksheet";
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			
			System.out.println("\t" + rs.getInt(1));
			System.out.println("\t" + rs.getString(2));
			System.out.println("\t" + rs.getInt(3));
			System.out.println("\t" + rs.getInt(4));
			System.out.println("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
		}
		conn.close();
		st.close();
		
	}

	private static void add() throws Exception {
		
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result" , "root" , "root");
		
		Statement st = conn.createStatement();
		
		String sql = "insert into marksheet values(11 , 'Sapna' , 101 , 76 , 87, 67)";
		
		int i = st.executeUpdate(sql);
		
		conn.close();
		
		st.close();
		
		System.out.println("Data inserted Succesfully!!!!" + i);
		
	}
	
	
  }
