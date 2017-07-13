package com.canh.healthcare.domain.impl;

import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.services.impl.PatientServiceImpl;
import com.canh.healthcare.services.interfaces.PatientService;

public class PatientBusinessImpl implements PatientBusiness {
	PatientService service = new PatientServiceImpl();

	@Override
	public void create(PatientDto patient) {
		// TODO Auto-generated method stub
		service.create(patient);
		
	}

	@Override
	public void update(PatientDto patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientDto findPatientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
