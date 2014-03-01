package com.healthcare.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView addState(@ModelAttribute(value = "state") StateEntity state,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addState(state);
		List<StateEntity> states = adminService.getAllStates();
		model.addObject("states", states);
		model.setViewName("admin/addState");
		return model;
	}

}
