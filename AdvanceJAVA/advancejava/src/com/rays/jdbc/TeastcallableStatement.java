package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TeastcallableStatement {
	
	public static void main(String[] args) throws Exception {
		Class.forName("com.rays.jdbc.Driver");
		
		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root" , "root");
		
//		CallableStatemenet cs = conn.prepareCall("CALL serchid");
		
	}
	

}
