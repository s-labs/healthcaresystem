package com.healthcare.services;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dao.StateDao;
import com.healthcare.model.StateEntity;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private StateDao stateDao;
    
    @Transactional
	public void addState(StateEntity state) {
    	stateDao.addState(state);

	}

	@Override
	@Transactional
	public List<StateEntity> getAllStates() {
		List<StateEntity> states = stateDao.getAllStates();
		return states;
	}

	@Override
	@Transactional
	public StateEntity getState(Long stateCode) {
		// TODO Auto-generated method stub
		return stateDao.getState(stateCode);
	}

}
