package com.healthcare.services;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dao.DistrictDao;
import com.healthcare.dao.HealthCenterDao;
import com.healthcare.dao.MandalDao;
import com.healthcare.dao.StateDao;
import com.healthcare.dao.UserDao;
import com.healthcare.dao.VillageDao;
import com.healthcare.form.HealthCenterForm;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;
import com.healthcare.model.UserEntity;
import com.healthcare.model.UserRolesEntity;
import com.healthcare.model.VillageEntity;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private StateDao stateDao;
	
	@Autowired
	private HealthCenterDao healthCenterDao;
	
	@Autowired
	private UserDao userDao;
	
	@Autowired
    private SessionFactory sessionFactory;

	@Transactional
	public void addState(StateEntity state) {
		stateDao.addState(state);

	}

	@Transactional
	public List<StateEntity> getAllStates() {
		List<StateEntity> states = stateDao.getAllStates();
		return states;
	}

	@Transactional
	public StateEntity getState(Long stateCode) {
		// TODO Auto-generated method stub
		return stateDao.getState(stateCode);
	}

	@Autowired
	private DistrictDao districtDao;

	@Transactional
	public List<DistrictEntity> getAllDistricts() {
		System.out
				.println("inside getAllDistricts() method of AdminServiceImpl class");
		List<DistrictEntity> districts = districtDao.getAllDistricts();
		return districts;
	}

	@Transactional
	public DistrictEntity getDistrict(Long districtCode) {
		DistrictEntity district,district1 ;
		district = districtDao.getDistrict(districtCode);
		district1 = district;
		district1.setMandals(district.getMandals());
		return district1;
	}


	@Autowired
	private MandalDao mandalDao;
	
	@Autowired
	private VillageDao villageDao;

	@Transactional
	public void addMandal(MandalEntity mandal) {
		mandalDao.addMandal(mandal);
	}

	@Transactional
	public List<MandalEntity> getAllMandals() {
		System.out
				.println("inside getAllMandals() method of AdminServiceImpl class");
		List<MandalEntity> mandals = mandalDao.getAllMandals();
		return mandals;
	}

	@Transactional
	public MandalEntity getMandal(Long mandalCode) {
		return mandalDao.getMandal(mandalCode);
	}

	@Transactional
	public void addDistrict(DistrictEntity district, long statecode)

	{
		stateDao.addDistrict(district, statecode);
	}

	@Transactional
	public List<HealthCenterEntity> getAllHealthCenters() {
		List<HealthCenterEntity> healthcenters = healthCenterDao.getAllHealthCenters();
		return healthcenters;
	}
	
	@Transactional
	public void addHealthCenter(HealthCenterForm healthcenterform) {
		long nextHealthCenterId =  healthcenterform.getNext();
		HealthCenterEntity healthcenter = healthcenterform.getHealthcenter();
		 healthcenter = healthCenterDao.addHealthCenter(healthcenter ,nextHealthCenterId);
		
	}

	@Transactional
	public void addHCAdmin(UserEntity user) {
		
		
		UserRolesEntity role = new UserRolesEntity("ROLE_USER");
		role.setUser(user);
		UserRolesEntity role1 = new UserRolesEntity("ROLE_HEALTHCENTER");
		role1.setUser(user);
		UserRolesEntity role2 = new UserRolesEntity("ROLE_HC_ADMIN");
		role2.setUser(user);
		Set<UserRolesEntity> roles = new HashSet<UserRolesEntity>();
		roles.add(role);
		roles.add(role1);
		roles.add(role2);
		user.setRoles(roles);
		
		user.setEnabled(true);
		userDao.addUser(user );
		
	}

	@Transactional
	public HealthCenterEntity getHealthCenter(Long healthcentercode) {
		return healthCenterDao.getHealthCenter(healthcentercode);
	}

	@Transactional
	public void updateHealthCenter(HealthCenterForm healthcenterform) {
		healthCenterDao.updateHealthCenter(healthcenterform.getHealthcenter(),healthcenterform.getNext());
		
	}

	@Transactional
	public void addDHSAdmin(UserEntity user) {
		UserRolesEntity role = new UserRolesEntity("ROLE_USER");
		role.setUser(user);
		UserRolesEntity role1 = new UserRolesEntity("ROLE_DHS");
		role1.setUser(user);
		Set<UserRolesEntity> roles = new HashSet<UserRolesEntity>();
		roles.add(role);
		roles.add(role1);
		user.setRoles(roles);
		
		user.setEnabled(true);
		userDao.addUser(user );
		
	}

	@Transactional
	public void associateHealthCenterto(long healthcenterid,
			long associateto, String level) {
		if(level.equalsIgnoreCase("district")) {
			DistrictEntity district = districtDao.getDistrict(associateto);
			HealthCenterEntity healthCenter = healthCenterDao.getHealthCenter(healthcenterid);
			district.setHealthCenter(healthCenter);
			districtDao.update(district);
		}
		if(level.equalsIgnoreCase("mandal")) {
			MandalEntity mandal = mandalDao.getMandal(associateto);
			HealthCenterEntity healthCenter = healthCenterDao.getHealthCenter(healthcenterid);
			mandal.setHealthCenter(healthCenter);
			mandalDao.update(mandal);
		}
		
	}

	@Transactional
	public void addVillage(VillageEntity village) {
		villageDao.addVillage(village);
		
	}

	@Transactional
	public List<VillageEntity> getAllVillages() {
		return villageDao.getAllVillages();
	}

	@Transactional
	public VillageEntity getVillage(Long villageCode) {
		return villageDao.getVillage(villageCode);
	}

}
