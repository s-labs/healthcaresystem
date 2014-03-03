package com.healthcare.services;

import java.util.List;

import com.healthcare.model.StateEntity;

public interface AdminService {
	
	public void addState(StateEntity state);
	public List<StateEntity> getAllStates();
	public StateEntity getState(Long stateCode);

}
