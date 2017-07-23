package com.canh.healthcare.domain.interfaces;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;

public interface PatientBillBusiness {
	
	public void create(PatientBillDto patientBillDto, PatientDto patientDto);
	public void update(PatientBillDto patientBilDto);
	public PatientBill searchPatientBillById(int id);

}
