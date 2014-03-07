package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

public interface DistrictDao {
	public void addDistrict(DistrictEntity district);
    public List<DistrictEntity> getAllDistricts();
    public void deleteDistrict(Integer districtId);
    public DistrictEntity getDistrict(Long code);

}
