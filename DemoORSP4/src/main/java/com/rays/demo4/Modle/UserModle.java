package com.rays.demo4.Modle;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.rays.demo4.Bean.UserBean;
import com.rays.demo4.Util.JDBCDataSource;

public class UserModle {

	public int nextPK() throws Exception {

		int pk = 0;

		Connection conn = JDBCDataSource.getConnection();
		String sql = "Select max(id) from st_user";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		while (rs.next()) {
			pk = rs.getInt(1);

		}
		return pk + 1;

	}

	public void add(UserBean bean) throws Exception {
		Connection conn = JDBCDataSource.getConnection();
		String sql = "Insert into st_user values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		 int pk=nextPK();
		 
		pstmt.setInt(1, pk);
		pstmt.setString(2, bean.getFirstName());
		pstmt.setString(3, bean.getLastName());
		pstmt.setString(4, bean.getLogin());
		pstmt.setString(5, bean.getPassword());
		// date of birth caste by sql date
		pstmt.setDate(6, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(7, bean.getMobileNo());
		pstmt.setLong(8, bean.getRollId());
		pstmt.setInt(9, bean.getUnSuccesfulllogin());
		pstmt.setString(10, bean.getGender());
		pstmt.setTimestamp(11, bean.getLastlogin());
		pstmt.setString(12, bean.getLock());
		pstmt.setString(13, bean.getRegisteredIP());
		pstmt.setString(14, bean.getLastloginIP());
		pstmt.setString(15, bean.getCreatedBy());
		pstmt.setString(16, bean.getModifiedBy());
		pstmt.setTimestamp(17, bean.getCreatedDatetime());
		pstmt.setTimestamp(18, bean.getModifiedDatetime());
		
		int a = pstmt.executeUpdate();
		System.out.println("Data added Successfully" +a );
		
		
	}
	public void update(UserBean bean) throws Exception {
	    Connection conn = JDBCDataSource.getConnection();
	    String sql = "UPDATE ST_USER SET FIRST_NAME=?,LAST_NAME=?,LOGIN=?,PASSWORD=?,DOB=?,MOBILE_NO=?,ROLE_ID=?,UNSUCCESSEFUL_LOGIN=?,GENDER=?,LAST_LOGIN=?,USER_LOCK=?,REGISTERED_IP=?,LAST_LOGIN_IP=?,CREATED_BY=?,MODIFIED_BY=?,CREATED_DATETIME=?,MODIFIED_DATETIME=?  WHERE ID=?";
	    PreparedStatement pstmt = conn.prepareStatement(sql);
	    int pk=nextPK();
	    
		
		pstmt.setString(1, bean.getFirstName());
		pstmt.setString(2, bean.getLastName());
		pstmt.setString(3, bean.getLogin());
		pstmt.setString(4, bean.getPassword());
		// date of birth caste by sql date
		pstmt.setDate(5, new java.sql.Date(bean.getDob().getTime()));
		pstmt.setString(6, bean.getMobileNo());
		pstmt.setLong(7, bean.getRollId());
		pstmt.setInt(8, bean.getUnSuccesfulllogin());
		pstmt.setString(9, bean.getGender());
		pstmt.setTimestamp(10, bean.getLastlogin());
		pstmt.setString(11, bean.getLock());
		pstmt.setString(12, bean.getRegisteredIP());
		pstmt.setString(13, bean.getLastloginIP());
		pstmt.setString(14, bean.getCreatedBy());
		pstmt.setString(15, bean.getModifiedBy());
		pstmt.setTimestamp(16, bean.getCreatedDatetime());
		pstmt.setTimestamp(17, bean.getModifiedDatetime());
		pstmt.setLong(18, bean.getId());
		
		int a = pstmt.executeUpdate();
		System.out.println("Data update Successfully" +a );

}
	public void delete(UserBean bean) throws Exception {
		
		Connection conn = JDBCDataSource.getConnection();
		String sql = "Delete from st_user where Id=?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setLong(1, bean.getId());
		int a = pstmt.executeUpdate();
		System.out.println("Data deleted Succesfully"+a);
		
	}
	public List search(UserBean bean , int pageNo , int pageSize) throws Exception {
		
		StringBuffer sql = new StringBuffer("Select * from st_user where 1=1");
		if (bean !=null) {
			if (bean.getFirstName()!=null && bean.getFirstName().length() >0) {
				sql.append(" And First_Name like '" + bean.getFirstName() + "%'");
			}
			if (bean.getLogin() != null && bean.getLogin().length() > 0) {
				sql.append(" AND LOGIN like '" + bean.getLogin() + "%'");
			}
			if (bean.getRollId() > 0) {
				sql.append(" AND ROLE_ID = " + bean.getId());
			}
			if (bean.getLastName() != null && bean.getLastName().length() > 0) {
				sql.append(" AND LAST_NAME like '" + bean.getLastName() + "%'");
			}
			if (bean.getId() > 0) {
				sql.append(" AND id = " + bean.getId());
			}

			if (bean.getPassword() != null && bean.getPassword().length() > 0) {
				sql.append(" AND PASSWORD like '" + bean.getPassword() + "%'");
			}
			if (bean.getDob() != null && bean.getDob().getTime() > 0) {
				Date d = new Date(bean.getDob().getTime());
				sql.append(" AND DOB = '" + d + "'");
				System.out.println("done");
			}
			if (bean.getMobileNo() != null && bean.getMobileNo().length() > 0) {
				sql.append(" AND MOBILE_NO = " + bean.getMobileNo());
			}
			if (bean.getUnSuccesfulllogin() > 0) {
				sql.append(" AND UNSUCCESSFUL_LOGIN = " + bean.getUnSuccesfulllogin());
			}
			if (bean.getGender() != null && bean.getGender().length() > 0) {
				sql.append(" AND GENDER like '" + bean.getGender() + "%'");
			}
		}
			if (pageSize >0) {
				pageNo = (pageNo - 1) * pageSize;
				
				sql.append(" Limit " + pageNo + ", " + pageSize);
				
				
			}
		
			System.out.println("sql query search >>="+ sql.toString());
			List list = new ArrayList();
			Connection conn = JDBCDataSource.getConnection();
			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
			ResultSet rs = pstmt.executeQuery();
			while (rs.next()) {
				bean = new UserBean();
				bean.setId(rs.getLong(1));
				bean.setFirstName(rs.getString(2));
				bean.setLastName(rs.getString(3));
				bean.setLogin(rs.getString(4));
				bean.setPassword(rs.getString(5));
				bean.setDob(rs.getDate(6));
				bean.setMobileNo(rs.getString(7));
				bean.setRollId(rs.getLong(8));
				bean.setUnSuccesfulllogin(rs.getInt(9));
				bean.setGender(rs.getString(10));
				bean.setLastlogin(rs.getTimestamp(11));
				bean.setLock(rs.getString(12));
				bean.setRegisteredIP(rs.getString(13));
				bean.setLastloginIP(rs.getString(14));
				bean.setCreatedBy(rs.getString(15));
				bean.setModifiedBy(rs.getString(16));
				bean.setCreatedDatetime(rs.getTimestamp(17));
				bean.setModifiedDatetime(rs.getTimestamp(18));
				
				list.add(bean);
				
			}
			
			return list;
		}
		
		
	}

