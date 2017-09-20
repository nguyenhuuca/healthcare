package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientBill;
import com.canh.healthcare.jpa.entity.PatientRecord;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.PatientBillDto;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.PatientService;
import com.canh.healthcare.utils.Constants;
import com.canh.healthcare.utils.ResultInfo;

public class PatientServiceImpl extends BaseSercvices implements PatientService {
	private static PatientService patientService;

	private PatientServiceImpl() {
		// em = EntityManagerUtil.getEntityManager();
	}

	public static PatientService getInstance() {
		if (patientService == null) {
			patientService = new PatientServiceImpl();
		}
		return patientService;
	}

	@Override
	public ResultInfo create(PatientDto patient) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			Patient patientEnt = new Patient(patient);
			em.persist(patientEnt);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERFORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}

		return resultInfo;

	}

	@Override
	public ResultInfo update(Patient patient) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			// Patient patientEnt = new Patient(patient);
			patient = em.merge(patient);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);

		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERFORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}
		return resultInfo;

	}

	@Override
	public Patient findPatientById(int id) {
		em = EntityManagerUtil.getEntityManager();
		Patient patient = (Patient) em.createNamedQuery("findPatientById").setParameter("idPatient", id)
				.getSingleResult();

		return patient;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAll() {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		List<Patient> patientLst = (ArrayList<Patient>) em.createQuery("Select p from Patient p").getResultList();
		em.getTransaction().commit();
		return patientLst;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findByName(String name) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		List<Patient> patientLst = (ArrayList<Patient>) em
				.createQuery("Select p from Patient p where p.name like :namePatient")
				.setParameter("namePatient", "%" + name + "%").getResultList();
		em.getTransaction().commit();
		return patientLst;
	}

	@Override
	public ResultInfo createPatientRecord(PatientRecordDto patientRecordDto, PatientBillDto patientBillDto) {
		ResultInfo resultInfo = new ResultInfo();
		em = EntityManagerUtil.getEntityManager();
		try {
			em.getTransaction().begin();
			PatientRecord patientRecord = new PatientRecord(patientRecordDto);
			PatientBill patientBill = new PatientBill(patientBillDto);
			em.persist(patientRecord);
			em.persist(patientBill);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {
			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERFORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}
		return resultInfo;

	}

	@Override
	public ResultInfo updatePatientRecord(PatientRecordDto patientRecordDto) {
		ResultInfo resultInfo = new ResultInfo();
		try {
			em = EntityManagerUtil.getEntityManager();
			em.getTransaction().begin();
			PatientRecord patientRecord = new PatientRecord(patientRecordDto);
			em.merge(patientRecord);
			em.getTransaction().commit();
			resultInfo.setResultType(Constants.PERFORM_SUCCESS);
		} catch (Exception e) {

			em.getTransaction().rollback();
			resultInfo.setResultType(Constants.PERFORM_FAILURE);
			resultInfo.setMesssage(e.getMessage());
		}
		return resultInfo;

	}

	@Override
	public Patient findPatientByMobile(String mobile) {
		em = EntityManagerUtil.getEntityManager();
		Patient patient = (Patient) em.createNamedQuery("findPatientByMobile").setParameter("mobile", mobile)
				.getSingleResult();
		// em.close();
		return patient;
	}

}
