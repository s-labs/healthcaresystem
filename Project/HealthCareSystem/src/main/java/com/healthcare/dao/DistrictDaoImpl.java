package com.healthcare.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.healthcare.model.DistrictEntity;

@Repository
public class DistrictDaoImpl implements DistrictDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addDistrict(DistrictEntity district) {
		 this.sessionFactory.getCurrentSession().save(district);
		
	}

	public List<DistrictEntity> getAllDistricts() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteDistrict(Integer districtId) {
		// TODO Auto-generated method stub
		
	}
	

}
