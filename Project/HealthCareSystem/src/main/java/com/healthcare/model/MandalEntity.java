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
@Table(name = "MANDAL")
public class MandalEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@Column
	private String name;	
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "districtcode",nullable = false)
	private DistrictEntity district;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "healthcentercode",nullable = true)
	private HealthCenterEntity healthCenter;
	
	
	@OneToMany(fetch = FetchType.LAZY, cascade = { CascadeType.ALL })
	@JoinColumn(name = "mandalcode")
	@IndexColumn(name = "code")
	private Set<VillageEntity> villages = new HashSet<VillageEntity>(0);
	

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

	public DistrictEntity getDistrict() {
		return district;
	}

	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}

	public HealthCenterEntity getHealthCenter() {
		return healthCenter;
	}

	public void setHealthCenter(HealthCenterEntity healthCenter) {
		this.healthCenter = healthCenter;
	}

	public Set<VillageEntity> getVillages() {
		return villages;
	}

	public void setVillages(Set<VillageEntity> villages) {
		this.villages = villages;
	}

	
	
	
}
