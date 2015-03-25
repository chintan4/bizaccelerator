package com.bizaccelerator.blooddonor.entity.util;

import java.util.List;

import javax.persistence.EntityManager;

import com.bizaccelerator.blooddonor.entity.BloodDonorEntityManager;
import com.bizaccelerator.blooddonor.entity.Test;

public class TestUtil {

	private EntityManager em;
	
	public TestUtil() {
		em = BloodDonorEntityManager.initEntityManager();
	}
	private void create(String val1, String val2, String val3, String val4) {
	     try {
			em.getTransaction().begin();
			Test obj1 = new Test(val1, val2, val3, val4);
			em.persist(obj1);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private List read(String searchVal) {
		/*Greeting g = (Greeting) em.createQuery(
	             "select g from Greeting g where g.language = :language")
	             .setParameter("language", "en").getSingleResult();*/
	     List testList = (List) em.createQuery(
	    		 "select g from Test g where g.val4 = :val4").setParameter("val4", searchVal).getResultList();
	     return testList;
	     
	     //System.out.println("Query returned: " + g);
	}
	
	/*public static void main(String args[]) {
		TestUtil testUtil = new TestUtil();
		testUtil.create("val1", "val2", "val3", "val4");
		testUtil.read();
		
	}*/
	
	public void createTest(String val1, String val2, String val3, String val4) {
		create(val1, val2, val3, val4);
	}
	
	public List readTest(String search) {
		return read(search);
	}
}
