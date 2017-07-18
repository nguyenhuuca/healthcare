package com.canh.healthcare.jpa.entity;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.canh.healthcare.model.PatientBillDto;

@Entity
@Table(name = "Patient_Bills")
public class PatientBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patientBillId;
	int totalHour;
	Date examinationDay;
	Date reExamminatioDate;
	Patient patient;
	
	public PatientBill(){
		
	}
	public PatientBill(PatientBillDto patientBillDto){
		this.patient = patientBillDto.getPatient();
		this.examinationDay = patientBillDto.getExaminationDay();
		this.totalHour = patientBillDto.getTotalHour();
		this.reExamminatioDate = patientBillDto.getReExaminationDate();
	}
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	@Column(name="total_hour")
	public int getTotalHour() {
		return totalHour;
	}
	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}
	@Column(name="examination_day")
	public Date getExaminationDay() {
		return examinationDay;
	}
	public void setExaminationDay(Date examinationDay) {
		this.examinationDay = examinationDay;
	}
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id", nullable = false)
	@Access(AccessType.PROPERTY)
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Date getReExamminatioDate() {
		return reExamminatioDate;
	}
	public void setReExamminatioDate(Date reExamminatioDate) {
		this.reExamminatioDate = reExamminatioDate;
	}
	
	

}
