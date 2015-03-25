package com.bizaccelerator.blooddonor.entity.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.bizaccelerator.blooddonor.entity.BloodDonorEntityManager;
import com.bizaccelerator.blooddonor.model.Bloodgroup;
import com.bizaccelerator.blooddonor.model.Registration;
import com.bizaccelerator.blooddonor.model.Reqstatusmapping;
import com.bizaccelerator.blooddonor.model.Requestdetail;
import com.bizaccelerator.blooddonor.model.custom.TrimmedRequestDetail;

public class BloodDonorDBUtil {
	private EntityManager em;
	private SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

	public BloodDonorDBUtil() {
		em = BloodDonorEntityManager.initEntityManager();
	}

	public void createRegistration(String userId, String firstName,
			String lastName, String bloodGroup, String phoneNumber,
			String email, String dateOfBirth, String city) {
		Date dob = convertToDate(dateOfBirth);
		Registration registration = new Registration(userId, firstName,
				lastName, phoneNumber, 
				email, dob, city, new Date());
		registration.setBloodgroup(getBloodGroup(bloodGroup));
		em.getTransaction().begin();
		em.persist(registration);
		em.getTransaction().commit();
	}

	/**
	 * @param bloodGroup
	 * @return
	 */
	private Bloodgroup getBloodGroup(String bloodGroup) {
		int bGroup = convertToInt(bloodGroup);
		Bloodgroup bloodGroupObj = (Bloodgroup) em.createQuery(
		         "select bg from Bloodgroup bg where bg.id = :id")
		         .setParameter("id", bGroup).getSingleResult();
		return bloodGroupObj;
	}
	
	public static void main(String args[]) {
		BloodDonorDBUtil bloodDonorDBUtil = new BloodDonorDBUtil();
		//bloodDonorDBUtil.createRegistration("chintan4", "chintan", "desai", "5", "234234", "asasfd", "04/22/1982", "pune");
	}
	
	public void createBloodRequest(String date, String bloodGroup, String quantity, String place, String city) {
		Date donationDate = convertToDate(date);
		Bloodgroup bGroup = getBloodGroup(bloodGroup);
		Reqstatusmapping initialStatus = getInitialStatus();
		int qty = convertToInt(quantity);
		Requestdetail reqDetail = new Requestdetail(donationDate, bGroup, qty, place, city, initialStatus);
		em.getTransaction().begin();
		em.persist(reqDetail);
		em.getTransaction().commit();
	}
	
	private Date convertToDate(String date) {
		
		Date convertedDate = new Date();
		try {
			convertedDate = sdf.parse(date);
		}  catch (ParseException e) {
			e.printStackTrace();
		}
		return convertedDate;
	}
	
	private int convertToInt(String val) {
		return new Integer(val);
	}
	
	private Reqstatusmapping getInitialStatus() {
		Reqstatusmapping reqStatusMapping = (Reqstatusmapping) em.createQuery(
		         "select rq from Reqstatusmapping rq where rq.id = :id")
		         .setParameter("id", 1).getSingleResult();
		return reqStatusMapping;
	}
	
	public ArrayList<TrimmedRequestDetail> getBloodRequests() {
		/* 
		 *  TypedQuery<Country> query =
      	 *	em.createQuery("SELECT c FROM Country c", Country.class);
  		 *	List<Country> results = query.getResultList();
		 */
		Query query = em.createNativeQuery("select * from Requestdetails r where r.donationDate >= CURRENT_DATE", Requestdetail.class);
		//Query query = em.createQuery("select r from Requestdetails r where r.donationDate >= CURRENT_DATE");
		List reqDetailList =  (List) query.getResultList();
		ArrayList<TrimmedRequestDetail> listToReturn = new ArrayList<TrimmedRequestDetail>();
		for (Object result : reqDetailList) {
		    Requestdetail reqDet = (Requestdetail) result;
		    TrimmedRequestDetail trimmedReqDet = new TrimmedRequestDetail();
		    trimmedReqDet.setBloodGroup(reqDet.getBloodgroup().getBloodGroup());
		    trimmedReqDet.setDonationDate(sdf.format(reqDet.getDonationDate()));
		    trimmedReqDet.setPlace(reqDet.getPlace());
		    trimmedReqDet.setCity(reqDet.getCity());
		    trimmedReqDet.setQuantity(reqDet.getQuantity()+"");
		    trimmedReqDet.setRequestStatus(reqDet.getReqstatusmapping().getRequesterStatus());
		    trimmedReqDet.setId(reqDet.getId()+"");
		    listToReturn.add(trimmedReqDet);
		}
		return listToReturn;
	}
}
