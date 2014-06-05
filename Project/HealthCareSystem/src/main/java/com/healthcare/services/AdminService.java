package com.healthcare.services;

import java.util.List;
import java.util.Set;

import com.healthcare.form.HealthCenterForm;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;
import com.healthcare.model.UserEntity;
import com.healthcare.model.VillageEntity;

public interface AdminService {
	
	public void addState(StateEntity state);
	public List<StateEntity> getAllStates();
	public StateEntity getState(Long stateCode);
	
	
	public void addDistrict(DistrictEntity district, long statecode);
	public List<DistrictEntity> getAllDistricts();
	public DistrictEntity getDistrict(Long districtCode);
	
	public void addMandal(MandalEntity mandal);
	public List<MandalEntity> getAllMandals();
	public MandalEntity getMandal(Long mandalCode);
	public List<HealthCenterEntity> getAllHealthCenters();
	public HealthCenterEntity addHealthCenter(HealthCenterForm healthcenterform);
	public void addHCAdmin(UserEntity user);
	public HealthCenterEntity getHealthCenter(Long healthcentercode);
	public void updateHealthCenter(HealthCenterForm healthcenterform);
	public void addDHSAdmin(UserEntity user);
	public void associateHealthCenterto(long healthcenterid,
			long associateto, String level);
	public void addVillage(VillageEntity village);
	public List<VillageEntity> getAllVillages();
	public VillageEntity getVillage(Long villageCode);
	public Set<MandalEntity> getMandalsOfdistirict(Long districtCode);
	public MandalEntity getVillagesOfaMandal(Long mandalCode);
	public List<HealthCenterEntity> getHealthCentersOfLevel(int i);
	public StateEntity getDistrictsOfaState(Long stateCode);
	public DistrictEntity getMandalsOfaDistrict(Long districtcode);

}
