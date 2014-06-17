package com.healthcare.dao;

import java.util.List;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.StateEntity;

public interface DistrictDao {
	public void addDistrict(DistrictEntity district);
    public List<DistrictEntity> getAllDistricts();
    public int deleteDistrict(Long districtCode);
    public DistrictEntity getDistrict(Long code);
	public void update(DistrictEntity district);

}
