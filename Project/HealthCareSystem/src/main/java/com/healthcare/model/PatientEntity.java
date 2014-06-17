package com.healthcare.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.IndexColumn;

import com.healthcare.util.GenericEntity;

@Entity
@Table(name = "PATIENT")
public class PatientEntity implements GenericEntity<Long> {

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "healthcentercode",nullable = false)
	private HealthCenterEntity healthCenter;
	
    @ManyToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL})
    @JoinTable(name="PREVIOUS_HEALTHCENTERS",
                joinColumns={@JoinColumn(name="uhid")},
                inverseJoinColumns={@JoinColumn(name="id")})
    private Set<HealthCenterEntity> previousHealthCenters = new HashSet<HealthCenterEntity>();

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL },orphanRemoval=true)
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "code")
	private Set<MedicalHistoryEntity> medicalhistory = new HashSet<MedicalHistoryEntity>(
			0);
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL },orphanRemoval=true)
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "id")
	private Set<HospitalisationHistoryEntity> hospitalisationHistoryEntity = new HashSet<HospitalisationHistoryEntity>(
			0);

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL},orphanRemoval=true)
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "code")
	private Set<MedicationDetailsEntity> medicationDetails = new HashSet<MedicationDetailsEntity>(
			0);

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "code")
	private Set<PregnancyHistoryEntity> pregnancyHistory = new HashSet<PregnancyHistoryEntity>(
			0);

	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "code")
	private Set<MedicationTreatmentEntity> medicationTreatmentEntity = new HashSet<MedicationTreatmentEntity>(
			0);
	
	@OneToMany(fetch = FetchType.EAGER, cascade = { CascadeType.ALL })
	@JoinColumn(name = "uhid")
	@IndexColumn(name = "code")
	private Set<ChildImmunisationEntity> childImmunisation = new HashSet<ChildImmunisationEntity>(
			0);
	
	

	public Set<PregnancyHistoryEntity> getPregnancyHistory() {
		return pregnancyHistory;
	}

	public void setPregnancyHistory(Set<PregnancyHistoryEntity> pregnancyHistory) {
		this.pregnancyHistory = pregnancyHistory;
	}

	@Column
	private String lastName;
	private String middleName;
	private String firstName;
	private Date dob;
	private Integer age;
	private String gender;
	private String occupation;
	private String fatherHusbandName;
	private String motherName;
	private String addressLine1;
	private String addressLine2;
	private String pinCode;
	private String cityTownVillage;
	private String mandal;
	private String district;
	private String sate;
	private String email;
	private Integer phone;
	private String emerContactPerName;
	private String emerContactPerRelationship;
	private String emerContactPerAddressLine1;
	private String emerContactPerAddressLine2;
	private String emerContactPerPinCode;
	private String emerContactPerCit;
	private String emerContactPerMandal;
	private String emerContactPerDistrict;
	private String emerContactPerState;
	private Integer emerContactPerPhone;
	private Integer emerContactPerPhoneNumber;
	private String emerContactPerEmail;

	public PatientEntity() {

	}

	
	public Set<HealthCenterEntity> getPreviousHealthCenters() {
		return previousHealthCenters;
	}

	public void setPreviousHealthCenters(
			Set<HealthCenterEntity> previousHealthCenters) {
		this.previousHealthCenters = previousHealthCenters;
	}

	public Long getUhid() {
		return this.uhid;
	}

	public void setUhid(Long uhid) {
		this.uhid = uhid;
	}

	public Set<MedicalHistoryEntity> getMedicalhistory() {
		return medicalhistory;
	}

	public void setMedicalhistory(Set<MedicalHistoryEntity> medicalhistory) {
		this.medicalhistory = medicalhistory;
	}

	public Set<MedicationDetailsEntity> getMedicationDetails() {
		return medicationDetails;
	}

	public Set<ChildImmunisationEntity> getChildImmunisation() {
		return childImmunisation;
	}

	public void setChildImmunisation(Set<ChildImmunisationEntity> childImmunisation) {
		this.childImmunisation = childImmunisation;
	}

	public void setMedicationDetails(
			Set<MedicationDetailsEntity> medicationDetails) {
		this.medicationDetails = medicationDetails;
	}

	public Set<MedicationTreatmentEntity> getMedicationTreatmentEntity() {
		return medicationTreatmentEntity;
	}

	public void setMedicationTreatmentEntity(
			Set<MedicationTreatmentEntity> medicationTreatmentEntity) {
		this.medicationTreatmentEntity = medicationTreatmentEntity;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getMiddleName() {
		return this.middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Date getDob() {
		return this.dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Integer getAge() {
		return this.age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return this.gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getFatherHusbandName() {
		return this.fatherHusbandName;
	}

	public void setFatherHusbandName(String fatherHusbandName) {
		this.fatherHusbandName = fatherHusbandName;
	}

	public String getMotherName() {
		return this.motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddressLine1() {
		return this.addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return this.addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPinCode() {
		return this.pinCode;
	}

	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}

	public String getCityTownVillage() {
		return this.cityTownVillage;
	}

	public void setCityTownVillage(String cityTownVillage) {
		this.cityTownVillage = cityTownVillage;
	}

	public String getMandal() {
		return this.mandal;
	}

	public void setMandal(String mandal) {
		this.mandal = mandal;
	}

	public String getDistrict() {
		return this.district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getSate() {
		return this.sate;
	}

	public void setSate(String sate) {
		this.sate = sate;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Integer getPhone() {
		return this.phone;
	}

	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	public String getEmerContactPerName() {
		return this.emerContactPerName;
	}

	public void setEmerContactPerName(String emerContactPerName) {
		this.emerContactPerName = emerContactPerName;
	}

	public String getEmerContactPerRelationship() {
		return this.emerContactPerRelationship;
	}

	public void setEmerContactPerRelationship(String emerContactPerRelationship) {
		this.emerContactPerRelationship = emerContactPerRelationship;
	}

	public String getEmerContactPerAddressLine1() {
		return this.emerContactPerAddressLine1;
	}

	public void setEmerContactPerAddressLine1(String emerContactPerAddressLine1) {
		this.emerContactPerAddressLine1 = emerContactPerAddressLine1;
	}

	public String getEmerContactPerAddressLine2() {
		return this.emerContactPerAddressLine2;
	}

	public void setEmerContactPerAddressLine2(String emerContactPerAddressLine2) {
		this.emerContactPerAddressLine2 = emerContactPerAddressLine2;
	}

	public String getEmerContactPerPinCode() {
		return this.emerContactPerPinCode;
	}

	public void setEmerContactPerPinCode(String emerContactPerPinCode) {
		this.emerContactPerPinCode = emerContactPerPinCode;
	}

	public String getEmerContactPerCit() {
		return this.emerContactPerCit;
	}

	public void setEmerContactPerCit(String emerContactPerCit) {
		this.emerContactPerCit = emerContactPerCit;
	}

	public String getEmerContactPerMandal() {
		return this.emerContactPerMandal;
	}

	public void setEmerContactPerMandal(String emerContactPerMandal) {
		this.emerContactPerMandal = emerContactPerMandal;
	}

	public String getEmerContactPerDistrict() {
		return this.emerContactPerDistrict;
	}

	public void setEmerContactPerDistrict(String emerContactPerDistrict) {
		this.emerContactPerDistrict = emerContactPerDistrict;
	}

	public String getEmerContactPerState() {
		return this.emerContactPerState;
	}

	public void setEmerContactPerState(String emerContactPerState) {
		this.emerContactPerState = emerContactPerState;
	}

	public Integer getEmerContactPerPhone() {
		return this.emerContactPerPhone;
	}

	public void setEmerContactPerPhone(Integer emerContactPerPhone) {
		this.emerContactPerPhone = emerContactPerPhone;
	}

	public Integer getEmerContactPerPhoneNumber() {
		return this.emerContactPerPhoneNumber;
	}

	public void setEmerContactPerPhoneNumber(Integer emerContactPerPhoneNumber) {
		this.emerContactPerPhoneNumber = emerContactPerPhoneNumber;
	}

	public String getEmerContactPerEmail() {
		return this.emerContactPerEmail;
	}

	public void setEmerContactPerEmail(String emerContactPerEmail) {
		this.emerContactPerEmail = emerContactPerEmail;
	}

	@Override
	public long getId() {
		return this.uhid;
	}

	public HealthCenterEntity getHealthCenter() {
		return healthCenter;
	}

	public void setHealthCenter(HealthCenterEntity healthCenter) {
		this.healthCenter = healthCenter;
	}
	
	public String getFullName() {
		
		return this.firstName+" "+this.lastName;
	}

	
}
