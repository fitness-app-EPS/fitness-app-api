/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.fitnessapp.entities;

import java.io.Serializable;
import java.util.List;
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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Naluem
 */
@Entity
@Table(name = "advanced_workout", catalog = "fitnessapp", schema = "public")
@XmlRootElement
@NamedQueries({
	@NamedQuery(name = "AdvancedWorkout.findAll", query = "SELECT a FROM AdvancedWorkout a"),
	@NamedQuery(name = "AdvancedWorkout.findById", query = "SELECT a FROM AdvancedWorkout a WHERE a.id = :id")})
public class AdvancedWorkout implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Basic(optional = false)
        @Column(nullable = false)
	private Integer id;
	@JoinColumn(name = "body_type_id", referencedColumnName = "id")
        @ManyToOne(fetch = FetchType.EAGER)
	private BodyType bodyTypeId;
	@OneToMany(mappedBy = "advancedWorkoutId", fetch = FetchType.EAGER)
	private List<AdvancedExercise> advancedExerciseList;
	@OneToMany(mappedBy = "advancedWorkoutId", fetch = FetchType.EAGER)
	private List<DailyAdvancedWorkout> dailyAdvancedWorkoutList;

	public AdvancedWorkout() {
	}

	public AdvancedWorkout(Integer id) {
		this.id = id;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BodyType getBodyTypeId() {
		return bodyTypeId;
	}

	public void setBodyTypeId(BodyType bodyTypeId) {
		this.bodyTypeId = bodyTypeId;
	}

	@XmlTransient
	public List<AdvancedExercise> getAdvancedExerciseList() {
		return advancedExerciseList;
	}

	public void setAdvancedExerciseList(List<AdvancedExercise> advancedExerciseList) {
		this.advancedExerciseList = advancedExerciseList;
	}

	@XmlTransient
	public List<DailyAdvancedWorkout> getDailyAdvancedWorkoutList() {
		return dailyAdvancedWorkoutList;
	}

	public void setDailyAdvancedWorkoutList(List<DailyAdvancedWorkout> dailyAdvancedWorkoutList) {
		this.dailyAdvancedWorkoutList = dailyAdvancedWorkoutList;
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
		if (!(object instanceof AdvancedWorkout)) {
			return false;
		}
		AdvancedWorkout other = (AdvancedWorkout) object;
		if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "com.fitnessapp.entities.AdvancedWorkout[ id=" + id + " ]";
	}
	
}