package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the bloodgroup database table.
 * 
 */
@Entity
@Table(name="bloodgroup")
@NamedQuery(name="Bloodgroup.findAll", query="SELECT b FROM Bloodgroup b")
public class Bloodgroup implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	public Bloodgroup(String bloodGroup) {
		super();
		this.bloodGroup = bloodGroup;
	}

	@Column(length=6)
	private String bloodGroup;

	//bi-directional many-to-one association to Registration
	@OneToMany(mappedBy="bloodgroup")
	private List<Registration> registrations;

	//bi-directional many-to-one association to Requestdetail
	@OneToMany(mappedBy="bloodgroup")
	private List<Requestdetail> requestdetails;

	public Bloodgroup() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBloodGroup() {
		return this.bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public List<Registration> getRegistrations() {
		return this.registrations;
	}

	public void setRegistrations(List<Registration> registrations) {
		this.registrations = registrations;
	}

	public Registration addRegistration(Registration registration) {
		getRegistrations().add(registration);
		registration.setBloodgroup(this);

		return registration;
	}

	public Registration removeRegistration(Registration registration) {
		getRegistrations().remove(registration);
		registration.setBloodgroup(null);

		return registration;
	}

	public List<Requestdetail> getRequestdetails() {
		return this.requestdetails;
	}

	public void setRequestdetails(List<Requestdetail> requestdetails) {
		this.requestdetails = requestdetails;
	}

	public Requestdetail addRequestdetail(Requestdetail requestdetail) {
		getRequestdetails().add(requestdetail);
		requestdetail.setBloodgroup(this);

		return requestdetail;
	}

	public Requestdetail removeRequestdetail(Requestdetail requestdetail) {
		getRequestdetails().remove(requestdetail);
		requestdetail.setBloodgroup(null);

		return requestdetail;
	}

}