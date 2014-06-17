package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.VillageEntity;
import com.healthcare.model.VillageEntity;

@Repository
public class VillageDaoImpl implements VillageDao{
	
	@Autowired
    private SessionFactory sessionFactory;

	public void addVillage(VillageEntity village) {
		this.sessionFactory.getCurrentSession().save(village);
		
	}

	public List<VillageEntity> getAllVillages() {
		System.out.println("getAllVillages() method of VillageDaoImpl class");
		return this.sessionFactory.getCurrentSession().createQuery("from VillageEntity").list();
	}

	public int deleteVillage(Integer villageId) {
		String hql = "delete from PatientEntity where ID = :ID";
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		query.setParameter("ID", villageId);
		int result = query.executeUpdate();
		return result;
		
	}

	@Override
	public VillageEntity getVillage(Long villageCode) {
		String hql = "FROM VillageEntity v WHERE v.code = " + villageCode;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		List results = query.list();
		VillageEntity villageEntity = null;
		if (results != null && results.size() > 0) {
			villageEntity = (VillageEntity) results.get(0);
		}
		System.out.println(" getVillage village id : "+villageEntity.getCode());
		return villageEntity;
	}
	
	

}
