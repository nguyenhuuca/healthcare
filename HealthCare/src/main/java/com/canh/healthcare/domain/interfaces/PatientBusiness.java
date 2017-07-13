package com.canh.healthcare.domain.interfaces;

import com.canh.healthcare.model.PatientDto;

public interface PatientBusiness {
	
	public void create(PatientDto patient);
	public void update(PatientDto patient);
	public PatientDto findPatientById(int id);

}
