package com.inkesh;

import org.hibernate.validator.NotEmpty;
import org.hibernate.validator.NotNull;
import org.hibernate.validator.Size;

public class Customer 
{
	
	private int id;  
	private String Fname;
	private String Lname; 
	private String emailC;
	private String password;
    private Long mobile_no;
    private String address;
    
    public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFname() {
		return Fname;
	}
	public void setFname(String Fname) {
		this.Fname = Fname;
	}
	public String getLname() {
		return Lname;
	}
	public void setLname(String Lname) {
		this.Lname = Lname;
	}
	public String getEmailC() {
		return emailC;
	}
	public void setEmailC(String emailC) {
		this.emailC = emailC;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public Long getMobile_no() {
		return mobile_no;
	}
	public void setMobile_no(Long mobile_no) {
		this.mobile_no = mobile_no;
	}
	

}
