package com.canh.healthcare.services.interfaces;

import com.canh.healthcare.model.PatientDto;

public interface PatientService {
	public void create(PatientDto patient);
	public void update(PatientDto patient);
	public PatientDto findPatientById(int id);

}
