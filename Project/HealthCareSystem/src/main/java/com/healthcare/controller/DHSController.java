package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.services.HealthCenterService;

@Controller
@RequestMapping("/dhs")
public class DHSController {
	
	@Autowired
	private HealthCenterService healthCenterService;

	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(ModelMap map) {
		
		return "dhs/homepage";
	}
	
	@RequestMapping(value = "/grid/{gridcode}", method = RequestMethod.GET)
	public ModelAndView gridpage(@PathVariable("gridcode") int gridlevel) {
		ModelAndView model = new ModelAndView();
		System.out.println(" Grid level "+gridlevel);
		List<HealthCenterEntity> healthcenters  = healthCenterService.getAllHealthCentersOfLevel(gridlevel);
		model.addObject("level",gridlevel);
		model.addObject("healthcenters", healthcenters);
		model.setViewName("dhs/gridpage");
		return model;
	}
	
	@RequestMapping(value = "/healthcenter/{healthCenterCode}", method = RequestMethod.GET)
	public ModelAndView healthcenterpage(@PathVariable("healthCenterCode") long healthCenterCode) {
		ModelAndView model = new ModelAndView();
		
		HealthCenterEntity healthcenter  = healthCenterService.getHealthCenter(healthCenterCode);
		model.addObject("healthcenter", healthcenter);
		model.setViewName("dhs/healthCenterPage");
		return  model;
	}
	
	@RequestMapping("/patient/{patientCode}")
	public ModelAndView patientDetails(
			@PathVariable("patientCode") Long patientCode) {
		ModelAndView model = new ModelAndView();
		PatientEntity patient = healthCenterService.getPatient(patientCode);
		model.addObject("patient", patient);
		model.setViewName("dhs/patient");
		return model;
	}


}
