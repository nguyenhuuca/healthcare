package services.impl;

import javax.persistence.EntityManager;

import com.canh.healthcare.model.Patient;

import services.interfaces.PatientService;

public class PatientServiceImpl implements PatientService {

	protected EntityManager em;

	public PatientServiceImpl(EntityManager em) {
		this.em = em;
	}

	@Override
	public void create() {
		// TODO Auto-generated method stub

	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public Patient findPatientById(int id) {
		// TODO Auto-generated method stub
		return (Patient)em.createNamedQuery("findPatientById")
				.setParameter("idPatient", id)
				.getSingleResult();
	}

}
