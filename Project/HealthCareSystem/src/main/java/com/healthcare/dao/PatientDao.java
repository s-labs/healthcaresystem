package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.PatientEntity;

public interface PatientDao {
	
	 public void addPatient(PatientEntity Patient);
	    public List<PatientEntity> getAllPatients();
	    public void deletePatient(Integer patientId);
	    public PatientEntity getPatient(Long code);

}
