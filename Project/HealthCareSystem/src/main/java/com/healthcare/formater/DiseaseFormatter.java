package com.healthcare.formater;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.healthcare.model.DiseaseEntity;

@Component
public class DiseaseFormatter implements Formatter<DiseaseEntity> {

	@Override
	public String print(DiseaseEntity disease, Locale arg1) {
		return new String(disease.getDiseaseCode()+"");
	}

	@Override
	public DiseaseEntity parse(String id, Locale arg1) throws ParseException {
		DiseaseEntity diseaseEntity = new DiseaseEntity();
		diseaseEntity.setDiseaseCode((Long.parseLong(id)));
        return diseaseEntity;
	}

}
