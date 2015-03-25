package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the requeststatus database table.
 * 
 */
@Entity
@Table(name="requeststatus")
@NamedQuery(name="Requeststatus.findAll", query="SELECT r FROM Requeststatus r")
public class Requeststatus implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	//bi-directional many-to-one association to Requestdetail
	@ManyToOne
	@JoinColumn(name="requestId")
	private Requestdetail requestdetail;

	//bi-directional many-to-one association to Reqstatusmapping
	@ManyToOne
	@JoinColumn(name="reqStatusCode")
	private Reqstatusmapping reqstatusmapping;

	public Requeststatus() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Requestdetail getRequestdetail() {
		return this.requestdetail;
	}

	public void setRequestdetail(Requestdetail requestdetail) {
		this.requestdetail = requestdetail;
	}

	public Reqstatusmapping getReqstatusmapping() {
		return this.reqstatusmapping;
	}

	public void setReqstatusmapping(Reqstatusmapping reqstatusmapping) {
		this.reqstatusmapping = reqstatusmapping;
	}

}