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
@Table(name = "SURGICAL_HISTORY")
public class SurgicalHistoryEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid", nullable = false)
	private PatientEntity patient;
	
		@Column
		private String surgery ;
		private Date surgeryDate;
		private String doctorName ;
		private String placeofSurgery;		
		private String surgeryProcedure;
		private String status;
		private String notes;
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
		public String getSurgery() {
			return surgery;
		}
		public void setSurgery(String surgery) {
			this.surgery = surgery;
		}
		public Date getSurgeryDate() {
			return surgeryDate;
		}
		public void setSurgeryDate(Date surgeryDate) {
			this.surgeryDate = surgeryDate;
		}
		public String getDoctorName() {
			return doctorName;
		}
		public void setDoctorName(String doctorName) {
			this.doctorName = doctorName;
		}
		public String getPlaceofSurgery() {
			return placeofSurgery;
		}
		public void setPlaceofSurgery(String placeofSurgery) {
			this.placeofSurgery = placeofSurgery;
		}
		public String getSurgeryProcedure() {
			return surgeryProcedure;
		}
		public void setSurgeryProcedure(String surgeryProcedure) {
			this.surgeryProcedure = surgeryProcedure;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getNotes() {
			return notes;
		}
		public void setNotes(String notes) {
			this.notes = notes;
		}

}
