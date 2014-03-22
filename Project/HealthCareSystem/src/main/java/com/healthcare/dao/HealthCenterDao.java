package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.HealthCenterEntity;

public interface HealthCenterDao {

	public HealthCenterEntity addHealthCenter(HealthCenterEntity healthcenter,long nexHealthCenterid);

	public List<HealthCenterEntity> getAllHealthCenters();
	
	public HealthCenterEntity getHealthCenter(Long id);
	
}
