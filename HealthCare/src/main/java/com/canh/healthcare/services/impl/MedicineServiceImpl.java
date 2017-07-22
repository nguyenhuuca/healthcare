package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.MedicineService;

public class MedicineServiceImpl extends BaseSercvices implements MedicineService {

	private static MedicineService medicineService;

	private MedicineServiceImpl() {

	}

	public static MedicineService getInstance() {
		if (medicineService == null) {
			medicineService = new MedicineServiceImpl();
		}
		return medicineService;
	}

	@Override
	public void create(MedicineDto medicineDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Medicine medicine = new Medicine(medicineDto);
		em.persist(medicine);
		em.getTransaction().commit();

	}

	@Override
	public void update(MedicineDto medicineDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Medicine medicine = new Medicine(medicineDto);
		em.merge(medicine);
		em.getTransaction().commit();

	}

	@Override
	public Medicine findMedicineById(int id) {
		em = EntityManagerUtil.getEntityManager();
		Medicine medicine = (Medicine) em.createNamedQuery("findMedicineById").setParameter("medicineId", id)
				.getSingleResult();
		return medicine;
	}

	@Override
	public List<Medicine> findAll() {
		em = EntityManagerUtil.getEntityManager();
		@SuppressWarnings("unchecked")
		List<Medicine> medicineList = (ArrayList<Medicine>) em.createQuery("Select m from Medicine m").getResultList();
		return medicineList;
	}

}
