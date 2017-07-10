package com.canh.healthcare.model;

import java.util.Date;

public class Patient {
	int id;
	String name;
	Date birthDay;
	boolean male;
	String address;
	String mobile;
	String familyContact;
	Date firstJoin = new Date();

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getFamilyContact() {
		return familyContact;
	}

	public void setFamilyContact(String familyContact) {
		this.familyContact = familyContact;
	}

	public Date getFirstJoin() {
		return firstJoin;
	}

	public void setFirstJoin(Date firstJoin) {
		this.firstJoin = firstJoin;
	}

}
