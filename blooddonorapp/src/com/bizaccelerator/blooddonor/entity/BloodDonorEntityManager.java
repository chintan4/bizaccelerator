package com.bizaccelerator.blooddonor.entity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class BloodDonorEntityManager {
	
	private static EntityManager em;
	private static String PERSISTENT_ENTITY_UNIT = "test";
	
	public static EntityManager initEntityManager() {
	     if (null == em) {
			EntityManagerFactory emf = Persistence
					.createEntityManagerFactory(PERSISTENT_ENTITY_UNIT);
			em = emf.createEntityManager();
		}
		return em;
	}

}
