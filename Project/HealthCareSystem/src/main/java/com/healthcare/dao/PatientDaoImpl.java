package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.StateEntity;

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
		return this.sessionFactory.getCurrentSession().createQuery("from PatientEntity").list();
	}

	@Override
	public void deletePatient(Integer patientId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public PatientEntity getPatient(Long uhid) {
		String hql = "FROM PatientEntity P WHERE P.uhid = "+uhid;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		List results = query.list();
		PatientEntity patientEntity = null;
		if(results!= null && results.size() > 0) {
			patientEntity = (PatientEntity) results.get(0);
		}
		return patientEntity;
	}

	@Override
	public void addMedicalHistory(MedicalHistoryEntity medicalHistory) {
		this.sessionFactory.getCurrentSession().save(medicalHistory);
		
	}

	@Override
	public Object findById(Long valueOf) {
		return getPatient(valueOf);
	}

}
