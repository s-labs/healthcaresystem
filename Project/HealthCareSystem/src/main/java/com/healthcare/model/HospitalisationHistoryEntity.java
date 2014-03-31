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
@Table(name = "hospitalisation_history")
public class HospitalisationHistoryEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid",nullable = false)
	private PatientEntity patient;
	
	@Column
	private String care_provider_name;
	private String care_provider_add_line1;
	private String care_provider_add_line2;
	private String care_provider_city;
	private String care_provider_mandal;
	private String care_provider_district;
	private String care_provider_state;
	private String care_provider_pin_num;
	private Long care_provider_phone_num;
	private String care_provider_email;
	private String insurance_status;
	private String insurance_id;
	private String episode_type;
	private String episode_num;
	private String encounter_type;
	private String encounter_num;
	private Date encounter_date_time;

	public HospitalisationHistoryEntity() {
		
	}//default constructor
	
	public HospitalisationHistoryEntity(String care_provider_name,String care_provider_add_line1,
			String care_provider_add_line2,String care_provider_city,String care_provider_mandal,
			String care_provider_district,String care_provider_state,String care_provider_pin_num,
			Long care_provider_phone_num,String care_provider_email,String insurance_status,
			String insurance_id,String episode_type,String episode_num,String encounter_type,
			String encounter_num,Date encounter_date_time)
	{
		this.care_provider_name=care_provider_name;
		this.care_provider_add_line1=care_provider_add_line1;
		this.care_provider_add_line2=care_provider_add_line2;
		this.care_provider_city=care_provider_city;
		this.care_provider_mandal=care_provider_mandal;
		this.care_provider_district=care_provider_district;
		this.care_provider_state=care_provider_state;
		this.care_provider_pin_num=care_provider_pin_num;
		this.care_provider_phone_num=care_provider_phone_num;
		this.care_provider_email=care_provider_email;
		this.insurance_status=insurance_status;
		this.insurance_id=insurance_id;
		this.episode_type=episode_type;
		this.episode_num=episode_num;
		this.encounter_type=encounter_type;
		this.encounter_num=encounter_num;
		this.encounter_date_time=encounter_date_time;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public PatientEntity getPatient() {
		return patient;
	}

	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}

	public String getCare_provider_name() {
		return care_provider_name;
	}

	public void setCare_provider_name(String care_provider_name) {
		this.care_provider_name = care_provider_name;
	}

	public String getCare_provider_add_line1() {
		return care_provider_add_line1;
	}

	public void setCare_provider_add_line1(String care_provider_add_line1) {
		this.care_provider_add_line1 = care_provider_add_line1;
	}

	public String getCare_provider_add_line2() {
		return care_provider_add_line2;
	}

	public void setCare_provider_add_line2(String care_provider_add_line2) {
		this.care_provider_add_line2 = care_provider_add_line2;
	}

	public String getCare_provider_city() {
		return care_provider_city;
	}

	public void setCare_provider_city(String care_provider_city) {
		this.care_provider_city = care_provider_city;
	}

	public String getCare_provider_mandal() {
		return care_provider_mandal;
	}

	public void setCare_provider_mandal(String care_provider_mandal) {
		this.care_provider_mandal = care_provider_mandal;
	}

	public String getCare_provider_district() {
		return care_provider_district;
	}

	public void setCare_provider_district(String care_provider_district) {
		this.care_provider_district = care_provider_district;
	}

	public String getCare_provider_state() {
		return care_provider_state;
	}

	public void setCare_provider_state(String care_provider_state) {
		this.care_provider_state = care_provider_state;
	}

	public String getCare_provider_pin_num() {
		return care_provider_pin_num;
	}

	public void setCare_provider_pin_num(String care_provider_pin_num) {
		this.care_provider_pin_num = care_provider_pin_num;
	}

	public Long getCare_provider_phone_num() {
		return care_provider_phone_num;
	}

	public void setCare_provider_phone_num(Long care_provider_phone_num) {
		this.care_provider_phone_num = care_provider_phone_num;
	}

	public String getCare_provider_email() {
		return care_provider_email;
	}

	public void setCare_provider_email(String care_provider_email) {
		this.care_provider_email = care_provider_email;
	}

	public String getInsurance_status() {
		return insurance_status;
	}

	public void setInsurance_status(String insurance_status) {
		this.insurance_status = insurance_status;
	}

	public String getInsurance_id() {
		return insurance_id;
	}

	public void setInsurance_id(String insurance_id) {
		this.insurance_id = insurance_id;
	}

	public String getEpisode_type() {
		return episode_type;
	}

	public void setEpisode_type(String episode_type) {
		this.episode_type = episode_type;
	}

	public String getEpisode_num() {
		return episode_num;
	}

	public void setEpisode_num(String episode_num) {
		this.episode_num = episode_num;
	}

	public String getEncounter_type() {
		return encounter_type;
	}

	public void setEncounter_type(String encounter_type) {
		this.encounter_type = encounter_type;
	}

	public String getEncounter_num() {
		return encounter_num;
	}

	public void setEncounter_num(String encounter_num) {
		this.encounter_num = encounter_num;
	}

	public Date getEncounter_date_time() {
		return encounter_date_time;
	}

	public void setEncounter_date_time(Date encounter_date_time) {
		this.encounter_date_time = encounter_date_time;
	}
	
	//setters and getters

}//class
