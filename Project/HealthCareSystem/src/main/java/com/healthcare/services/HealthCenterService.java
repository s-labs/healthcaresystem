package com.healthcare.services;

import java.util.List;

import com.healthcare.form.UserForm;
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.PatientEntity;

public interface HealthCenterService {
	
	public void addPatient(PatientEntity Patient);
	public void addUser(UserForm userform);
	public List<PatientEntity> getAllPatients();
	public PatientEntity getPatient(Long PatientCode);
	public void addMedicalHistory(MedicalHistoryEntity medicalHistory);
	public void addMedicationDetails(MedicationDetailsEntity medicationDetails);

}
