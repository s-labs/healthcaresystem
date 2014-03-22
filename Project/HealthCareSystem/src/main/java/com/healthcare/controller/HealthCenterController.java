package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.healthcare.form.UserForm;
import com.healthcare.model.PatientEntity;
import com.healthcare.services.HealthCenterService;

@Controller
@RequestMapping("/healthCenter")
public class HealthCenterController {
	
	@Autowired
	private HealthCenterService healthCenterService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(ModelMap map) {
		
		return "healthcenter/homepage";
	}

	@RequestMapping(value = "/addPatient", method = RequestMethod.GET)
	public String addStateFrom(ModelMap map) {
		map.addAttribute("patient", new PatientEntity());
		
		return "healthcenter/addPatient";
	}
	
	@RequestMapping(value = "/addDoctor", method = RequestMethod.GET)
	public String addDoctorFrom(ModelMap map) {
		UserForm userform = new UserForm();
		//long healthcenterId;
		//userform.setHealthcenterId(healthcenterId);
		map.addAttribute("userform", userform);
		
		return "healthcenter/addPatient";
	}
	
	 @RequestMapping("/patient/{patientCode}")
	 public ModelAndView stateDetails(@PathVariable("patientCode") Long patientCode) {
		 ModelAndView model = new ModelAndView();
		
			
			model.setViewName("healthcenter/patient");
			return model; 
	 }

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public ModelAndView addState(@ModelAttribute(value = "patient") PatientEntity patient,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addPatient(patient);
		List<PatientEntity> patients = healthCenterService.getAllPatients();
		model.addObject("patients", patients);
		model.setViewName("healthcenter/addPatient");
		return model;
	}

}
