package User;

import java.text.SimpleDateFormat;

public class Usermoduletest {

	public static void main(String[] args) throws Exception {
//		testadd();
//		testdelete();
//		findbypk();
//		testupdate();
		testAuth();

	}

	private static void testAuth() throws Exception {
		UserModule module = new UserModule();
		
		UserBean bean = module.authenticate("shagun@gmail.com", "shagun@2512" );
		
		if(bean != null) {
			
			System.out.print(bean.getId());
			System.out.print("\t"+bean.getFirstname());
			System.out.print("\t"+bean.getLastname());
			System.out.print("\t"+bean.getLoginID());
			System.out.print("\t"+bean.getPassword());
			System.out.print("\t"+bean.getPhoneno());
			System.out.print("\t"+bean.getDob());
			System.out.println("\t"+bean.getGender());
			
		}
		else {
			System.out.println("Invalid loginId and Password....");
		}
		
	}

	private static void testupdate() throws Exception {
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();
		
		bean.setId(3);
		bean.setFirstname("Shagun");
		bean.setLastname("Sharma");
		bean.setLoginID("shagun@gmail.com");
		bean.setPassword("shagun@2512");
		bean.setPhoneno(98765);
		bean.setDob(sdf.parse("25/12/1998"));
		bean.setGender("female");
		
		UserModule module = new UserModule();
		module.Update(bean);
		
		
		

		
		
	}

	private static void findbypk() throws Exception {
		UserModule module = new UserModule();
		UserBean bean = module.findbyPk(3);
		if (bean !=null) {
			System.out.println(bean.getId());
			System.out.println(bean.getFirstname());
			System.out.println(bean.getLastname());
			System.out.println(bean.getLoginID());
			System.out.println(bean.getPassword());
			System.out.println(bean.getPhoneno());
			System.out.println(bean.getDob());
			System.out.println(bean.getGender());
			
		}
		else {
			System.out.println("Id not available!!");
		}
			
		
	}

	private static void testdelete() throws Exception {
		
		UserModule modle = new UserModule();
		modle.delete(2);
		
		
	}

	private static void testadd() throws Exception {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		UserBean bean = new UserBean();

		bean.setFirstname("Kirti");
		bean.setLastname("Singh");
		bean.setLoginID("Kirtirajput8697@gmil.com");
		bean.setPassword("kirti@1999");
		bean.setPhoneno(1234567890);
		bean.setDob(sdf.parse("11/09/1999"));
		bean.setGender("Female");

		UserModule modle = new UserModule();
		modle.add(bean);

	}
      
}
