package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.HealthCenterEntity;

@Repository
public class HealthCenterDaoImpl implements HealthCenterDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	
	public HealthCenterEntity addHealthCenter(HealthCenterEntity healthcenter,long nextHealthCenterId) {
		
		if(healthcenter.getLevel()!= 4  )
		{
			System.out.println("nextHealthCenterId : "+nextHealthCenterId);
		HealthCenterEntity nextHealthCenter = getHealthCenter(nextHealthCenterId);
		System.out.println(nextHealthCenter);
		healthcenter.setNext(nextHealthCenter);
		}
		
		 this.sessionFactory.getCurrentSession().save(healthcenter);
		 this.sessionFactory.getCurrentSession().flush();
		 return healthcenter;

	}
	
	public HealthCenterEntity getHealthCenter(Long id) {
		String hql = "FROM HealthCenterEntity H WHERE H.id = "+id;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		List results = query.list();
		HealthCenterEntity healthCenterEntity = null;
		if(results!= null && results.size() > 0) {
			healthCenterEntity = (HealthCenterEntity) results.get(0);
		}
		return healthCenterEntity;
	}

	

	@Override
	public List<HealthCenterEntity> getAllHealthCenters() {
		return this.sessionFactory.getCurrentSession().createQuery("from HealthCenterEntity").list();
	}

}
