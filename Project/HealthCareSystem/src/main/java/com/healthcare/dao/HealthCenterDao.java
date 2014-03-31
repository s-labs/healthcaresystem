package com.healthcare.dao;

import java.util.List;
import java.util.Set;

import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.UserEntity;

public interface HealthCenterDao {

	public HealthCenterEntity addHealthCenter(HealthCenterEntity healthcenter,long nexHealthCenterid);

	public List<HealthCenterEntity> getAllHealthCenters();
	
	public HealthCenterEntity getHealthCenter(Long id);

	public HealthCenterEntity updateHealthCenter(  HealthCenterEntity healthcenter,long nextHealthCenterId);

	public Set<UserEntity> getAllUsersOfHealthCenter(long healthcenterid);

	public Set<PatientEntity> getAllPatientsOfHealthCenter(long healthcenterid);

	public List<HealthCenterEntity> getAllHealthCentersOfLevel(int level);
	
}
