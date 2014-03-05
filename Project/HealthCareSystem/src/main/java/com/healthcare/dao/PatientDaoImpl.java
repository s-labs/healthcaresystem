package com.healthcare.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.PatientEntity;

@Repository
public class PatientDaoImpl implements PatientDao{

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addPatient(PatientEntity patient) {
		this.sessionFactory.getCurrentSession().save(patient);
		
	}

	@Override
	public List<PatientEntity> getAllPatients() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deletePatient(Integer patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientEntity getPatient(Long code) {
		// TODO Auto-generated method stub
		return null;
	}

}
