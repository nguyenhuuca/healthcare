package com.canh.healthcare.jpa.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Patient_Bills")
public class PatientBill {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int patientBillId;
	int totalHour;
	

}
