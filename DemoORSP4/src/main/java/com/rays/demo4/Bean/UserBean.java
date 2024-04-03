package com.rays.demo4.Bean;

import java.sql.Timestamp;
import java.util.Date;

public class UserBean extends BaseBean {
	
	public static final String ACTIVE="Active";
	public static final String INACTIVE="inactive";
	private String firstName;
	private String lastName;
	private String login;
	private String password;
	private String confirmPassword;
	private Date dob;
	private String mobileNo;
	private long rollId;
	private int unSuccesfulllogin;
	private String gender;
	private Timestamp lastlogin;
	private  String lock=INACTIVE;
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getConfirmPassword() {
		return confirmPassword;
	}
	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public String getMobileNo() {
		return mobileNo;
	}
	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}
	public long getRollId() {
		return rollId;
	}
	public void setRollId(long rollId) {
		this.rollId = rollId;
	}
	public int getUnSuccesfulllogin() {
		return unSuccesfulllogin;
	}
	public void setUnSuccesfulllogin(int unSuccesfulllogin) {
		this.unSuccesfulllogin = unSuccesfulllogin;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Timestamp getLastlogin() {
		return lastlogin;
	}
	public void setLastlogin(Timestamp lastlogin) {
		this.lastlogin = lastlogin;
	}
	public String getRegisteredIP() {
		return registeredIP;
	}
	public void setRegisteredIP(String registeredIP) {
		this.registeredIP = registeredIP;
	}
	public String getLastloginIP() {
		return lastloginIP;
	}
	public void setLastloginIP(String lastloginIP) {
		this.lastloginIP = lastloginIP;
	}
	
	public String getLock() {
		return lock;
	}
	public void setLock(String lock) {
		this.lock = lock;
	}
	public static String getActive() {
		return ACTIVE;
	}
	public static String getInactive() {
		return INACTIVE;
	}
	
	private String registeredIP;
	private String lastloginIP;

	public String getkey() {
		// TODO Auto-generated method stub
		return id+"";
		
	}
	public String getValue() {
		// TODO Auto-generated method stub
		return firstName + " " + lastName;
	}
	
	@Override
	public String toString() {
	
		return "UserBean [password=" + password + ", dob=" +  dob+ "]";
	}

}
