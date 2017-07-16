package com.canh.healthcare.domain.interfaces;

import java.util.List;

import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.model.PatientDto;

public interface MedicineBusiness {
	public void create(MedicineDto patient);
	public void update(MedicineDto patient);
	public PatientDto findPatientById(int id);
	public List<MedicineDto> findAll();


}
