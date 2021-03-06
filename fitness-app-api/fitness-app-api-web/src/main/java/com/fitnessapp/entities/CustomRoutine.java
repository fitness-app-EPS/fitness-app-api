/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "custom_routine", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "CustomRoutine.findAll", query = "SELECT c FROM CustomRoutine c"),
	@NamedQuery(name = "CustomRoutine.findById", query = "SELECT c FROM CustomRoutine c WHERE c.id = :id")})
public class CustomRoutine implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@JoinColumn(name = "client_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Client clientId;
	@JoinColumn(name = "trainer_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private Trainer trainerId;

	public CustomRoutine() {
	}

	public CustomRoutine(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Client getClientId() {
		return clientId;
	}

	public void setClientId(Client clientId) {
		this.clientId = clientId;
	}

	public Trainer getTrainerId() {
		return trainerId;
	}

	public void setTrainerId(Trainer trainerId) {
		this.trainerId = trainerId;
	}

	@Override
	public int hashCode() {
		int hash = 0;
		hash += (id != null ? id.hashCode() : 0);
		return hash;
	}

	@Override
	public boolean equals(Object object) {
		// TODO: Warning - this method won't work in the case the id fields are not set
		if (!(object instanceof CustomRoutine)) {
			return false;
		}
		CustomRoutine other = (CustomRoutine) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.CustomRoutine[ id=" + id + " ]";
	}
	
}
