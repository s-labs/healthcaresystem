package com.healthcare.formater;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.healthcare.model.HealthCenterEntity;

@Component
public class HealthCenterFormater implements Formatter<HealthCenterEntity> {

	@Override
	public String print(HealthCenterEntity healthcenter, Locale arg1) {
		return new String(healthcenter.getId()+"");
	}

	@Override
	public HealthCenterEntity parse(String id, Locale arg1) throws ParseException {
		HealthCenterEntity healthcenter = new HealthCenterEntity();
		healthcenter.setId((Long.parseLong(id)));
        return healthcenter;
	}

}
