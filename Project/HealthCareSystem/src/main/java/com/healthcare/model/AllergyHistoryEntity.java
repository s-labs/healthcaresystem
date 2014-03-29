package com.healthcare.model;

import java.util.Date;

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
@Table(name = "ALLERGY_HISTORY")
public class AllergyHistoryEntity {

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid",nullable = false)
	private PatientEntity patient;
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@Column
	private String allergicTO;
	private Date reactionDate;
	private String reactionType;
	private String prescription;
	private String notes;
	private String doctorName;
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public String getAllergicTO() {
		return allergicTO;
	}
	public void setAllergicTO(String allergicTO) {
		this.allergicTO = allergicTO;
	}
	public Date getReactionDate() {
		return reactionDate;
	}
	public void setReactionDate(Date reactionDate) {
		this.reactionDate = reactionDate;
	}
	public String getReactionType() {
		return reactionType;
	}
	public void setReactionType(String reactionType) {
		this.reactionType = reactionType;
	}
	public String getPrescription() {
		return prescription;
	}
	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}


}
