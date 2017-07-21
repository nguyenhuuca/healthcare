package com.canh.healthcare.services.impl;

import java.util.List;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.PatientBillService;

public class PatientBillServiceImpl extends BaseSercvices implements PatientBillService {

	@Override
	public void create(PatientBill patientBill) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		// em.persist(patientBill);

		for (int i = 0; i < patientBill.getPatientBillDetails().size(); i++) {
			patientBill.getPatientBillDetails().get(i).setPatientBill(patientBill);

		}
		em.persist(patientBill);
		em.flush();
		em.getTransaction().commit();
		System.out.println(patientBill.getPatientBillId());
		em.close();

	}

	@Override
	public void update(PatientBill patient) {
		// TODO Auto-generated method stub

	}

	@Override
	public PatientBill findById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PatientBill> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
