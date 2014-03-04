package com.healthcare.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.healthcare.model.MandalEntity;

@Repository
public class MandalDaoImpl implements MandalDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addMandal(MandalEntity mandal) {
		this.sessionFactory.getCurrentSession().save(mandal);
		
	}

	public List<MandalEntity> getAllMandals() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteMandal(Integer mandalId) {
		// TODO Auto-generated method stub
		
	}
	
	

}
