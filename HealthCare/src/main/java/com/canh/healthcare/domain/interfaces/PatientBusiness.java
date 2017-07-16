package com.canh.healthcare.domain.interfaces;

import java.util.List;

import com.canh.healthcare.model.PatientDto;

public interface PatientBusiness {
	
	public void create(PatientDto patient);
	public void update(PatientDto patient);
	public PatientDto searchPatientById(int id);
	public List<PatientDto> searchAll();
	public List<PatientDto> searchByName(String name);
	

}
