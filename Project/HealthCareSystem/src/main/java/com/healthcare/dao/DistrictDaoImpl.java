package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.StateEntity;

@Repository
public class DistrictDaoImpl implements DistrictDao {

	@Autowired
	private SessionFactory sessionFactory;

	public void addDistrict(DistrictEntity district) {
		this.sessionFactory.getCurrentSession().save(district);

	}

	public List<DistrictEntity> getAllDistricts() {
		return this.sessionFactory.getCurrentSession()
				.createQuery("from DistrictEntity").list();
	}

	public int deleteDistrict(Long districtId) {
		String hql = "delete from DistrictEntity where ID = :ID";
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		query.setParameter("ID", districtId);
		int result = query.executeUpdate();
		return result;

	}

	@Override
	public DistrictEntity getDistrict(Long code) {

		String hql = "FROM DistrictEntity H WHERE H.id = " + code;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List results = query.list();
		DistrictEntity districtEntity = null;
		if (results != null && results.size() > 0) {
			districtEntity = (DistrictEntity) results.get(0);
		}
	
		return districtEntity;
	}

	@Override
	public void update(DistrictEntity district) {
		this.sessionFactory.getCurrentSession().update(district);

	}

}
