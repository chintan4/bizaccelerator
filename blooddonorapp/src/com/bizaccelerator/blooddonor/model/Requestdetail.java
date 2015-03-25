package com.bizaccelerator.blooddonor.model;


import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


/**
 * The persistent class for the requestdetails database table.
 * 
 */
@Entity
@Table(name="requestdetails")
@NamedQuery(name="Requestdetail.findAll", query="SELECT r FROM Requestdetail r")
public class Requestdetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=50)
	private String city;

	@Temporal(TemporalType.DATE)
	private Date donationDate;

	@Column(length=50)
	private String place;

	private int quantity;

	//bi-directional many-to-one association to Reqdonormapping
	@OneToMany(mappedBy="requestdetail")
	private List<Reqdonormapping> reqdonormappings;

	//bi-directional many-to-one association to Bloodgroup
	@ManyToOne
	@JoinColumn(name="bloodGroupId")
	private Bloodgroup bloodgroup;

	//bi-directional many-to-one association to Reqstatusmapping
	@ManyToOne
	@JoinColumn(name="reqStatusId")
	private Reqstatusmapping reqstatusmapping;

	//bi-directional many-to-one association to Requeststatus
	@OneToMany(mappedBy="requestdetail")
	private List<Requeststatus> requeststatuses;

	public Requestdetail() {
	}
	
	public Requestdetail(Date date, Bloodgroup bGroup, int qty, String place,
			String city, Reqstatusmapping reqStatusMapping) {
		this.donationDate = date;
		this.bloodgroup = bGroup;
		this.quantity = qty;
		this.place = place;
		this.city = city;
		this.reqstatusmapping = reqStatusMapping;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Date getDonationDate() {
		return this.donationDate;
	}

	public void setDonationDate(Date donationDate) {
		this.donationDate = donationDate;
	}

	public String getPlace() {
		return this.place;
	}

	public void setPlace(String place) {
		this.place = place;
	}

	public int getQuantity() {
		return this.quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Reqdonormapping> getReqdonormappings() {
		return this.reqdonormappings;
	}

	public void setReqdonormappings(List<Reqdonormapping> reqdonormappings) {
		this.reqdonormappings = reqdonormappings;
	}

	public Reqdonormapping addReqdonormapping(Reqdonormapping reqdonormapping) {
		getReqdonormappings().add(reqdonormapping);
		reqdonormapping.setRequestdetail(this);

		return reqdonormapping;
	}

	public Reqdonormapping removeReqdonormapping(Reqdonormapping reqdonormapping) {
		getReqdonormappings().remove(reqdonormapping);
		reqdonormapping.setRequestdetail(null);

		return reqdonormapping;
	}

	public Bloodgroup getBloodgroup() {
		return this.bloodgroup;
	}

	public void setBloodgroup(Bloodgroup bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

	public Reqstatusmapping getReqstatusmapping() {
		return this.reqstatusmapping;
	}

	public void setReqstatusmapping(Reqstatusmapping reqstatusmapping) {
		this.reqstatusmapping = reqstatusmapping;
	}

	public List<Requeststatus> getRequeststatuses() {
		return this.requeststatuses;
	}

	public void setRequeststatuses(List<Requeststatus> requeststatuses) {
		this.requeststatuses = requeststatuses;
	}

	public Requeststatus addRequeststatus(Requeststatus requeststatus) {
		getRequeststatuses().add(requeststatus);
		requeststatus.setRequestdetail(this);

		return requeststatus;
	}

	public Requeststatus removeRequeststatus(Requeststatus requeststatus) {
		getRequeststatuses().remove(requeststatus);
		requeststatus.setRequestdetail(null);

		return requeststatus;
	}

}