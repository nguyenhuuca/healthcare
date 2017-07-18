package com.canh.healthcare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class PatientDto {
	int id;
	String name;
	String birthDay;
	boolean male;
	String address;
	String mobile;
	String familyContact;
	Date firstDateJoin = new Date();
	String urgentContact;
	List<PatientRecordDto> pattientRecords = new ArrayList<PatientRecordDto>();
	List<PatientBillDto> patientBill = new ArrayList<PatientBillDto>();

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

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public Date getFirstDateJoin() {
		return firstDateJoin;
	}

	public void setFirstDateJoin(Date firstDateJoin) {
		this.firstDateJoin = firstDateJoin;
	}

	public String getUrgentContact() {
		return urgentContact;
	}
	
	

	public List<PatientRecordDto> getPattientRecords() {
		return pattientRecords;
	}

	public void setPattientRecords(List<PatientRecordDto> pattientRecords) {
		this.pattientRecords = pattientRecords;
	}

	public List<PatientBillDto> getPatientBill() {
		return patientBill;
	}

	public void setPatientBill(List<PatientBillDto> patientBill) {
		this.patientBill = patientBill;
	}

	public void setUrgentContact(String urgentContact) {
		this.urgentContact = urgentContact;
	}
}
