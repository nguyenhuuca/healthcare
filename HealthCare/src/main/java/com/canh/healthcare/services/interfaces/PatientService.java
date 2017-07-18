package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;

public interface PatientService {
	public void create(PatientDto patient);
	public void update(Patient patient);
	public Patient findPatientById(int id);
	public List<Patient> findAll();
	public List<Patient> findByName(String name);
	
	public void createPatientRecord(PatientRecordDto patientRecordDto, PatientBillDto patientBillDto);
	public void updatePatientRecord(PatientRecordDto patientRecordDto);
	

}
