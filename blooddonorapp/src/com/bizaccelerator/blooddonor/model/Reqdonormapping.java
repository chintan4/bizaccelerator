package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the reqdonormapping database table.
 * 
 */
@Entity
@Table(name="reqdonormapping")
@NamedQuery(name="Reqdonormapping.findAll", query="SELECT r FROM Reqdonormapping r")
public class Reqdonormapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=10)
	private String donorId;

	//bi-directional many-to-one association to Requestdetail
	@ManyToOne
	@JoinColumn(name="requestId")
	private Requestdetail requestdetail;

	public Reqdonormapping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDonorId() {
		return this.donorId;
	}

	public void setDonorId(String donorId) {
		this.donorId = donorId;
	}

	public Requestdetail getRequestdetail() {
		return this.requestdetail;
	}

	public void setRequestdetail(Requestdetail requestdetail) {
		this.requestdetail = requestdetail;
	}

}