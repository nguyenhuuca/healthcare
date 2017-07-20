package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.model.PatientBillDto;

public interface PatientBillService {
	
	public void create(PatientBill patient);
	public void update(PatientBill patient);
	public PatientBill findById(int id);
	public List<PatientBill> findAll();

}
