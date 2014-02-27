package com.healthcare.dao;

import java.util.List;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.StateEntity;

@Repository
public class StateDaoImpl implements StateDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void addState(StateEntity state) {
		 this.sessionFactory.getCurrentSession().save(state);

	}

	public List<StateEntity> getAllStates() {
		// TODO Auto-generated method stub
		return null;
	}

	public void deleteState(Integer stateId) {
		// TODO Auto-generated method stub

	}

}
