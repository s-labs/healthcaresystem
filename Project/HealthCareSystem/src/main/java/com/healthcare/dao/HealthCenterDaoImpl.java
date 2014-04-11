package com.healthcare.dao;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.UserEntity;

@Repository
public class HealthCenterDaoImpl implements HealthCenterDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public HealthCenterEntity addHealthCenter(HealthCenterEntity healthcenter,
			long nextHealthCenterId) {

		if (healthcenter.getLevel() != 1) {
			System.out.println("nextHealthCenterId : " + nextHealthCenterId);
			HealthCenterEntity nextHealthCenter = getHealthCenter(nextHealthCenterId);
			System.out.println(nextHealthCenter);
			healthcenter.setNext(nextHealthCenter);
		}

		this.sessionFactory.getCurrentSession().save(healthcenter);
		this.sessionFactory.getCurrentSession().flush();
		return healthcenter;

	}

	public HealthCenterEntity getHealthCenter(Long id) {
		String hql = "FROM HealthCenterEntity H WHERE H.id = " + id;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List results = query.list();
		HealthCenterEntity healthCenterEntity = null;
		if (results != null && results.size() > 0) {
			healthCenterEntity = (HealthCenterEntity) results.get(0);
		}
		System.out.println(" gethealthCenterEntity healthcenter id : "+healthCenterEntity.getId());
		return healthCenterEntity;
	}

	@Override
	public List<HealthCenterEntity> getAllHealthCenters() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from HealthCenterEntity").list();
	}

	@Override
	public HealthCenterEntity updateHealthCenter(
			HealthCenterEntity healthcenter, long nextHealthCenterId) {

		if (healthcenter.getLevel() != 1) {
			System.out.println("nextHealthCenterId : " + nextHealthCenterId);
			HealthCenterEntity nextHealthCenter = getHealthCenter(nextHealthCenterId);
			System.out.println(nextHealthCenter);
			healthcenter.setNext(nextHealthCenter);
		}

		this.sessionFactory.getCurrentSession().update(healthcenter);
		return healthcenter;

	}

	@Override
	public Set<UserEntity> getAllUsersOfHealthCenter(long healthcenterid) {
		return getHealthCenter(healthcenterid).getUsers();		
	}

	@Override
	public Set<PatientEntity> getAllPatientsOfHealthCenter(long healthcenterid) {
		return getHealthCenter(healthcenterid).getPatients();
	}

	@Override
	public List getAllHealthCentersOfLevel(int level) {
		String hql = "FROM HealthCenterEntity H WHERE H.level = " + level;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List results = query.list();
		
		return results;
	}

}
