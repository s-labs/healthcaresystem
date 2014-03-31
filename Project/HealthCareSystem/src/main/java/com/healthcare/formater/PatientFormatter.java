package com.healthcare.formater;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.healthcare.model.PatientEntity;

@Component
public class PatientFormatter implements Formatter<PatientEntity> {

	@Override
	public String print(PatientEntity patient, Locale arg1) {
		return new String(patient.getUhid()+"");
	}

	@Override
	public PatientEntity parse(String id, Locale arg1) throws ParseException {
		PatientEntity patientEntity = new PatientEntity();
		patientEntity.setUhid((Long.parseLong(id)));
        return patientEntity;
	}

}
