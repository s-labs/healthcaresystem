package com.healthcare.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

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
import com.healthcare.model.UserEntity;
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
	public String addDoctorFrom(ModelMap map,HttpSession session) {
		UserForm userform = new UserForm();
		
		long healthcenterid;
		UserEntity user = (UserEntity) session.getAttribute("user");
		if(user!=null) {
			healthcenterid = user.getHealthcenter().getId();
			userform.setHealthcenterId(healthcenterid);
		}
		//userform.setHealthcenterId(healthcenterId);
		userform.setRole("ROLE_DOCTOR");
		
		map.addAttribute("userform", userform);
		
		return "healthcenter/addDoctor";
	}
	
	@RequestMapping(value = "/addDoctor", method = RequestMethod.POST)
	public ModelAndView addDoctor(
			@ModelAttribute(value = "userform") UserForm userform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addUser(userform);
		
		model.setViewName("healthcenter/addDoctor");
		return model;
	}
	
	@RequestMapping("/patient/{patientCode}")
	 public ModelAndView stateDetails(@PathVariable("patientCode") Long patientCode) {
		 ModelAndView model = new ModelAndView();
		
			
			model.setViewName("healthcenter/patient");
			return model; 
	 }
	
	//clerk
	
	@RequestMapping(value = "/addClerk", method = RequestMethod.GET)
	public String addClerkFrom(ModelMap map,HttpSession session) {
		UserForm userform = new UserForm();
		
		long healthcenterid;
		UserEntity user = (UserEntity) session.getAttribute("user");
		if(user!=null) {
			healthcenterid = user.getHealthcenter().getId();
			userform.setHealthcenterId(healthcenterid);
		}
		//userform.setHealthcenterId(healthcenterId);
		userform.setRole("ROLE_CLERK");
		
		map.addAttribute("userform", userform);
		
		return "healthcenter/addClerk";
	}
	
	@RequestMapping(value = "/addClerk", method = RequestMethod.POST)
	public ModelAndView addClerk(
			@ModelAttribute(value = "userform") UserForm userform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addUser(userform);
		model.addObject("SUCESS_MESSAGE", "clerk added successfully");
		
		model.setViewName("healthcenter/addClerk");
		return model;
	}
	
	
	//end of clerk

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
