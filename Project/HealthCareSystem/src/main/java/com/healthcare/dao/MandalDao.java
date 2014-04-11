package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.MandalEntity;

public interface MandalDao{
	
	public void addMandal(MandalEntity mandal);
    public List<MandalEntity> getAllMandals();
    public void deleteMandal(Integer mandalId);
	public MandalEntity getMandal(Long mandalCode);
	public void update(MandalEntity mandal);
     
    

}
