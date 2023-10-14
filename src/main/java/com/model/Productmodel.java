package com.model;

public class Productmodel {
	int sno;
	String name;
	String email;
	String mobile;
	String file;
	public Productmodel(int sno,String name, String email, String mobile, String file) {
		super();
		this.sno=sno;
		this.name = name;
		this.email = email;
		this.mobile = mobile;
		this.file = file;
	}
	public int getSno() {
		return sno;
	}
	public void setSno(int sno) {
		this.sno = sno;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getFile() {
		return file;
	}
	public void setFile(String file) {
		this.file = file;
	}
	@Override
	public String toString() {
		return "Productmodel [sno=" + sno + ", name=" + name + ", email=" + email + ", mobile=" + mobile + ", file="
				+ file + "]";
	}
	
	

}
