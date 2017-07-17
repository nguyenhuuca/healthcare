package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.model.MedicineDto;

public interface MedicineService {
	public void create(MedicineDto patient);
	public void update(MedicineDto patient);
	public Medicine findMedicineById(int id);
	public List<Medicine> findAll();
}
