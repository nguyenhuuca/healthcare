package com.canh.healthcare.model;

import java.util.Date;

import com.canh.healthcare.jpa.entity.Patient;

public class PatientRecordDto {
	int patientRecordId;
	Date dateCome;
	Patient patient;
	/// update
	int totalHour;
	Date examinationDay;
	Date reExamminatioDate;
	Long examinationCost;
	Long totalCost;
	String description;
	int patientBillId;

	public int getPatientRecordId() {
		return patientRecordId;
	}

	public void setPatientRecordId(int patientRecordId) {
		this.patientRecordId = patientRecordId;
	}

	public Date getDateCome() {
		return dateCome;
	}

	public void setDateCome(Date dateCome) {
		this.dateCome = dateCome;
	}

	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
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

	public Date getReExamminatioDate() {
		return reExamminatioDate;
	}

	public void setReExamminatioDate(Date reExamminatioDate) {
		this.reExamminatioDate = reExamminatioDate;
	}

	public Long getExaminationCost() {
		return examinationCost;
	}

	public void setExaminationCost(Long examinationCost) {
		this.examinationCost = examinationCost;
	}

	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPatientBillId() {
		return patientBillId;
	}

	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	

}
