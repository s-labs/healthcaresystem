package com.healthcare.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

@Entity
@Table(name = "district")
public class DistrictEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;

	@Column(name = "name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "statecode", nullable = false)
	private StateEntity state;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "healthcentercode", nullable = true)
	private HealthCenterEntity healthCenter;

	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "districtcode")
	@IndexColumn(name = "code")
	private Set<MandalEntity> mandals = new HashSet<MandalEntity>(0);

	public long getCode() {
		return code;
	}

	public void setCode(long code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public StateEntity getState() {
		return state;
	}

	public void setState(StateEntity state) {
		this.state = state;
	}

	public HealthCenterEntity getHealthCenter() {
		return healthCenter;
	}

	public void setHealthCenter(HealthCenterEntity healthCenter) {
		this.healthCenter = healthCenter;
	}

	public Set<MandalEntity> getMandals() {
		return mandals;
	}

	public void setMandals(Set<MandalEntity> mandals) {
		this.mandals = mandals;
	}

}
