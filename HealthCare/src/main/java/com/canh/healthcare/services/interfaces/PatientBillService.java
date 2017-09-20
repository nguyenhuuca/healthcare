package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.utils.ResultInfo;

public interface PatientBillService {
	
	public ResultInfo create(PatientBill patient);
	public ResultInfo update(PatientBill patient);
	public PatientBill findById(int id);
	public List<PatientBill> findAll();

}
