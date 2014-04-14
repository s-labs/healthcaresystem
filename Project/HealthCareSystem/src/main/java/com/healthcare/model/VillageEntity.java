package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "village")
public class VillageEntity {

	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;

	@Column(name = "Name")
	private String name;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "mandalcode", nullable = false)
	private MandalEntity mandal;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "healthcentercode", nullable = true)
	private HealthCenterEntity healthCenter;

	
	
	@Column(name = "Distance_0_5_KMS")
	private boolean Distance_0_5_KMS;
	
	@Column(name = "Distance_5_10_KMS")
	private boolean Distance_5_10_KMS;
	
	@Column(name = "Distance_More_Than10_KMS")
	private boolean Distance_More_Than10_KMS;
	
	//@Column(name = "Village_BlockPHC_CHC_Code", nullable=true)
	//private int Village_BlockPHC_CHC_Code;
	

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

	public MandalEntity getMandal() {
		return mandal;
	}

	public void setMandal(MandalEntity mandal) {
		this.mandal = mandal;
	}

	public boolean isDistance_0_5_KMS() {
		return Distance_0_5_KMS;
	}

	public void setDistance_0_5_KMS(boolean distance_0_5_KMS) {
		Distance_0_5_KMS = distance_0_5_KMS;
	}

	public boolean isDistance_5_10_KMS() {
		return Distance_5_10_KMS;
	}

	public void setDistance_5_10_KMS(boolean distance_5_10_KMS) {
		Distance_5_10_KMS = distance_5_10_KMS;
	}

	public boolean isDistance_More_Than10_KMS() {
		return Distance_More_Than10_KMS;
	}

	public void setDistance_More_Than10_KMS(boolean distance_More_Than10_KMS) {
		Distance_More_Than10_KMS = distance_More_Than10_KMS;
	}
/*
	public int getVillage_BlockPHC_CHC_Code() {
		return Village_BlockPHC_CHC_Code;
	}

	public void setVillage_BlockPHC_CHC_Code(int village_BlockPHC_CHC_Code) {
		Village_BlockPHC_CHC_Code = village_BlockPHC_CHC_Code;
	}
*/
	public HealthCenterEntity getHealthCenter() {
		return healthCenter;
	}

	public void setHealthCenter(HealthCenterEntity healthCenter) {
		this.healthCenter = healthCenter;
	}

	

}
