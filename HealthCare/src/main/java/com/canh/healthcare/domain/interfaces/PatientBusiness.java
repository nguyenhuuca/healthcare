package com.canh.healthcare.domain.interfaces;

import java.util.List;

import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;

public interface PatientBusiness {
	
	public void create(PatientDto patient);
	public void update(PatientDto patient);
	public PatientDto searchPatientById(int id);
	public PatientDto searchPatientByMobile(String mobile);
	public List<PatientDto> searchAll();
	public List<PatientDto> searchByName(String name);
	public void createPatientRecord(PatientRecordDto patientRecordDto,PatientBillDto patientBillDto);
	

}
