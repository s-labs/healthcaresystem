package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "DISEASE_INFORMATION_LOOKUP")
public class DiseaseEntity {
	
	@Id
	@Column(name = "DiseaseCode")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long diseaseCode;
	
	@Column
	private String diseaseName;
	private String diseaseDescription;
	public long getDiseaseCode() {
		return diseaseCode;
	}
	public void setDiseaseCode(long diseaseCode) {
		this.diseaseCode = diseaseCode;
	}
	public String getDiseaseName() {
		return diseaseName;
	}
	public void setDiseaseName(String diseaseName) {
		this.diseaseName = diseaseName;
	}
	public String getDiseaseDescription() {
		return diseaseDescription;
	}
	public void setDiseaseDescription(String diseaseDescription) {
		this.diseaseDescription = diseaseDescription;
	}
	


}
