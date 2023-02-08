package com.xworkz.bootstrap.servelet.dto;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;



public class DeliveryDTO{

	private String fname;
	private String email;
	private long mobile_NO;
	private String gender;

	public DeliveryDTO() {
		System.out.println("Running Deliverychat");
	}

	@Override
	public String toString() {
		return "Deliverychat [fname=" + fname + ", email=" + email + ", mobile_NO=" + mobile_NO + ", gender=" + gender
				+ "]";
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getMobile_NO() {
		return mobile_NO;
	}

	public void setMobile_NO(long mobile_NO) {
		this.mobile_NO = mobile_NO;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
