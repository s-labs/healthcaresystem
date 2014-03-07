package com.healthcare.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

@Repository
public class DistrictDaoImpl implements DistrictDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addDistrict(DistrictEntity district) {
		 this.sessionFactory.getCurrentSession().save(district);
		
	}

	public List<DistrictEntity> getAllDistricts() {
		return this.sessionFactory.getCurrentSession().createQuery("from DistrictEntity").list();
	}

	public void deleteDistrict(Integer districtId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DistrictEntity getDistrict(Long code) {
		// TODO Auto-generated method stub
		DistrictEntity districtEntity = new DistrictEntity();
		return districtEntity;
	}
	

}
