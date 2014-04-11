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

	public void deleteDistrict(Integer districtId) {
		// TODO Auto-generated method stub

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
		System.out.println(" getDistrict districtEntity id : "
				+ districtEntity.getCode());
		return districtEntity;
	}

	@Override
	public void update(DistrictEntity district) {
		this.sessionFactory.getCurrentSession().update(district);

	}

}
