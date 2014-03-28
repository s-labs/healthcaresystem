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
@Table(name = "pregnancy_history")
public class PregnancyHistoryEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid", nullable = false)
	private PatientEntity patient;
	
	
	public PatientEntity getPatient() {
		return patient;
	}


	public void setPatient(PatientEntity patient) {
		this.patient = patient;
	}


	@Column
	private Date lmp;
	private Date first_anc;
	private Date second_anc;
	private Date third_anc;
	private Date fourth_anc;
	private Date tt1;
	private Date tt2;
	private Date ttbooster;
	private String complication;
	private String rti_sti;
	private Date ifa_tablets_given;
	private String anaemia_hb_level;
	
	public PregnancyHistoryEntity() {
		// TODO Auto-generated constructor stub
	}
	
	
	public PregnancyHistoryEntity(Date lmp, Date first_anc, Date second_anc,Date third_anc, 
			Date fourth_anc, Date tt1,Date tt2,Date ttbooster, String complication, String rti_sti,
			Date ifa_tablets_given, String anaemia_hb_level)
	{
		this.lmp=lmp;
		this.first_anc=first_anc;
		this.second_anc=second_anc;
		this.third_anc=third_anc;
		this.fourth_anc=fourth_anc;
		this.tt1=tt1;
		this.tt2=tt2;
		this.ttbooster=ttbooster;
		this.complication=complication;
		this.rti_sti=rti_sti;
		this.ifa_tablets_given=ifa_tablets_given;
		this.anaemia_hb_level=anaemia_hb_level;
		
	}


	public Date getLmp() {
		return lmp;
	}


	public void setLmp(Date lmp) {
		this.lmp = lmp;
	}


	public Date getFirst_anc() {
		return first_anc;
	}


	public void setFirst_anc(Date first_anc) {
		this.first_anc = first_anc;
	}


	public Date getSecond_anc() {
		return second_anc;
	}


	public void setSecond_anc(Date second_anc) {
		this.second_anc = second_anc;
	}


	public Date getThird_anc() {
		return third_anc;
	}


	public void setThird_anc(Date third_anc) {
		this.third_anc = third_anc;
	}


	public Date getFourth_anc() {
		return fourth_anc;
	}


	public void setFourth_anc(Date fourth_anc) {
		this.fourth_anc = fourth_anc;
	}


	public Date getTt1() {
		return tt1;
	}


	public void setTt1(Date tt1) {
		this.tt1 = tt1;
	}


	public Date getTt2() {
		return tt2;
	}


	public void setTt2(Date tt2) {
		this.tt2 = tt2;
	}


	public Date getTtbooster() {
		return ttbooster;
	}


	public void setTtbooster(Date ttbooster) {
		this.ttbooster = ttbooster;
	}


	public String getComplication() {
		return complication;
	}


	public void setComplication(String complication) {
		this.complication = complication;
	}


	public String getRti_sti() {
		return rti_sti;
	}


	public void setRti_sti(String rti_sti) {
		this.rti_sti = rti_sti;
	}


	public Date getIfa_tablets_given() {
		return ifa_tablets_given;
	}


	public void setIfa_tablets_given(Date ifa_tablets_given) {
		this.ifa_tablets_given = ifa_tablets_given;
	}


	public String getAnaemia_hb_level() {
		return anaemia_hb_level;
	}


	public void setAnaemia_hb_level(String anaemia_hb_level) {
		this.anaemia_hb_level = anaemia_hb_level;
	}
	

}
