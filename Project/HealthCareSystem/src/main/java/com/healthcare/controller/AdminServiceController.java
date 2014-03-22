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

import com.healthcare.form.DistrictForm;
import com.healthcare.form.HealthCenterForm;
import com.healthcare.form.UserForm;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;
import com.healthcare.services.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminServiceController {

	@Autowired
	private AdminService adminService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homepage(ModelMap map) {

		return "admin/homepage";
	}

	@RequestMapping(value = "/addState", method = RequestMethod.GET)
	public String addStateFrom(ModelMap map) {
		map.addAttribute("state", new StateEntity());
		List<StateEntity> states = adminService.getAllStates();
		map.addAttribute("states", states);
		return "admin/addState";
	}

	@RequestMapping("/state/{stateCode}")
	public ModelAndView stateDetails(@PathVariable("stateCode") Long stateCode) {
		ModelAndView model = new ModelAndView();

		StateEntity state = adminService.getState(stateCode);
		model.addObject("state", state);
		model.setViewName("admin/state");
		return model;
	}

	@RequestMapping(value = "/addState", method = RequestMethod.POST)
	public ModelAndView addState(
			@ModelAttribute(value = "state") StateEntity state,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addState(state);
		List<StateEntity> states = adminService.getAllStates();
		model.addObject("states", states);
		model.setViewName("admin/addState");
		return model;
	}

	@RequestMapping(value = "/addDistrict", method = RequestMethod.GET)
	public String addDistrictFrom(ModelMap map) {
		map.addAttribute("districtform", new DistrictForm());
		List<StateEntity> states = adminService.getAllStates();
		map.addAttribute("states", states);
		return "admin/addDistrict";
	}

	@RequestMapping(value = "/addDistrict", method = RequestMethod.POST)
	public ModelAndView addDistrict(
			@ModelAttribute(value = "districtform") DistrictForm districtform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		long statecode = 1;
		adminService.addDistrict(districtform.getDistrict(),
				districtform.getStateId());
		List<DistrictEntity> districts = adminService.getAllDistricts();
		model.addObject("districts", districts);
		List<StateEntity> states = adminService.getAllStates();
		model.addObject("states", states);
		model.setViewName("admin/addDistrict");
		return model;
	}

	@RequestMapping(value = "/addMandal", method = RequestMethod.GET)
	public String addMandalFrom(ModelMap map) {
		map.addAttribute("mandal", new MandalEntity());
		List<MandalEntity> mandals = adminService.getAllMandals();
		map.addAttribute("mandals", mandals);

		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);

		return "admin/addMandal";
	}

	@RequestMapping(value = "/addMandal", method = RequestMethod.POST)
	public ModelAndView addMandal(
			@ModelAttribute(value = "mandal") MandalEntity mandal,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addMandal(mandal);
		List<MandalEntity> mandals = adminService.getAllMandals();
		model.addObject("mandals", mandals);
		List<DistrictEntity> districts = adminService.getAllDistricts();
		model.addObject("districts", districts);
		model.setViewName("admin/addMandal");
		return model;
	}
	
	@RequestMapping(value = "/addHealthCenter", method = RequestMethod.GET)
	public String addHealthCenterFrom(ModelMap map) {
		map.addAttribute("healthcenterform", new HealthCenterForm());
		List<HealthCenterEntity> healthcenters = adminService.getAllHealthCenters();
		map.addAttribute("healthcenters", healthcenters);


		return "admin/addHealthCenter";
	}

	@RequestMapping(value = "/addHealthCenter", method = RequestMethod.POST)
	public ModelAndView addHealthCenter(
			@ModelAttribute(value = "healthcenterform") HealthCenterForm healthcenterform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addHealthCenter(healthcenterform);
		List<HealthCenterEntity> healthcenters = adminService.getAllHealthCenters();
		model.addObject("healthcenters", healthcenters);
		model.setViewName("admin/addHealthCenter");
		return model;
	}
	
	@RequestMapping(value = "/addHCAdmin", method = RequestMethod.GET)
	public String addHCAdminFrom(ModelMap map) {
		map.addAttribute("userform", new UserForm());
		
		return "admin/addHCAdmin";
	}

	@RequestMapping(value = "/addHCAdmin", method = RequestMethod.POST)
	public ModelAndView addHCAdmin(
			@ModelAttribute(value = "userform") UserForm userform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addHCAdmin(userform);
		
		model.setViewName("admin/addHCAdmin");
		return model;
	}


}
