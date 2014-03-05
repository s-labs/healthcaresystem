package com.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dao.PatientDao;
import com.healthcare.model.PatientEntity;

@Service
public class HealthCenterServiceImpl implements HealthCenterService{

	@Autowired
	PatientDao patientDao;
	
	@Override
	@Transactional
	public void addPatient(PatientEntity Patient) {
		patientDao.addPatient(Patient);
		
	}

	@Override
	public List<PatientEntity> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PatientEntity getPatient(Long PatientCode) {
		// TODO Auto-generated method stub
		return null;
	}

}
