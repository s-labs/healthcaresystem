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
@Table(name = "pnc_details")
public class PncDetailsEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid",nullable = false)
	private PatientEntity patient;
	
	@Column
	private String PNCHomevisit ;
	private String  PNCComplications ;
	private String POST_PARTUM_CONTRACEPTION_METHOD;
	
	@Column
	private Date PNCCheckup;
	
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
	public String getPNCHomevisit() {
		return PNCHomevisit;
	}
	public void setPNCHomevisit(String pNCHomevisit) {
		PNCHomevisit = pNCHomevisit;
	}
	public String getPNCComplications() {
		return PNCComplications;
	}
	public void setPNCComplications(String pNCComplications) {
		PNCComplications = pNCComplications;
	}
	public String getPOST_PARTUM_CONTRACEPTION_METHOD() {
		return POST_PARTUM_CONTRACEPTION_METHOD;
	}
	public void setPOST_PARTUM_CONTRACEPTION_METHOD(
			String pOST_PARTUM_CONTRACEPTION_METHOD) {
		POST_PARTUM_CONTRACEPTION_METHOD = pOST_PARTUM_CONTRACEPTION_METHOD;
	}
	public Date getPNCCheckup() {
		return PNCCheckup;
	}
	public void setPNCCheckup(Date pNCCheckup) {
		PNCCheckup = pNCCheckup;
	}
	

}
