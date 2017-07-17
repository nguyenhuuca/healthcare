package com.canh.healthcare.services.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;

import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientRecord;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.model.PatientDto;
import com.canh.healthcare.model.PatientRecordDto;
import com.canh.healthcare.services.BaseSercvices;
import com.canh.healthcare.services.interfaces.PatientService;

public class PatientServiceImpl extends BaseSercvices implements PatientService {

	public PatientServiceImpl() {
		// em = EntityManagerUtil.getEntityManager();
	}

	public PatientServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void create(PatientDto patient) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Patient patientEnt = new Patient(patient);
		em.persist(patientEnt);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public void update(PatientDto patient) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Patient patientEnt = new Patient(patient);
		patientEnt = em.merge(patientEnt);
		em.getTransaction().commit();
		em.close();

	}

	@Override
	public Patient findPatientById(int id) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		Patient patient = (Patient) em.createNamedQuery("findPatientById").setParameter("idPatient", id)
				.getSingleResult();
		em.getTransaction().commit();
		em.close();
		return patient;

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Patient> findAll() {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		List<Patient> patientLst = (ArrayList<Patient>) em.createQuery("Select p from Patient p").getResultList();
		em.getTransaction().commit();
		em.close();
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
		em.close();
		return patientLst;
	}

	@Override
	public void createPatientRecord(PatientRecordDto patientRecordDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		PatientRecord patientRecord = new PatientRecord(patientRecordDto);
		em.persist(patientRecord);
		em.getTransaction().commit();
		em.close();
		
	}

	@Override
	public void updatePatientRecord(PatientRecordDto patientRecordDto) {
		em = EntityManagerUtil.getEntityManager();
		em.getTransaction().begin();
		PatientRecord patientRecord = new PatientRecord(patientRecordDto);
		em.merge(patientRecord);
		em.getTransaction().commit();
		em.close();
		
	}

}
