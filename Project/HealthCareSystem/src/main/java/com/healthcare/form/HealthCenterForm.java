package com.healthcare.form;

import com.healthcare.model.HealthCenterEntity;

public class HealthCenterForm {

	private HealthCenterEntity healthcenter;
	private long next;
	
	
	public HealthCenterEntity getHealthcenter() {
		return healthcenter;
	}
	public void setHealthcenter(HealthCenterEntity healthcenter) {
		this.healthcenter = healthcenter;
	}
	public long getNext() {
		return next;
	}
	public void setNext(long next) {
		this.next = next;
	}
	
	
}
