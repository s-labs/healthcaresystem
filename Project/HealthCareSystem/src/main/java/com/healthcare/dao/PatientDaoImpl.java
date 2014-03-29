package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
import com.healthcare.model.StateEntity;
import com.healthcare.model.SurgicalHistoryEntity;

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
	public void addMedicalHistory(MedicationDetailsEntity medicationDetails) {
		this.sessionFactory.getCurrentSession().save(medicationDetails);		
	}

	@Override
	public void addPregnancyHistory(PregnancyHistoryEntity pregnancyHistory) {
		this.sessionFactory.getCurrentSession().save(pregnancyHistory);		
	}

	@Override
	public void addPregnancyHistory(
			MedicationTreatmentEntity medicationTreatment) {
		this.sessionFactory.getCurrentSession().save(medicationTreatment);		
		
	}

	@Override
	public void addSurgicalHistory(SurgicalHistoryEntity surgicalHistory) {
		this.sessionFactory.getCurrentSession().save(surgicalHistory);		
		
	}

	@Override
	public void addPregnancyOutcome(PregnancyOutcomeEntity pregnancyOutcome) {
		this.sessionFactory.getCurrentSession().save(pregnancyOutcome);		
		
	}

	@Override
	public void addInfantDetails(PregnancyOutcomeEntity pregnancyOutcome) {
		this.sessionFactory.getCurrentSession().save(pregnancyOutcome);	
		
	}

	@Override
	public void addChildImmunisation(ChildImmunisationEntity childImmunisation) {
		this.sessionFactory.getCurrentSession().save(childImmunisation);	
		
	}

	@Override
	public void addInfantDetails(InfantDetailsEntity infantDetails) {
		this.sessionFactory.getCurrentSession().save(infantDetails);	
		
	}

	@Override
	public void addallergyHistory(AllergyHistoryEntity allergyHistory) {
		this.sessionFactory.getCurrentSession().save(allergyHistory);	
		
	}

	@Override
	public void addPncDetails(PncDetailsEntity pncDetails) {
		this.sessionFactory.getCurrentSession().save(pncDetails);	
		
	}

}
