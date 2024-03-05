package com.rays.practice;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.rays.util.JDBCDataSource;

public class statementtest {
	
	public static void main(String[] args) throws Exception {
		
//	add();
//	update();
//	search();
	delete();
//	
	
	}

	private static void delete() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		
		Statement st = conn.createStatement();
		
		String sql = "delete from marksheet where id= 1";
		
		int i = st.executeUpdate(sql);
		
		System.out.println("data delete succesfully");
		
	}

	private static void update() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		
		Statement st = conn.createStatement();
		
		String sql = "update marksheet set name = 'vanu' where id = 1";
		
		int i = st.executeUpdate(sql);
		
		System.out.println("Update data sucessfully !!" + i);
		
		
	}

	private static void search() throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		
		Statement st = conn.createStatement();
		
		String sql = "select * from marksheet  where id = 15";
		
		ResultSet rs = st.executeQuery(sql);
		
		while (rs.next()) {
			System.out.println("id " + "name" + "roll_no" + "physics" + "chemistry" + "maths" );
			
			System.out.print( rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));
			
		}
		System.out.println("Data searched Succesfully!!!");
		
		
		
	}

	private static void add() throws Exception {
		 Connection conn = JDBCDataSource.getConnection();
		 
		 Statement st = conn.createStatement();
		 
		 String sql = "insert into marksheet values(15,'Shagun' , 115, 98,87,98)";
		 				 
		 int i	= st.executeUpdate(sql);
		 
		 System.out.println("data add sucessfully!!");
		 
		 
	}
	
	

}
