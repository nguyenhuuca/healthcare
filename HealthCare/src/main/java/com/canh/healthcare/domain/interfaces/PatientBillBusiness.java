package com.canh.healthcare.domain.interfaces;

import com.canh.healthcare.model.PatientBillDto;

public interface PatientBillBusiness {
	
	public void create(PatientBillDto patientBillDto);
	public void update(PatientBillDto patientBilDto);

}
