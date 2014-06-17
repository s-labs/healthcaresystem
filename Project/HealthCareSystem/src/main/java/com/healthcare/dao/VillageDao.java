package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.VillageEntity;

public interface VillageDao{
	
	public void addVillage(VillageEntity village);
    public List<VillageEntity> getAllVillages();
    public int deleteVillage(Integer villageId);
	public VillageEntity getVillage(Long villageCode);
     
    

}
