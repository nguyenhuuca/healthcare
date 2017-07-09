package com.canh.healthcare.jpa.utils;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {
	private static EntityManager entityManager;

	private EntityManagerUtil() {
	}

	public static EntityManager getEntityManager() {
		if (entityManager == null) {
			EntityManagerFactory emFactory = Persistence.createEntityManagerFactory("jpa-healthcare");
			return emFactory.createEntityManager();
		}
		return entityManager;
	}

}
