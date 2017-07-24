package com.canh.healthcare.services.impl;

import java.util.List;

import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.PatientBillService;
import com.canh.healthcare.utils.Constants;
import com.canh.healthcare.utils.ResultInfo;

public class PatientBillServiceImpl extends BaseSercvices implements PatientBillService {
    
	private static PatientBillService patientBillService;
	private PatientBillServiceImpl() {
		
	}
	public static PatientBillService getInstance() {
		if (patientBillService == null) {
			patientBillService = new PatientBillServiceImpl();
		}
		return patientBillService;
	}
	@Override
	public ResultInfo create(PatientBill patientBill) {
		ResultInfo resultInfo = new ResultInfo();
		try {
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
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
			resultInfo.setObject(patientBill);
			
		}catch(Exception e){
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}
		
		return resultInfo;
	}

	@Override
	public ResultInfo update(PatientBill patientBill) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			/*
			for (int i = 0; i < patientBill.getPatientBillDetails().size(); i++) {
				patientBill.getPatientBillDetails().get(i).setPatientBill(patientBill);

			}*/
			em.merge(patientBill);
			em.flush();
			em.getTransaction().commit();
			System.out.println(patientBill.getPatientBillId());
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
			resultInfo.setObject(patientBill);
			
		}catch(Exception e){
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}
		
		return resultInfo;

	}

	@Override
	public PatientBill findById(int id) {
		em = EntityManagerUtil.getEntityManager();
		PatientBill patientBill = (PatientBill) em.createNamedQuery("findPatientBillById").setParameter("patientBillId", id)
				.getSingleResult();

		return patientBill;
	}

	@Override
	public List<PatientBill> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
