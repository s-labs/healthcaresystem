package com.healthcare.services;

import java.util.List;
import java.util.Set;

import com.healthcare.form.UserForm;
import com.healthcare.model.AllergyHistoryEntity;
import com.healthcare.model.ChildImmunisationEntity;
import com.healthcare.model.DiseaseEntity;
import com.healthcare.model.DrugPrescriptionEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.HospitalisationHistoryEntity;
import com.healthcare.model.InfantDetailsEntity;
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.MedicationTreatmentEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.PncDetailsEntity;
import com.healthcare.model.PregnancyHistoryEntity;
import com.healthcare.model.PregnancyOutcomeEntity;
import com.healthcare.model.SurgicalHistoryEntity;
import com.healthcare.model.UserEntity;

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
	public void addDrugPrescription(DrugPrescriptionEntity drugPrescription);
	public List<DiseaseEntity> getAllDiseases();
	public void addDisease(DiseaseEntity disease);
	public Set<UserEntity> getAllUsersOfHealthCenter(long healthcenterid);
	public Set<PatientEntity> getAllPatientsOfHealthCenter(long healthcenterid);
	public void addHospitalisationHistory(
			HospitalisationHistoryEntity hospitalizationHistory);
	public List<HealthCenterEntity> getAllHealthCentersOfLevel(int gridlevel);
	public HealthCenterEntity getHealthCenter(long healthCenterCode);
	public void updatePatient(PatientEntity patient, String tng);
	

}
