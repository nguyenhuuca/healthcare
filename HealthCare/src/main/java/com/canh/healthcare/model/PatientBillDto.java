package com.canh.healthcare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientBillDetails;

public class PatientBillDto {
	int patientBillId;
	Patient patient;
	List<PatientBillDetails> patientBillDetails = new ArrayList<PatientBillDetails>();
	Date createDate;
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public List<PatientBillDetails> getPatientBillDetails() {
		return patientBillDetails;
	}
	public void setPatientBillDetails(List<PatientBillDetails> patientBillDetails) {
		this.patientBillDetails = patientBillDetails;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
}
