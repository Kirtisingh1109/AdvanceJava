package com.rays.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class TestpreparedStatement {
	
	public static void main(String[] args) throws Exception {
 
//		add(12, "Anus", 112, 58, 48, 72);
//		search();
		update(11, "Anuj", 111, 58, 48, 72);
//		findById(9);
//		delete(8);

	}

	private static void add(int id, String name, int roll_No, int physics, int chemistry, int maths) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement ps = conn.prepareStatement("insert into marksheet value(?,?,?,?,?,?)");

		ps.setInt(1, id);
		ps.setString(2, name);
		ps.setInt(3, roll_No);
		ps.setInt(4, physics);
		ps.setInt(5, chemistry);
		ps.setInt(6, maths);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		System.out.println("data add successfully.." + i);

	}

	private static void search() {
		// TODO Auto-generated method stub

	}

	private static void update(int id, String name, int rollNo, int physics, int chemistry, int maths)
			throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement ps = conn.prepareStatement(
				"update marksheet set name = ?, roll_No = ?, physics = ?, chemistry = ?, maths = ? where id = ?");

		ps.setString(1, name);
		ps.setInt(2, rollNo);
		ps.setInt(3, maths);
		ps.setInt(4, chemistry);
		ps.setInt(5, physics);
		ps.setInt(6, id);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		System.out.println("data update successfully.." + i);

	}

	private static void findByID(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement ps = conn.prepareStatement("select * from marksheet where id = ?");

		ps.setInt(1, id);

		ResultSet rs = ps.executeQuery();

		if (rs.next()) {

			System.out.print(rs.getInt(1));
			System.out.print("\t" + rs.getString(2));
			System.out.print("\t" + rs.getInt(3));
			System.out.print("\t" + rs.getInt(4));
			System.out.print("\t" + rs.getInt(5));
			System.out.println("\t" + rs.getInt(6));

		} else {
			System.out.println("record not fount");
		}

		conn.close();
		ps.close();

	}

	private static void delete(int id) throws Exception {

		Class.forName("com.mysql.cj.jdbc.Driver");

		Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/result", "root", "root");

		PreparedStatement ps = conn.prepareStatement("delete from marksheet where id = ?");

		ps.setInt(1, id);

		int i = ps.executeUpdate();

		conn.close();
		ps.close();

		if (i != 0) {

			System.out.println("data deleted successfully " + i);

		} else {
			System.out.println("id is not available");
		}

	}

}
	
	


