package com.canh.healthcare.jpa.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "patient_records")
public class PatientRecord {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patientRecordId;
	Date dateCome;
	Patient patient;
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
	@JoinColumn(name = "id", nullable = false)
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	
	
}
