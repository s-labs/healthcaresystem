package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

public interface StateDao {
	
    public void addState(StateEntity state);
  
    public List<StateEntity> getAllStates();
    public void deleteState(Integer stateId);
    public StateEntity getState(Long code);
	public void addDistrict(DistrictEntity district, long statecode);

}
