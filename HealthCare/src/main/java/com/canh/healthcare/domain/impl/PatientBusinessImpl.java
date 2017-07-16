package com.canh.healthcare.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.domain.interfaces.PatientBusiness;
import com.canh.healthcare.jpa.entity.Patient;
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
	public PatientDto searchPatientById(int id) {
		// TODO Auto-generated method stub
		Patient patient = service.findPatientById(id);
		return populateData(patient);
	}
	
	@Override
	public List<PatientDto> searchAll() {
		List<Patient> patientLst = service.findAll();
		List<PatientDto> patientDtoLst =  new ArrayList<PatientDto>();
		for(Patient patient : patientLst){
			PatientDto patientDto = populateData(patient);
			patientDtoLst.add(patientDto);
		}
		return patientDtoLst;
	}
	
	public PatientDto populateData(Patient patient){
		PatientDto patientDto = new PatientDto();
		patientDto.setAddress(patient.getAddress());
		patientDto.setBirthDay(patient.getBirthDay());
		patientDto.setFamilyContact(patient.getFamilyContact());
		patientDto.setFirstDateJoin(patient.getFirstDateJoin());
		patientDto.setId(patient.getId());
		patientDto.setMale(patient.isMale());
		patientDto.setMobile(patient.getMobile());
		patientDto.setName(patient.getName());
		patientDto.setUrgentContact(patient.getUrgentContact());
		
		return patientDto;
	}

	@Override
	public List<PatientDto> searchByName(String name) {
		List<Patient> patientLst = service.findByName(name);
		List<PatientDto> patientDtoLst =  new ArrayList<PatientDto>();
		for(Patient patient : patientLst){
			PatientDto patientDto = populateData(patient);
			patientDtoLst.add(patientDto);
		}
		return patientDtoLst;
	}
	
}
