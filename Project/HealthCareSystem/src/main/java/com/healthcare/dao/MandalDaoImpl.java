package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.MandalEntity;
import com.healthcare.model.VillageEntity;

@Repository
public class MandalDaoImpl implements MandalDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addMandal(MandalEntity mandal) {
		this.sessionFactory.getCurrentSession().save(mandal);
		
	}

	public List<MandalEntity> getAllMandals() {
		System.out.println("getAllMandals() method of MandalDaoImpl class");
		return this.sessionFactory.getCurrentSession().createQuery("from MandalEntity").list();
	}

	public void deleteMandal(Integer mandalId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public MandalEntity getMandal(Long mandalCode) {
		String hql = "FROM MandalEntity m WHERE m.code = " + mandalCode;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List results = query.list();
		MandalEntity mandalEntity = null;
		if (results != null && results.size() > 0) {
			mandalEntity = (MandalEntity) results.get(0);
		}
		System.out.println(" getMandal mandal id : "+mandalEntity.getCode());
		return mandalEntity;
	}

	@Override
	public void update(MandalEntity mandal) {
		this.sessionFactory.getCurrentSession().update(mandal);
		
	}
	
	

}
