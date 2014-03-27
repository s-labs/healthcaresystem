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

import com.healthcare.model.PatientEntity;

@Entity
@Table(name = "MEDICAL_HISTORY")
public class MedicalHistoryEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid", nullable = false)
	private PatientEntity patient;
	
		@Column
		private	String ip;
		private	String op;
		private String accPatient;
		private String emerPatient;
		private String reasonForVisit;
		private String presentHistory;
		private String pastHistory;
		private String personalHistory;
		private String familyHistory;
		private Date problemForm;
		private String doctorName;
		private String notes;
		private Date fromDate;
		private Date toDate;
		private String progress;
		private String advice;
		
		
		
		public MedicalHistoryEntity() 
		{
			
		}
		public MedicalHistoryEntity(String ip,String op,String accPatient,String emerPatient,
				String reasonForVisit,String presentHistory,String pastHistory,
				String personalHistory,String familyHistory,Date problemForm,String doctorName,
				String notes,Date fromDate,Date toDate,String progress,String advice)	
		{
			this.ip=ip;
			this.op=op;
			this.accPatient=accPatient;
			this.emerPatient=emerPatient;
			this.reasonForVisit=reasonForVisit;
			this.presentHistory=presentHistory;
			this.pastHistory=pastHistory;
			this.personalHistory=personalHistory;
			this.familyHistory=familyHistory;
			this.problemForm=problemForm;
			this.doctorName=doctorName;
			this.notes=notes;
			this.fromDate=fromDate;
			this.toDate=toDate;
			this.progress=progress;
			this.advice=advice;
		}
		
		
		
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
		public String getIp() {
			return ip;
		}
		public void setIp(String ip) {
			this.ip = ip;
		}
		public String getOp() {
			return op;
		}
		public void setOp(String op) {
			this.op = op;
		}
		public String getAccPatient() {
			return accPatient;
		}
		public void setAccPatient(String accPatient) {
			this.accPatient = accPatient;
		}
		public String getEmerPatient() {
			return emerPatient;
		}
		public void setEmerPatient(String emerPatient) {
			this.emerPatient = emerPatient;
		}
		public String getReasonForVisit() {
			return reasonForVisit;
		}
		public void setReasonForVisit(String reasonForVisit) {
			this.reasonForVisit = reasonForVisit;
		}
		public String getPresentHistory() {
			return presentHistory;
		}
		public void setPresentHistory(String presentHistory) {
			this.presentHistory = presentHistory;
		}
		public String getPastHistory() {
			return pastHistory;
		}
		public void setPastHistory(String pastHistory) {
			this.pastHistory = pastHistory;
		}
		public String getPersonalHistory() {
			return personalHistory;
		}
		public void setPersonalHistory(String personalHistory) {
			this.personalHistory = personalHistory;
		}
		public String getFamilyHistory() {
			return familyHistory;
		}
		public void setFamilyHistory(String familyHistory) {
			this.familyHistory = familyHistory;
		}
		public Date getProblemForm() {
			return problemForm;
		}
		public void setProblemForm(Date problemForm) {
			this.problemForm = problemForm;
		}
		public String getDoctorName() {
			return doctorName;
		}
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}
		public Date getFromDate() {
			return fromDate;
		}
		public void setFromDate(Date fromDate) {
			this.fromDate = fromDate;
		}
		public Date getToDate() {
			return toDate;
		}
		public void setToDate(Date toDate) {
			this.toDate = toDate;
		}
		public String getProgress() {
			return progress;
		}
		public void setProgress(String progress) {
			this.progress = progress;
		}
		public String getAdvice() {
			return advice;
		}
		public void setAdvice(String advice) {
			this.advice = advice;
		}
		
		


}
