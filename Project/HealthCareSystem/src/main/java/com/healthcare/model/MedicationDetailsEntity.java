package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "medical_details")
public class MedicationDetailsEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	@Column
	private String medication_name;
	private String drug_code;
	private String strength;
	private String dose;
	private String route;
	private String frequency;
	private Date from_date;
	private Date to_date;
	private Date next_check_up;
	
	public MedicationDetailsEntity() {
		
	}//default constructor
	
	public MedicationDetailsEntity(String medication_name, String drug_code, String strength,
			String dose, String route, String frequency, Date from_date, Date to_date,Date next_check_up) 
	{
		 this.medication_name=medication_name;
		 this.drug_code=drug_code;
		 this.strength=strength;
		 this.dose=dose;
		 this.route=route;
		 this.frequency=frequency;
		 this.from_date=from_date;
		 this.to_date=to_date;
		 this.next_check_up=next_check_up;
	}// full constructor
	
	//setters & getters

	public Long getUhid() {
		return uhid;
	}

	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}

	public String getMedication_name() {
		return medication_name;
	}

	public void setMedication_name(String medication_name) {
		this.medication_name = medication_name;
	}

	public String getDrug_code() {
		return drug_code;
	}

	public void setDrug_code(String drug_code) {
		this.drug_code = drug_code;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getDose() {
		return dose;
	}

	public void setDose(String dose) {
		this.dose = dose;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getFrequency() {
		return frequency;
	}

	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}

	public Date getFrom_date() {
		return from_date;
	}

	public void setFrom_date(Date from_date) {
		this.from_date = from_date;
	}

	public Date getTo_date() {
		return to_date;
	}

	public void setTo_date(Date to_date) {
		this.to_date = to_date;
	}

	public Date getNext_check_up() {
		return next_check_up;
	}

	public void setNext_check_up(Date next_check_up) {
		this.next_check_up = next_check_up;
	}
	
	
}//class
