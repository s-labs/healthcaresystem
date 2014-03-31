package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.AllergyHistoryEntity;
import com.healthcare.model.ChildImmunisationEntity;
import com.healthcare.model.DiseaseEntity;
import com.healthcare.model.DrugPrescriptionEntity;
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

public interface PatientDao  {
	
	 	public void addPatient(PatientEntity Patient);
	    public List<PatientEntity> getAllPatients();
	    public void deletePatient(Integer patientId);
	    public PatientEntity getPatient(Long code);
		public void addMedicalHistory(MedicalHistoryEntity medicalHistory);
		public void addMedicalHistory(MedicationDetailsEntity medicationDetails);
		public void addPregnancyHistory(PregnancyHistoryEntity pregnancyHistory);
		public void addPregnancyHistory(
				MedicationTreatmentEntity medicationTreatment);
		public void addSurgicalHistory(SurgicalHistoryEntity surgicalHistory);
		public void addInfantDetails(PregnancyOutcomeEntity pregnancyOutcome);
		public void addPregnancyOutcome(PregnancyOutcomeEntity pregnancyOutcome);
		public void addChildImmunisation(
				ChildImmunisationEntity childImmunisation);
		public void addInfantDetails(InfantDetailsEntity infantDetails);
		public void addallergyHistory(AllergyHistoryEntity allergyHistory);
		public void addPncDetails(PncDetailsEntity pncDetails);
		public void addDrugPrescription(DrugPrescriptionEntity drugPrescription);
		public List<DiseaseEntity> getAllDiseases();
		public void addDisease(DiseaseEntity disease);
		public void addHospitalisationHistory(
				HospitalisationHistoryEntity hospitalizationHistory);
		public void update(PatientEntity patient);

}
