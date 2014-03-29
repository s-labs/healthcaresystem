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
@Table(name = "infant_details")
public class InfantDetailsEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid",nullable = false)
	private PatientEntity patient;
	
	@Column
	private String OutcomeNumber;
	private String LastName;
	private String MiddleName;
	private String FirstName;
	private String Gender;
	private Date DateTimeofBirth;
	private double Weight;
	private String Initiatedbreastfeedingwithinonehour;
	private String Remarks;
	public long getCode() {
		return code;
	}
	public void setCode(long code) {
		this.code = code;
	}
	public PatientEntity getPatient() {
		return patient;
	}
	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}
	public String getOutcomeNumber() {
		return OutcomeNumber;
	}
	public void setOutcomeNumber(String outcomeNumber) {
		OutcomeNumber = outcomeNumber;
	}
	public String getLastName() {
		return LastName;
	}
	public void setLastName(String lastName) {
		LastName = lastName;
	}
	public String getMiddleName() {
		return MiddleName;
	}
	public void setMiddleName(String middleName) {
		MiddleName = middleName;
	}
	public String getFirstName() {
		return FirstName;
	}
	public void setFirstName(String firstName) {
		FirstName = firstName;
	}
	public String getGender() {
		return Gender;
	}
	public void setGender(String gender) {
		Gender = gender;
	}
	public Date getDateTimeofBirth() {
		return DateTimeofBirth;
	}
	public void setDateTimeofBirth(Date dateTimeofBirth) {
		DateTimeofBirth = dateTimeofBirth;
	}
	public double getWeight() {
		return Weight;
	}
	public void setWeight(double weight) {
		Weight = weight;
	}
	public String getInitiatedbreastfeedingwithinonehour() {
		return Initiatedbreastfeedingwithinonehour;
	}
	public void setInitiatedbreastfeedingwithinonehour(
			String initiatedbreastfeedingwithinonehour) {
		Initiatedbreastfeedingwithinonehour = initiatedbreastfeedingwithinonehour;
	}
	public String getRemarks() {
		return Remarks;
	}
	public void setRemarks(String remarks) {
		Remarks = remarks;
	}
	
	

}
