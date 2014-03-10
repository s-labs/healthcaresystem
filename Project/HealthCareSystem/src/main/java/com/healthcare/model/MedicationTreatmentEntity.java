package com.healthcare.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "medication_treatment")
public class MedicationTreatmentEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	@Column
	private String clinic_exam_vitals_systolic_bp;	
	private String clinic_exam_vitals_diastolic_bp;
	private String clinic_exam_pulse_rate;
	private double clinic_exam_temperature;
	private double clinic_exam_height;
	private double clinic_exam_weight;
	private String blood_group;
	private String clinic_exam_observatioin;
	private String investigation_results;
	private String clinical_summery;
	private String diagnosis_type;
	private String diagnosis_code_name;
	private String diagnosis_code;
	private String diagnosis_description;
	private String treatment_plan_investigations;
	private String treatment_plan_medication;
	private String treatment_plan_procedure;
	private String treatment_plan_referral;
	private String other_treatment_plan_type;
	private String other_treatment_plan_details; 
	private String current_clinical_status;
	
	public MedicationTreatmentEntity() {
		
	}//default constructor
	
	public MedicationTreatmentEntity(String clinic_exam_vitals_systolic_bp, String clinic_exam_vitals_diastolic_bp,
			String clinic_exam_pulse_rate,double clinic_exam_temperature, double clinic_exam_height,
			double clinic_exam_weight, String blood_group,String clinic_exam_observatioin,
			String investigation_results,String clinical_summery, String diagnosis_type,String diagnosis_code_name,
			String diagnosis_code,String diagnosis_description,String treatment_plan_investigations, 
			String treatment_plan_medication, String treatment_plan_procedure, String treatment_plan_referral,
			String other_treatment_plan_type, String other_treatment_plan_details, String current_clinical_status)
	{
		this.clinic_exam_vitals_systolic_bp=clinic_exam_vitals_systolic_bp;	
		this.clinic_exam_vitals_diastolic_bp=clinic_exam_vitals_diastolic_bp;
		this.clinic_exam_pulse_rate=clinic_exam_pulse_rate;
		this.clinic_exam_temperature=clinic_exam_temperature;
		this.clinic_exam_height=clinic_exam_height;
		this.clinic_exam_weight=clinic_exam_weight;
		this.blood_group=blood_group;
		this.clinic_exam_observatioin=clinic_exam_observatioin;
		this.investigation_results=investigation_results;
		this.clinical_summery=clinical_summery;
		this.diagnosis_type=diagnosis_type;
		this.diagnosis_code_name=diagnosis_code_name;
		this.diagnosis_code=diagnosis_code;
		this.diagnosis_description=diagnosis_description;
		this.treatment_plan_investigations=treatment_plan_investigations;
		this.treatment_plan_medication=treatment_plan_medication;
		this.treatment_plan_procedure=treatment_plan_procedure;
		this.treatment_plan_referral=treatment_plan_referral;
		this.other_treatment_plan_type=other_treatment_plan_type;
		this.other_treatment_plan_details=other_treatment_plan_details; 
		this.current_clinical_status=current_clinical_status;
		
	}// full constructor
	
	
	//setters & getters

	public Long getUhid() {
		return uhid;
	}

	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}

	public String getClinic_exam_vitals_systolic_bp() {
		return clinic_exam_vitals_systolic_bp;
	}

	public void setClinic_exam_vitals_systolic_bp(
			String clinic_exam_vitals_systolic_bp) {
		this.clinic_exam_vitals_systolic_bp = clinic_exam_vitals_systolic_bp;
	}

	public String getClinic_exam_vitals_diastolic_bp() {
		return clinic_exam_vitals_diastolic_bp;
	}

	public void setClinic_exam_vitals_diastolic_bp(
			String clinic_exam_vitals_diastolic_bp) {
		this.clinic_exam_vitals_diastolic_bp = clinic_exam_vitals_diastolic_bp;
	}

	public String getClinic_exam_pulse_rate() {
		return clinic_exam_pulse_rate;
	}

	public void setClinic_exam_pulse_rate(String clinic_exam_pulse_rate) {
		this.clinic_exam_pulse_rate = clinic_exam_pulse_rate;
	}

	public double getClinic_exam_temperature() {
		return clinic_exam_temperature;
	}

	public void setClinic_exam_temperature(double clinic_exam_temperature) {
		this.clinic_exam_temperature = clinic_exam_temperature;
	}

	public double getClinic_exam_height() {
		return clinic_exam_height;
	}

	public void setClinic_exam_height(double clinic_exam_height) {
		this.clinic_exam_height = clinic_exam_height;
	}

	public double getClinic_exam_weight() {
		return clinic_exam_weight;
	}

	public void setClinic_exam_weight(double clinic_exam_weight) {
		this.clinic_exam_weight = clinic_exam_weight;
	}

	public String getBlood_group() {
		return blood_group;
	}

	public void setBlood_group(String blood_group) {
		this.blood_group = blood_group;
	}

	public String getClinic_exam_observatioin() {
		return clinic_exam_observatioin;
	}

	public void setClinic_exam_observatioin(String clinic_exam_observatioin) {
		this.clinic_exam_observatioin = clinic_exam_observatioin;
	}

	public String getInvestigation_results() {
		return investigation_results;
	}

	public void setInvestigation_results(String investigation_results) {
		this.investigation_results = investigation_results;
	}

	public String getClinical_summery() {
		return clinical_summery;
	}

	public void setClinical_summery(String clinical_summery) {
		this.clinical_summery = clinical_summery;
	}

	public String getDiagnosis_type() {
		return diagnosis_type;
	}

	public void setDiagnosis_type(String diagnosis_type) {
		this.diagnosis_type = diagnosis_type;
	}

	public String getDiagnosis_code_name() {
		return diagnosis_code_name;
	}

	public void setDiagnosis_code_name(String diagnosis_code_name) {
		this.diagnosis_code_name = diagnosis_code_name;
	}

	public String getDiagnosis_code() {
		return diagnosis_code;
	}

	public void setDiagnosis_code(String diagnosis_code) {
		this.diagnosis_code = diagnosis_code;
	}

	public String getDiagnosis_description() {
		return diagnosis_description;
	}

	public void setDiagnosis_description(String diagnosis_description) {
		this.diagnosis_description = diagnosis_description;
	}

	public String getTreatment_plan_investigations() {
		return treatment_plan_investigations;
	}

	public void setTreatment_plan_investigations(
			String treatment_plan_investigations) {
		this.treatment_plan_investigations = treatment_plan_investigations;
	}

	public String getTreatment_plan_medication() {
		return treatment_plan_medication;
	}

	public void setTreatment_plan_medication(String treatment_plan_medication) {
		this.treatment_plan_medication = treatment_plan_medication;
	}

	public String getTreatment_plan_procedure() {
		return treatment_plan_procedure;
	}

	public void setTreatment_plan_procedure(String treatment_plan_procedure) {
		this.treatment_plan_procedure = treatment_plan_procedure;
	}

	public String getTreatment_plan_referral() {
		return treatment_plan_referral;
	}

	public void setTreatment_plan_referral(String treatment_plan_referral) {
		this.treatment_plan_referral = treatment_plan_referral;
	}

	public String getOther_treatment_plan_type() {
		return other_treatment_plan_type;
	}

	public void setOther_treatment_plan_type(String other_treatment_plan_type) {
		this.other_treatment_plan_type = other_treatment_plan_type;
	}

	public String getOther_treatment_plan_details() {
		return other_treatment_plan_details;
	}

	public void setOther_treatment_plan_details(String other_treatment_plan_details) {
		this.other_treatment_plan_details = other_treatment_plan_details;
	}

	public String getCurrent_clinical_status() {
		return current_clinical_status;
	}

	public void setCurrent_clinical_status(String current_clinical_status) {
		this.current_clinical_status = current_clinical_status;
	}
	
	
	
	
	

}//class
