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
	int quantityMedicine;
	int medicineId;
	Date dateCome;
	Patient patient;

	public PatientRecord() {

	}

	public PatientRecord(PatientRecordDto patientRecordDto) {
		if (patientRecordDto.getPatientRecordId() != 0) {
			this.patientRecordId = patientRecordDto.getPatientRecordId();
		}
		this.patient = patientRecordDto.getPatient();
		this.dateCome = patientRecordDto.getDateCome();
		this.quantityMedicine = patientRecordDto.getQuantityMedicine();
		this.medicineId = patientRecordDto.getMedicineId();
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
	@JoinColumn(name = "id", nullable = false)
	@Access(AccessType.PROPERTY)
	public Patient getPatient() {
		return patient;
	}

	public void setPatient(Patient patient) {
		this.patient = patient;
	}

	@Column(name = "quantity")
	public int getQuantityMedicine() {
		return quantityMedicine;
	}

	public void setQuantityMedicine(int quantityMedicine) {
		this.quantityMedicine = quantityMedicine;
	}

	@Column(name = "medicine_id")
	public int getMedicineId() {
		return medicineId;
	}

	public void setMedicineId(int medicineId) {
		this.medicineId = medicineId;
	}

}
