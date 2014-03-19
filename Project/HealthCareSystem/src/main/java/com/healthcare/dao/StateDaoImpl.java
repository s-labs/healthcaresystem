package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

@Repository
public class StateDaoImpl implements StateDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	public void addState(StateEntity state) {
		 this.sessionFactory.getCurrentSession().save(state);

	}

	public List<StateEntity> getAllStates() {
		return this.sessionFactory.getCurrentSession().createQuery("from StateEntity").list();
		
	}

	public void deleteState(Integer stateId) {
		// TODO Auto-generated method stub

	}

	public StateEntity getState(Long code) {
		String hql = "FROM StateEntity S WHERE S.code = "+code;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		List results = query.list();
		StateEntity stateEntity = null;
		if(results!= null && results.size() > 0) {
			stateEntity = (StateEntity) results.get(0);
		}
		return stateEntity;
	}

	@Override
	public void addDistrict(DistrictEntity district,long statecode) {
		StateEntity state = getState(statecode);
		state.getDistricts().add(district);
		 this.sessionFactory.getCurrentSession().save(state);
		
	}

}
