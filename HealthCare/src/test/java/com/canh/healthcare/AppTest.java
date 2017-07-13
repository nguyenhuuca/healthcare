package com.canh.healthcare;

import java.util.Date;

import javax.persistence.EntityManager;

import org.hibernate.Session;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.jpa.entity.Patient;
import com.canh.healthcare.jpa.entity.PatientRecord;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.jpa.utils.HibernateUtil;
import com.canh.healthcare.model.PatientDto;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	private EntityManager entityManager;

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}
    /*
	public void testApp1() {
		// SessionFactory sessionFactory = new Configuration().configure()
		// .buildSessionFactory();
		// Session session = sessionFactory.openSession();
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();

		AppUser user = new AppUser("firstuser", "123456", "test");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}*/
    
	public void testApp2() {
		entityManager = EntityManagerUtil.getEntityManager();

		entityManager.getTransaction().begin();

		AppUser user = new AppUser("firstuser", "123456", "test_entity");
		entityManager.persist(user);

		entityManager.getTransaction().commit();
		entityManager.close();
	} 
	
	public void testPatient(){
		entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		
        PatientDto patient = new PatientDto();
		patient.setAddress("canh test");
		patient.setBirthDay("1990");
		patient.setFamilyContact("tan binh");
		patient.setFirstDateJoin(new Date());
		patient.setMale(true);
		patient.setMobile("0123456");
		patient.setName("Nguyễn Ca");
		patient.setUrgentContact("vợ");
		Patient patientEnt = new Patient(patient);
		PatientRecord petientRecord = new PatientRecord(patientEnt, new Date() );
		//patientEnt.getPattientRecords().add(petientRecord);
		entityManager.persist(patientEnt);
		entityManager.getTransaction().commit();
		entityManager.close();
		
	} 
	
	/*public void testPatient2(){
		//Session session = HibernateUtil.getSessionFactory().openSession();
		entityManager = EntityManagerUtil.getEntityManager();
		entityManager.getTransaction().begin();
		//Query query = session.getNamedQuery("findPatientById")
		//		.setString("idPatient", "1");
		int id = 1;
		List patientEnt = entityManager.createNamedQuery("findPatientById")
				.setParameter("idPatient", id)
				.getResultList();
		entityManager.getTransaction().commit();
		entityManager.close();
		//session.close();
	}*/
}
