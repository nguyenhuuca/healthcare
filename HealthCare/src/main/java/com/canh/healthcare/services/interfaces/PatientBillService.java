package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.model.PatientBillDto;

public interface PatientBillService {
	
	public void create(PatientBillDto patient);
	public void update(PatientBillDto patient);
	public PatientBill findById(int id);
	public List<PatientBill> findAll();

}
