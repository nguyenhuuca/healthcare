package com.canh.healthcare.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientBillDetails;

public class PatientBillDto {
	int patientBillId;
	PatientDto patient;
	List<PatientBillDetailsDto> patientBillDetails = new ArrayList<PatientBillDetailsDto>();
	Date createDate;
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	public PatientDto getPatient() {
		return patient;
	}
	public void setPatient(PatientDto patient) {
		this.patient = patient;
	}
	public List<PatientBillDetailsDto> getPatientBillDetails() {
		return patientBillDetails;
	}
	public void setPatientBillDetails(List<PatientBillDetailsDto> patientBillDetails) {
		this.patientBillDetails = patientBillDetails;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	
	
	
	
	
}
