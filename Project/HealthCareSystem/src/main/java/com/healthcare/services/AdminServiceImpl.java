package com.healthcare.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.dao.DistrictDao;
import com.healthcare.dao.MandalDao;
import com.healthcare.dao.StateDao;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private StateDao stateDao;

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

	/* srihari *************** code *************** started */

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
		// TODO Auto-generated method stub
		return districtDao.getDistrict(districtCode);
	}

	/* srihari **********************code ended******************** */

	/* srihari ****code for adding mandals*******date 12/03/2014 *******started */

	@Autowired
	private MandalDao mandalDao;

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

	@Override
	public MandalEntity getMandal(Long mandalCode) {
		// TODO Auto-generated method stub
		return null;
	}

	@Transactional
	public void addDistrict(DistrictEntity district, long statecode)

	{
		stateDao.addDistrict(district, statecode);
	}

	/* srihari **************date 12/03/2014 **************** ended */

}
