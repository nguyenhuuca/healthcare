package com.canh.healthcare.jpa.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.canh.healthcare.model.PatientBillDto;

@Entity
@Table(name = "Patient_Bills")
public class PatientBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patientBillId;
	Patient patient;
	
	//update schema
	Date createDate;
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "PatientBill")
	List<PatientBillDetails> patientBillDetails = new ArrayList<PatientBillDetails>();
	public PatientBill(){
		
	}
	public PatientBill(PatientBillDto patientBillDto){
		this.patient = patientBillDto.getPatient();
		this.createDate = patientBillDto.getCreateDate();
	}
	public int getPatientBillId() {
		return patientBillId;
	}
	public void setPatientBillId(int patientBillId) {
		this.patientBillId = patientBillId;
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
	
	@Column(name="create_date")
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public List<PatientBillDetails> getPatientBillDetails() {
		return patientBillDetails;
	}
	public void setPatientBillDetails(List<PatientBillDetails> patientBillDetails) {
		this.patientBillDetails = patientBillDetails;
	}
	

}
