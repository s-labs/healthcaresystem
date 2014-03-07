package com.healthcare.services;

import java.util.List;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

public interface AdminService {
	
	public void addState(StateEntity state);
	public List<StateEntity> getAllStates();
	public StateEntity getState(Long stateCode);
	
	
	public void addDistrict(DistrictEntity district);
	public List<DistrictEntity> getAllDistricts();
	public DistrictEntity getDistrict(Long districtCode);

}
