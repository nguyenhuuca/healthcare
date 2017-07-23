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

import com.canh.healthcare.model.PatientRecordDto;

@Entity
@Table(name = "patient_records")
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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

	public PatientRecord() {

	}

	public PatientRecord(PatientRecordDto patientRecordDto) {
		if (patientRecordDto.getPatientRecordId() != 0) {
			this.patientRecordId = patientRecordDto.getPatientRecordId();
		}
		this.patient = patientRecordDto.getPatient();
		this.dateCome = patientRecordDto.getDateCome();
		this.totalCost = patientRecordDto.getTotalCost();
		this.examinationDay = patientRecordDto.getExaminationDay();
		this.reExamminatioDate = patientRecordDto.getReExamminatioDate();
		this.totalHour = patientRecordDto.getTotalHour();
		this.description = patientRecordDto.getDescription();
		this.patientBillId = patientRecordDto.getPatientBillId();
	}

	public int getPatientRecordId() {
		return patientRecordId;
	}

	public void setPatientRecordId(int patientRecordId) {
		this.patientRecordId = patientRecordId;
	}

	@Column(name = "date_come")
	public Date getDatecome() {
		return dateCome;
	}

	public void setDateCome(Date dateCome) {
		this.dateCome = dateCome;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "patientId", nullable = false)
	@Access(AccessType.PROPERTY)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

    @Column(name="total_hour")
	public int getTotalHour() {
		return totalHour;
	}

	public void setTotalHour(int totalHour) {
		this.totalHour = totalHour;
	}
    
	@Column(name="examination_date")
	public Date getExaminationDay() {
		return examinationDay;
	}

	public void setExaminationDay(Date examinationDay) {
		this.examinationDay = examinationDay;
	}
    @Column(name ="re_examination_date")
	public Date getReExamminatioDate() {
		return reExamminatioDate;
	}
    
	public void setReExamminatioDate(Date reExamminatioDate) {
		this.reExamminatioDate = reExamminatioDate;
	}
    
	@Column(name="examination_cost")
	public Long getExaminationCost() {
		return examinationCost;
	}

	public void setExaminationCost(Long examinationCost) {
		this.examinationCost = examinationCost;
	}
    
	@Column(name = "total_cost")
	public Long getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Long totalCost) {
		this.totalCost = totalCost;
	}
    
	@Column(name = "description")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "patient_bill_id")
	public int getPatientBillId() {
		return patientBillId;
	}

	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
	}
	
	
	

}
