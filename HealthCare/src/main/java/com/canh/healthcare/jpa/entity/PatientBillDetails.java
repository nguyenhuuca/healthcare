package com.canh.healthcare.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Bill_Details")
public class PatientBillDetails {
  
	Medicine medicine;
	PatientBill patientBill;
	int quantity;
	
	@Id
    @ManyToOne
    @JoinColumn(name = "id")
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
	@Id
    @ManyToOne
    @JoinColumn(name = "patientBillId")
	public PatientBill getPatientBill() {
		return patientBill;
	}
	public void setPatientBill(PatientBill patientBill) {
		this.patientBill = patientBill;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}
