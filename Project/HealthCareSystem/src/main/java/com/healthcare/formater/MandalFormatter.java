package com.healthcare.formater;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.healthcare.model.MandalEntity;

@Component
public class MandalFormatter implements Formatter<MandalEntity> {

	@Override
	public String print(MandalEntity mandalEntity, Locale arg1) {
		return new String(mandalEntity.getCode()+"");
	}

	@Override
	public MandalEntity parse(String id, Locale arg1) throws ParseException {
		MandalEntity mandalEntity = new MandalEntity();
		mandalEntity.setCode((Long.parseLong(id)));
        return mandalEntity;
	}

}
