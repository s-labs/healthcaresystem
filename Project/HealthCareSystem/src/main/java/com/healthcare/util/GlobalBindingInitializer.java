package com.healthcare.util;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.InitBinder;

import com.healthcare.dao.PatientDao;
import com.healthcare.model.PatientEntity;

@ControllerAdvice
public class GlobalBindingInitializer {

	@Autowired
	PatientDao patientDao;
	/* Initialize a global InitBinder for dates instead of cloning its code in every Controller */

  @InitBinder
  public void binder(WebDataBinder binder) {
	  
	GenericEntityEditor<PatientEntity> patienteditor = new GenericEntityEditor<PatientEntity>(patientDao);
    binder.registerCustomEditor(Date.class, new DateEditor());   
	binder.registerCustomEditor(PatientEntity.class,"patient",patienteditor );
  }
}
