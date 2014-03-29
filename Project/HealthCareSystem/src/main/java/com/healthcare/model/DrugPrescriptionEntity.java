package com.healthcare.model;

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
@Table(name = "DRUG_PRESCIPTION_LOOKUP")
public class DrugPrescriptionEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "diseaseCode",nullable = false)
	DiseaseEntity disease;
	
	private String drugPrescription;
	private String notes;
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public DiseaseEntity getDisease() {
		return disease;
	}
	public void setDisease(DiseaseEntity disease) {
		this.disease = disease;
	}
	public String getDrugPrescription() {
		return drugPrescription;
	}
	public void setDrugPrescription(String drugPrescription) {
		this.drugPrescription = drugPrescription;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
}
