package com.rays.demo4.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.rays.demo4.Bean.UserBean;
import com.rays.demo4.Modle.UserModle;

public class UserTest {
	public static void main(String[] args) throws Exception {
	
	
//		testAdd(); 
//		testupdate();
//		testdelete();
		testsearch();
	}
		private static void testsearch() throws Exception {
			UserBean bean = new UserBean();
			UserModle modle = new UserModle();
			List list = new ArrayList();
			 bean.setFirstName("vishu");
//			 bean.setLastName("Sharma");
//			 bean.setLogin("shagun@gmail.com");
			//bean.setId(48);
			 list = modle.search(bean, 1, 10);
			 if (list.size()< 0) {
				 System.out.println("Test search fail");				
			}
			 Iterator it = list.iterator();
			 while (it.hasNext()) {
				 bean = (UserBean) it.next();
				 System.out.println(bean.getId());
				 System.out.println(bean.getFirstName());
				 System.out.println(bean.getLastName());
				 System.out.println(bean.getLogin());
				 System.out.println(bean.getPassword());
				 System.out.println(bean.getDob());
				 System.out.println(bean.getRollId());
				 System.out.println(bean.getUnSuccesfulllogin());
				 System.out.println(bean.getGender());
				 System.out.println(bean.getLastlogin());
				 System.out.println(bean.getLock());
			}
			 
			 


		
	}
		private static void testdelete() throws Exception {
		
			UserBean bean = new UserBean();
			UserModle modle = new UserModle();
			bean.setId(51);
			modle.delete(bean);
		
	}
		private static void testupdate() throws Exception {
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

		
			UserBean bean = new UserBean();
			UserModle modle = new UserModle();
			
			bean.setId(48);
			bean.setFirstName("Shagun");
			bean.setLastName("Sharma");
			bean.setLogin("shagun@gmail.com");
			bean.setPassword("Shagun@123");
			bean.setDob(sdf.parse("1999-12-25"));
			bean.setRollId(1L);
			bean.setUnSuccesfulllogin(5);
			bean.setGender("Female");
			bean.setMobileNo("9407411301");
			bean.setLock("yes");
			bean.setConfirmPassword("Shagun@123");
			modle.update(bean);

			System.out.println("test update succ");

	}
		private static void testAdd() throws Exception {
			
		UserBean bean = new UserBean();
		UserModle modle = new UserModle();
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		bean.setFirstName("Shagun");
		bean.setLastName("Sharma");
		bean.setLogin("shagun@gmail.com");
		bean.setPassword("Shagun@123");
		bean.setDob(sdf.parse("25-12-1999"));
		bean.setRollId(1L);
		bean.setUnSuccesfulllogin(5);
		bean.setGender("Female");
		bean.setMobileNo("9407411301");
		bean.setLock("yes");
		bean.setConfirmPassword("Shagun@123");
		
		modle.add(bean);
		System.out.println("Data added Successfully");
		
	}
		
}