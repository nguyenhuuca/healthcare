package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.model.PatientDto;

public interface PatientService {
	public void create(PatientDto patient);
	public void update(PatientDto patient);
	public Patient findPatientById(int id);
	public List<Patient> findAll();

}
