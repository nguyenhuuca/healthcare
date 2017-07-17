package com.canh.healthcare.model;

import java.util.Date;

import com.canh.healthcare.jpa.entity.Patient;

public class PatientRecordDto {
	int patientRecordId;
	Date dateCome;
	Patient patient;
	int quantityMedicine;
	int medicineId;
		
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
	public int getQuantityMedicine() {
		return quantityMedicine;
	}
	public void setQuantityMedicine(int quantityMedicine) {
		this.quantityMedicine = quantityMedicine;
	}
	public int getMedicineId() {
		return medicineId;
	}
	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}
	
}
