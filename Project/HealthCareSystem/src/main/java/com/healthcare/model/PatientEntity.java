package com.healthcare.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PATIENT")
public class PatientEntity {
	
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long uhid;
	
	@Column
	private String lastName;
	private String middleName;
	private String firstName;
	private Date dob;
	private Integer age;
	private Character gender;
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
	public PatientEntity(String lastName, String middleName, String firstName,
			Date dob, Integer age, Character gender, String occupation,
			String fatherHusbandName, String motherName, String addressLine1,
			String addressLine2, String pinCode, String cityTownVillage,
			String mandal, String district, String sate, String email,
			Integer phone, String emerContactPerName,
			String emerContactPerRelationship,
			String emerContactPerAddressLine1,
			String emerContactPerAddressLine2, String emerContactPerPinCode,
			String emerContactPerCit, String emerContactPerMandal,
			String emerContactPerDistrict, String emerContactPerState,
			Integer emerContactPerPhone, Integer emerContactPerPhoneNumber,
			String emerContactPerEmail) {
		this.lastName = lastName;
		this.middleName = middleName;
		this.firstName = firstName;
		this.dob = dob;
		this.age = age;
		this.gender = gender;
		this.occupation = occupation;
		this.fatherHusbandName = fatherHusbandName;
		this.motherName = motherName;
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pinCode = pinCode;
		this.cityTownVillage = cityTownVillage;
		this.mandal = mandal;
		this.district = district;
		this.sate = sate;
		this.email = email;
		this.phone = phone;
		this.emerContactPerName = emerContactPerName;
		this.emerContactPerRelationship = emerContactPerRelationship;
		this.emerContactPerAddressLine1 = emerContactPerAddressLine1;
		this.emerContactPerAddressLine2 = emerContactPerAddressLine2;
		this.emerContactPerPinCode = emerContactPerPinCode;
		this.emerContactPerCit = emerContactPerCit;
		this.emerContactPerMandal = emerContactPerMandal;
		this.emerContactPerDistrict = emerContactPerDistrict;
		this.emerContactPerState = emerContactPerState;
		this.emerContactPerPhone = emerContactPerPhone;
		this.emerContactPerPhoneNumber = emerContactPerPhoneNumber;
		this.emerContactPerEmail = emerContactPerEmail;
	}

	public Long getUhid() {
		return this.uhid;
	}

	public void setUhid(Long uhid) {
		this.uhid = uhid;
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

	public Character getGender() {
		return this.gender;
	}

	public void setGender(Character gender) {
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


}
