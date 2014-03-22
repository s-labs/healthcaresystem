package com.healthcare.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.healthcare.model.UserEntity;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public void addUser(UserEntity user) {
		this.sessionFactory.getCurrentSession().save(user);
		
	}

	@Override
	public UserEntity getUser(long userId) {
		String hql = "FROM UserEntity U WHERE S.USER_ID = "+userId;
		Session session = this.sessionFactory.getCurrentSession();
		Query query = session .createQuery(hql);
		List results = query.list();
		UserEntity userEntity = null;
		if(results!= null && results.size() > 0) {
			userEntity = (UserEntity) results.get(0);
		}
		return userEntity;
	}

	@Override
	public List<UserEntity> getAllUsers() {
		return this.sessionFactory.getCurrentSession().createQuery("from UserEntity").list();
		
	}

}
