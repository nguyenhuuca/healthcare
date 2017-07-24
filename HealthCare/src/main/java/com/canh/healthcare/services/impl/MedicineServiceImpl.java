package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.jpa.entity.Medicine;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.MedicineDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.MedicineService;
import com.canh.healthcare.utils.Constants;
import com.canh.healthcare.utils.ResultInfo;

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
	public ResultInfo create(MedicineDto medicineDto) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			Medicine medicine = new Medicine(medicineDto);
			em.persist(medicine);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);

		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setMesssage(e.getMessage());
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		}
		return resultInfo;

	}

	@Override
	public ResultInfo update(MedicineDto medicineDto) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			Medicine medicine = new Medicine(medicineDto);
			em.merge(medicine);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
			resultInfo.setMesssage(e.getMessage());
		}
		return resultInfo;

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
