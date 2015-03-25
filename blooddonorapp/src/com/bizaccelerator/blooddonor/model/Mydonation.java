package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the mydonations database table.
 * 
 */
@Entity
@Table(name="mydonations")
@NamedQuery(name="Mydonation.findAll", query="SELECT m FROM Mydonation m")
public class Mydonation implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date donationDate;

	@Column(length=50)
	private String organiaztion;

	@Column(length=50)
	private String place;

	@Column(length=10)
	private String userId;

	public Mydonation() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getDonationDate() {
		return this.donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public String getOrganiaztion() {
		return this.organiaztion;
	}

	public void setOrganiaztion(String organiaztion) {
		this.organiaztion = organiaztion;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}