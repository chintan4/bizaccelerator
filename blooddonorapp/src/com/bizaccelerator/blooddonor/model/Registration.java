package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;

import javax.persistence.*;

import java.util.Date;


/**
 * The persistent class for the registration database table.
 * 
 */
@Entity
@Table(name="registration")
@NamedQuery(name="Registration.findAll", query="SELECT r FROM Registration r")
public class Registration implements Serializable {
	public Registration(String userId, String firstName, String lastName,
			String phoneNumber, String email, Date dob,
			String city, Date registrationDate) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.dob = dob;
		this.city = city;
		this.registrationDate = registrationDate;
	}

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=50)
	private String city;

	@Temporal(TemporalType.DATE)
	private Date dob;

	@Column(length=320)
	private String email;

	@Column(length=20)
	private String firstName;

	@Column(length=20)
	private String lastName;

	@Column(length=20)
	private String phoneNumber;

	@Temporal(TemporalType.DATE)
	private Date registrationDate;

	@Column(length=10)
	private String userId;

	//bi-directional many-to-one association to Bloodgroup
	@ManyToOne
	@JoinColumn(name="bloodGroupId")
	private Bloodgroup bloodgroup;

	public Registration() {
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

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public Date getRegistrationDate() {
		return this.registrationDate;
	}

	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}

	public String getUserId() {
		return this.userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public Bloodgroup getBloodgroup() {
		return this.bloodgroup;
	}

	public void setBloodgroup(Bloodgroup bloodgroup) {
		this.bloodgroup = bloodgroup;
	}

}