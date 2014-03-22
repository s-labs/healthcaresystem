package com.healthcare.services;

import java.util.List;

import com.healthcare.form.HealthCenterForm;
import com.healthcare.form.UserForm;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;

public interface AdminService {
	
	public void addState(StateEntity state);
	public List<StateEntity> getAllStates();
	public StateEntity getState(Long stateCode);
	
	
	public void addDistrict(DistrictEntity district, long statecode);
	public List<DistrictEntity> getAllDistricts();
	public DistrictEntity getDistrict(Long districtCode);
	
	public void addMandal(MandalEntity mandal);
	public List<MandalEntity> getAllMandals();
	public MandalEntity getMandal(Long mandalCode);
	public List<HealthCenterEntity> getAllHealthCenters();
	public void addHealthCenter(HealthCenterForm healthcenterform);
	public void addHCAdmin(UserForm userform);

}
