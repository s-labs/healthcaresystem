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

@Entity
@Table(name = "medication_treatment")
public class MedicationTreatmentEntity {
	
	@Id
	@Column(name = "ID")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long code;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "uhid", nullable = false)
	private PatientEntity patient;
	
	
	@Column
	private String ClinicalExamVitalsSystolicBP;	
	private String ClinicalExamVitalsDiastolicBP;
	private String ClinicalExamPulseRate;
	private double ClinicalExamTemperature;
	private double ClinicalExamHeight_cms;
	private double ClinicalExamWeight_kgs;
	private String BloodGroup;
	private String ClinicalExamObservation;
	private String InvestigationResults;
	private String ClinicalSummary;
	private String DiagnosisType;
	private String DiagnosisCodeName;
	private String DiagnosisCode;
	private String DiagnosisDescription;
	private String TreatmentPlanInvestigations;
	private String TreatmentPlanMedication;
	private String TreatmentPlanProcedure;
	private String TreatmentPlanReferral;
	private String OtherTreatmentPlanType;
	private String OtherTreatmentPlanDetails; 
	private String CurrentClinicalStatus;
	
	public MedicationTreatmentEntity() {
		
	}//default constructor

	

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



	public String getClinicalExamVitalsSystolicBP() {
		return ClinicalExamVitalsSystolicBP;
	}

	public void setClinicalExamVitalsSystolicBP(String clinicalExamVitalsSystolicBP) {
		ClinicalExamVitalsSystolicBP = clinicalExamVitalsSystolicBP;
	}

	public String getClinicalExamVitalsDiastolicBP() {
		return ClinicalExamVitalsDiastolicBP;
	}

	public void setClinicalExamVitalsDiastolicBP(
			String clinicalExamVitalsDiastolicBP) {
		ClinicalExamVitalsDiastolicBP = clinicalExamVitalsDiastolicBP;
	}

	public String getClinicalExamPulseRate() {
		return ClinicalExamPulseRate;
	}

	public void setClinicalExamPulseRate(String clinicalExamPulseRate) {
		ClinicalExamPulseRate = clinicalExamPulseRate;
	}

	public double getClinicalExamTemperature() {
		return ClinicalExamTemperature;
	}

	public void setClinicalExamTemperature(double clinicalExamTemperature) {
		ClinicalExamTemperature = clinicalExamTemperature;
	}

	public double getClinicalExamHeight_cms() {
		return ClinicalExamHeight_cms;
	}

	public void setClinicalExamHeight_cms(double clinicalExamHeight_cms) {
		ClinicalExamHeight_cms = clinicalExamHeight_cms;
	}

	public double getClinicalExamWeight_kgs() {
		return ClinicalExamWeight_kgs;
	}

	public void setClinicalExamWeight_kgs(double clinicalExamWeight_kgs) {
		ClinicalExamWeight_kgs = clinicalExamWeight_kgs;
	}

	public String getBloodGroup() {
		return BloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		BloodGroup = bloodGroup;
	}

	public String getClinicalExamObservation() {
		return ClinicalExamObservation;
	}

	public void setClinicalExamObservation(String clinicalExamObservation) {
		ClinicalExamObservation = clinicalExamObservation;
	}

	public String getInvestigationResults() {
		return InvestigationResults;
	}

	public void setInvestigationResults(String investigationResults) {
		InvestigationResults = investigationResults;
	}

	public String getClinicalSummary() {
		return ClinicalSummary;
	}

	public void setClinicalSummary(String clinicalSummary) {
		ClinicalSummary = clinicalSummary;
	}

	public String getDiagnosisType() {
		return DiagnosisType;
	}

	public void setDiagnosisType(String diagnosisType) {
		DiagnosisType = diagnosisType;
	}

	public String getDiagnosisCodeName() {
		return DiagnosisCodeName;
	}

	public void setDiagnosisCodeName(String diagnosisCodeName) {
		DiagnosisCodeName = diagnosisCodeName;
	}

	public String getDiagnosisCode() {
		return DiagnosisCode;
	}

	public void setDiagnosisCode(String diagnosisCode) {
		DiagnosisCode = diagnosisCode;
	}

	public String getDiagnosisDescription() {
		return DiagnosisDescription;
	}

	public void setDiagnosisDescription(String diagnosisDescription) {
		DiagnosisDescription = diagnosisDescription;
	}

	public String getTreatmentPlanInvestigations() {
		return TreatmentPlanInvestigations;
	}

	public void setTreatmentPlanInvestigations(String treatmentPlanInvestigations) {
		TreatmentPlanInvestigations = treatmentPlanInvestigations;
	}

	public String getTreatmentPlanMedication() {
		return TreatmentPlanMedication;
	}

	public void setTreatmentPlanMedication(String treatmentPlanMedication) {
		TreatmentPlanMedication = treatmentPlanMedication;
	}

	public String getTreatmentPlanProcedure() {
		return TreatmentPlanProcedure;
	}

	public void setTreatmentPlanProcedure(String treatmentPlanProcedure) {
		TreatmentPlanProcedure = treatmentPlanProcedure;
	}

	public String getTreatmentPlanReferral() {
		return TreatmentPlanReferral;
	}

	public void setTreatmentPlanReferral(String treatmentPlanReferral) {
		TreatmentPlanReferral = treatmentPlanReferral;
	}

	public String getOtherTreatmentPlanType() {
		return OtherTreatmentPlanType;
	}

	public void setOtherTreatmentPlanType(String otherTreatmentPlanType) {
		OtherTreatmentPlanType = otherTreatmentPlanType;
	}

	public String getOtherTreatmentPlanDetails() {
		return OtherTreatmentPlanDetails;
	}

	public void setOtherTreatmentPlanDetails(String otherTreatmentPlanDetails) {
		OtherTreatmentPlanDetails = otherTreatmentPlanDetails;
	}

	public String getCurrentClinicalStatus() {
		return CurrentClinicalStatus;
	}

	public void setCurrentClinicalStatus(String currentClinicalStatus) {
		CurrentClinicalStatus = currentClinicalStatus;
	}

	
	

}//class
