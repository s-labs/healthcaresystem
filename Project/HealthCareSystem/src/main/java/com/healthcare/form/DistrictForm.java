package com.healthcare.form;

import com.healthcare.model.DistrictEntity;

public class DistrictForm {
	
	private DistrictEntity district;
	private long stateId;
	
	public DistrictEntity getDistrict() {
		return district;
	}
	public void setDistrict(DistrictEntity district) {
		this.district = district;
	}
	public long getStateId() {
		return stateId;
	}
	public void setStateId(long stateId) {
		this.stateId = stateId;
	}

}
