package com.canh.healthcare.services.interfaces;

import java.util.List;

import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.utils.ResultInfo;

public interface MedicineService {
	public ResultInfo create(MedicineDto patient);
	public ResultInfo update(MedicineDto patient);
	public Medicine findMedicineById(int id);
	public List<Medicine> findAll();
}
