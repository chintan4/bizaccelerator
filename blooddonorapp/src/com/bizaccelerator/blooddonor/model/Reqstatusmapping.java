package com.bizaccelerator.blooddonor.model;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the reqstatusmapping database table.
 * 
 */
@Entity
@Table(name="reqstatusmapping")
@NamedQuery(name="Reqstatusmapping.findAll", query="SELECT r FROM Reqstatusmapping r")
public class Reqstatusmapping implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(unique=true, nullable=false)
	private int id;

	@Column(length=20)
	private String requesterStatus;

	//bi-directional many-to-one association to Requeststatus
	@OneToMany(mappedBy="reqstatusmapping")
	private List<Requeststatus> requeststatuses;

	public Reqstatusmapping() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getRequesterStatus() {
		return this.requesterStatus;
	}

	public void setRequesterStatus(String requesterStatus) {
		this.requesterStatus = requesterStatus;
	}

	public List<Requeststatus> getRequeststatuses() {
		return this.requeststatuses;
	}

	public void setRequeststatuses(List<Requeststatus> requeststatuses) {
		this.requeststatuses = requeststatuses;
	}

	public Requeststatus addRequeststatus(Requeststatus requeststatus) {
		getRequeststatuses().add(requeststatus);
		requeststatus.setReqstatusmapping(this);

		return requeststatus;
	}

	public Requeststatus removeRequeststatus(Requeststatus requeststatus) {
		getRequeststatuses().remove(requeststatus);
		requeststatus.setReqstatusmapping(null);

		return requeststatus;
	}

}