package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "pregnancy_outcome")
public class PregnancyOutcomeEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	private String delivery_place;
	private String delivery_type;
	private String complications;
	private Date delivery_date;
	private Date discharge_date;
	private String abortion;
	
	public PregnancyOutcomeEntity() {
		// TODO Auto-generated constructor stub
	}//default constructor
	
	
	public PregnancyOutcomeEntity(String delivery_place,String delivery_type,String complications,
			Date delivery_date,Date discharge_date,String abortion)
	{
		this.delivery_date=delivery_date;
		this.delivery_type=delivery_type;
		this.complications=complications;
		this.delivery_date=delivery_date;
		this.discharge_date=discharge_date;
		this.abortion=abortion;
	}//full constructor
	
	
	//setters & getters
	public Long getUhid() {
		return uhid;
	}
	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}
	public String getDelivery_place() {
		return delivery_place;
	}
	public void setDelivery_place(String delivery_place) {
		this.delivery_place = delivery_place;
	}
	public String getDelivery_type() {
		return delivery_type;
	}
	public void setDelivery_type(String delivery_type) {
		this.delivery_type = delivery_type;
	}
	public String getComplications() {
		return complications;
	}
	public void setComplications(String complications) {
		this.complications = complications;
	}
	public Date getDelivery_date() {
		return delivery_date;
	}
	public void setDelivery_date(Date delivery_date) {
		this.delivery_date = delivery_date;
	}
	public Date getDischarge_date() {
		return discharge_date;
	}
	public void setDischarge_date(Date discharge_date) {
		this.discharge_date = discharge_date;
	}
	public String getAbortion() {
		return abortion;
	}
	public void setAbortion(String abortion) {
		this.abortion = abortion;
	}
		
	
}//class
