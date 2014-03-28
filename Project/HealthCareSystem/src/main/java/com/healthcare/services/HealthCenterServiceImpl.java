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
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.PregnancyHistoryEntity;
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

}
