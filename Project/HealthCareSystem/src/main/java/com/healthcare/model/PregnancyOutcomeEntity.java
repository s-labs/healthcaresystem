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

import java.util.Date;

@Entity
@Table(name = "pregnancy_outcome")
public class PregnancyOutcomeEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid", nullable = false)
	private PatientEntity patient;
	
	@Column
	private String PlaceofDelivery;
	private String DeliveryType;
	private String complications;
	private Date DateofDelivery;
	private Date DateofDischarge;
	private String abortion;
	
	public PregnancyOutcomeEntity() {
		// TODO Auto-generated constructor stub
	}//default constructor

	

	public Long getCode() {
		return code;
	}



	public void setCode(Long code) {
		this.code = code;
	}



	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public String getPlaceofDelivery() {
		return PlaceofDelivery;
	}

	public void setPlaceofDelivery(String placeofDelivery) {
		PlaceofDelivery = placeofDelivery;
	}

	public String getDeliveryType() {
		return DeliveryType;
	}

	public void setDeliveryType(String deliveryType) {
		DeliveryType = deliveryType;
	}

	public String getComplications() {
		return complications;
	}

	public void setComplications(String complications) {
		this.complications = complications;
	}

	public Date getDateofDelivery() {
		return DateofDelivery;
	}

	public void setDateofDelivery(Date dateofDelivery) {
		DateofDelivery = dateofDelivery;
	}

	public Date getDateofDischarge() {
		return DateofDischarge;
	}

	public void setDateofDischarge(Date dateofDischarge) {
		DateofDischarge = dateofDischarge;
	}

	public String getAbortion() {
		return abortion;
	}

	public void setAbortion(String abortion) {
		this.abortion = abortion;
	}
	
	
	
	
}//class
