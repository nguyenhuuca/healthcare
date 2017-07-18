package com.canh.healthcare.model;

import java.util.Date;

import com.canh.healthcare.jpa.entity.Patient;

public class PatientBillDto {
	int patientBillId;
	int totalHour;
	Date examinationDay;
	Patient patient;
	Date reExaminationDate;
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	public int getTotalHour() {
		return totalHour;
	}
	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}
	public Date getExaminationDay() {
		return examinationDay;
	}
	public void setExaminationDay(Date examinationDay) {
		this.examinationDay = examinationDay;
	}
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getReExaminationDate() {
		return reExaminationDate;
	}
	public void setReExaminationDate(Date reExaminationDate) {
		this.reExaminationDate = reExaminationDate;
	}
	
	
}
