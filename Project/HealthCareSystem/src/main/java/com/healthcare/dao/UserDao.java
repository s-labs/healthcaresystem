package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.UserEntity;

public interface UserDao {
	
	public void addUser(UserEntity user);
	public UserEntity getUser(long userId);
	public UserEntity getUserByUsername(String userName);
	public List<UserEntity> getAllUsers();

}
