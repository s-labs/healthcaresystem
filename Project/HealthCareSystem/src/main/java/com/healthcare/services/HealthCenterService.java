package com.healthcare.services;

import java.util.List;

import com.healthcare.form.UserForm;
import com.healthcare.model.AllergyHistoryEntity;
import com.healthcare.model.ChildImmunisationEntity;
import com.healthcare.model.InfantDetailsEntity;
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.MedicationTreatmentEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.PncDetailsEntity;
import com.healthcare.model.PregnancyHistoryEntity;
import com.healthcare.model.PregnancyOutcomeEntity;
import com.healthcare.model.SurgicalHistoryEntity;

public interface HealthCenterService {
	
	public void addPatient(PatientEntity Patient);
	public void addUser(UserForm userform);
	public List<PatientEntity> getAllPatients();
	public PatientEntity getPatient(Long PatientCode);
	public void addMedicalHistory(MedicalHistoryEntity medicalHistory);
	public void addMedicationDetails(MedicationDetailsEntity medicationDetails);
	public void addMedicationTreatment(MedicationTreatmentEntity medicationTreatment);
	public void addPregnancyHistory(PregnancyHistoryEntity pregnancyHistory);
	public void addSurgicalHistory(SurgicalHistoryEntity surgicalHistory);
	public void addPregnancyOutcome(PregnancyOutcomeEntity pregnancyOutcome);
	public void addChildImmunisation(ChildImmunisationEntity childImmunisation);
	public void addInfantDetails(InfantDetailsEntity infantDetails);
	public void addallergyHistory(AllergyHistoryEntity allergyHistory);
	public void addPncDetails(PncDetailsEntity pncDetails);

}
