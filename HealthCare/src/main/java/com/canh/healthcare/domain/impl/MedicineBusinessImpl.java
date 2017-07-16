package com.canh.healthcare.domain.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.domain.interfaces.MedicineBusiness;
import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.services.impl.MedicineServiceImpl;
import com.canh.healthcare.services.interfaces.MedicineService;

public class MedicineBusinessImpl implements MedicineBusiness {
	MedicineService service = new MedicineServiceImpl();
	@Override
	public void create(MedicineDto patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MedicineDto patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientDto findPatientById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<MedicineDto> findAll() {
		List<Medicine> medicineLst = service.findAll();
		List<MedicineDto> medicineDtoLst =  new ArrayList<MedicineDto>();
		for(Medicine medicine : medicineLst){
			MedicineDto medicineDto = populateData(medicine);
			medicineDtoLst.add(medicineDto);
		}
		return medicineDtoLst;
	}
	

	public MedicineDto populateData(Medicine medicine){
		MedicineDto medicineDto = new MedicineDto();
		medicineDto.setId(medicine.getId());;
		medicineDto.setName(medicine.getName());;
		medicineDto.setUnit(medicine.getUnit());
		medicineDto.setUnitPriceBuy(medicine.getUnitPriceBuy());
		medicineDto.setUnitPriceSell(medicine.getUnitPriceSell());
		
		return medicineDto;
	}

}
