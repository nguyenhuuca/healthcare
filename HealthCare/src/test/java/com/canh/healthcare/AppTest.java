package com.canh.healthcare;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import org.hibernate.Session;

import com.canh.healthcare.jpa.entity.AppUser;
import com.canh.healthcare.jpa.utils.EntityManagerUtil;
import com.canh.healthcare.jpa.utils.HibernateUtil;

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
	}

	public void testApp2() {
		entityManager = EntityManagerUtil.getEntityManager();

		entityManager.getTransaction().begin();

		AppUser user = new AppUser("firstuser", "123456", "test_entity");
		entityManager.persist(user);

		entityManager.getTransaction().commit();
		entityManager.close();
	}
}
