package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;
import com.canh.healthcare.utils.ResultInfo;

public interface PatientService {
	public ResultInfo create(PatientDto patient);
	public ResultInfo update(Patient patient);
	public Patient findPatientById(int id);
	public List<Patient> findAll();
	public List<Patient> findByName(String name);
	public Patient findPatientByMobile(String mobile);
	
	public ResultInfo createPatientRecord(PatientRecordDto patientRecordDto, PatientBillDto patientBillDto);
	public ResultInfo updatePatientRecord(PatientRecordDto patientRecordDto);
	

}
