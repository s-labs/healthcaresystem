package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.util.GenericDao;

public interface PatientDao extends GenericDao<PatientEntity, Long> {
	
	 	public void addPatient(PatientEntity Patient);
	    public List<PatientEntity> getAllPatients();
	    public void deletePatient(Integer patientId);
	    public PatientEntity getPatient(Long code);
		public void addMedicalHistory(MedicalHistoryEntity medicalHistory);
		public void addMedicalHistory(MedicationDetailsEntity medicationDetails);

}
