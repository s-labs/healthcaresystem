package com.healthcare.services;



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

}
