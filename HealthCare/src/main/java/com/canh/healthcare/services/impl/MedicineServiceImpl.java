package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.MedicineService;

public class MedicineServiceImpl extends BaseSercvices implements MedicineService {

	@Override
	public void create(MedicineDto patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(MedicineDto patient) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Patient findMedicineById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medicine> findAll() {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		List<Medicine> medicineList = (ArrayList<Medicine>)em.createQuery("Select m from Medicine m").getResultList();
		em.getTransaction().commit();
		em.close();
		return medicineList;
	}

}
