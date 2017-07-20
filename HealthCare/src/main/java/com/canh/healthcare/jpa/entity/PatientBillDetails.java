package com.canh.healthcare.jpa.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Bill_Details")
public class PatientBillDetails implements Serializable  {
  
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Medicine medicine;
	PatientBill patientBill;
	int quantity;
	
	@Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "id")
	public Medicine getMedicine() {
		return medicine;
	}
	public void setMedicine(Medicine medicine) {
		this.medicine = medicine;
	}
	
	@Id
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "patientBillId" )
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
