package com.healthcare.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dao.HealthCenterDao;
import com.healthcare.dao.PatientDao;
import com.healthcare.dao.UserDao;
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
import com.healthcare.model.UserRolesEntity;

@Service
public class HealthCenterServiceImpl implements HealthCenterService{

	@Autowired
	PatientDao patientDao;
	
	@Autowired
	private HealthCenterDao healthCenterDao;
	

	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public void addPatient(PatientEntity Patient) {
		System.out.println(Patient.getGender());
		patientDao.addPatient(Patient);
		
	}

	@Transactional
	public List<PatientEntity> getAllPatients() {
		return patientDao.getAllPatients();
	}

	@Transactional
	public PatientEntity getPatient(Long PatientCode) {
		return patientDao.getPatient(PatientCode);
	}

	@Transactional
	public void addUser(UserForm userform) {
		UserEntity user = new UserEntity();
		user.setUsername(userform.getUsername());
		user.setPassword(userform.getPassword());
		HealthCenterEntity healthcenter = healthCenterDao.getHealthCenter(userform.getHealthcenterId());
		System.out.println("healthcenter" +healthcenter);
		System.out.println(" ROLE "+userform.getRole());
		user.setHealthcenter(healthcenter);
		
		
		UserRolesEntity role = new UserRolesEntity("ROLE_USER");
		role.setUser(user);
		UserRolesEntity role1 = new UserRolesEntity("ROLE_HEALTHCENTER");
		role1.setUser(user);
		UserRolesEntity role2 = new UserRolesEntity(userform.getRole());
		role2.setUser(user);
		Set<UserRolesEntity> roles = new HashSet<UserRolesEntity>();
		roles.add(role);
		roles.add(role1);
		roles.add(role2);
		user.setRoles(roles);
		user.setHealthcenter(healthcenter);
		user.setEnabled(true);
		userDao.addUser(user );
		
	}

	@Transactional
	public void addMedicalHistory(MedicalHistoryEntity medicalHistory) {
		patientDao.addMedicalHistory(medicalHistory);
		
	}

	@Transactional
	public void addMedicationDetails(MedicationDetailsEntity medicationDetails) {
		patientDao.addMedicalHistory(medicationDetails);
	}

	@Transactional
	public void addPregnancyHistory(PregnancyHistoryEntity pregnancyHistory) {
		patientDao.addPregnancyHistory(pregnancyHistory);
		
	}

	@Transactional
	public void addMedicationTreatment(
			MedicationTreatmentEntity medicationTreatment) {
		patientDao.addPregnancyHistory(medicationTreatment);
		
	}

	@Transactional
	public void addSurgicalHistory(SurgicalHistoryEntity surgicalHistory) {
		patientDao.addSurgicalHistory(surgicalHistory);
		
	}

	@Transactional
	public void addPregnancyOutcome(PregnancyOutcomeEntity pregnancyOutcome) {
		patientDao.addPregnancyOutcome(pregnancyOutcome);
		
	}

	@Transactional
	public void addChildImmunisation(ChildImmunisationEntity childImmunisation) {
		patientDao.addChildImmunisation(childImmunisation);		
	}

	@Transactional
	public void addInfantDetails(InfantDetailsEntity infantDetails) {
		patientDao.addInfantDetails(infantDetails);		
	}

	@Transactional
	public void addallergyHistory(AllergyHistoryEntity allergyHistory) {
		patientDao.addallergyHistory(allergyHistory);		
	}

	@Transactional
	public void addPncDetails(PncDetailsEntity pncDetails) {
		patientDao.addPncDetails(pncDetails);		
	}

	@Transactional
	public void addDrugPrescription(DrugPrescriptionEntity drugPrescription) {
		patientDao.addDrugPrescription(drugPrescription);		
	}

	@Transactional
	public List<DiseaseEntity> getAllDiseases() {
		return patientDao.getAllDiseases();
	}

	@Transactional
	public void addDisease(DiseaseEntity disease) {
		patientDao.addDisease(disease);
	}

	@Transactional
	public Set<UserEntity> getAllUsersOfHealthCenter(long healthcenterid) {
		return healthCenterDao.getAllUsersOfHealthCenter(healthcenterid);
	}

	@Transactional
	public Set<PatientEntity> getAllPatientsOfHealthCenter(long healthcenterid) {
		return healthCenterDao.getAllPatientsOfHealthCenter(healthcenterid);
	}

	@Transactional
	public void addHospitalisationHistory(
			HospitalisationHistoryEntity hospitalizationHistory) {
		patientDao.addHospitalisationHistory(hospitalizationHistory);
		
	}
	
	@Transactional
	public List<HealthCenterEntity> getAllHealthCentersOfLevel(int level) {
		return healthCenterDao.getAllHealthCentersOfLevel(level);
	}

	@Transactional
	public HealthCenterEntity getHealthCenter(long healthCenterCode) {
		return healthCenterDao.getHealthCenter(healthCenterCode);
		
	}

	@Transactional
	public void updatePatient(PatientEntity patient, String tng) {
		
		HealthCenterEntity current = patient.getHealthCenter();
		HealthCenterEntity next = current.getNext();
		if(tng.equalsIgnoreCase("move") && next!=null) {
			patient.setHealthCenter(next);
		}
		patientDao.update(patient);
		
	}

	@Transactional
	public int deletePatient(Long patientCode) {
		
		return patientDao.deletePatient(patientCode);
	}

}
