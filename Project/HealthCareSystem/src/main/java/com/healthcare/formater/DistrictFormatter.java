package com.healthcare.formater;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.healthcare.model.DistrictEntity;
import com.healthcare.model.PatientEntity;

@Component
public class DistrictFormatter implements Formatter<DistrictEntity> {

	@Override
	public String print(DistrictEntity districtEntity, Locale arg1) {
		return new String(districtEntity.getCode()+"");
	}

	@Override
	public DistrictEntity parse(String id, Locale arg1) throws ParseException {
		DistrictEntity districtEntity = new DistrictEntity();
		districtEntity.setCode((Long.parseLong(id)));
        return districtEntity;
	}

}
