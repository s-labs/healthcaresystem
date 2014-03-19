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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.healthcare.model.DistrictEntity;
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
	public ModelAndView addState(@ModelAttribute(value = "state") StateEntity state,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addState(state);
		List<StateEntity> states = adminService.getAllStates();
		model.addObject("states", states);
		model.setViewName("admin/addState");
		return model;
	}
		
		/*srihari *************** code ***************** started*/
		
		@RequestMapping(value = "/addDistrict", method = RequestMethod.GET)
		public String addDistrictFrom(ModelMap map) {
			map.addAttribute("district", new DistrictEntity());
			List<StateEntity> states = adminService.getAllStates();
			map.addAttribute("states", states);
			return "admin/addDistrict";
		}
		
		@RequestMapping(value = "/addDistrict", method = RequestMethod.POST)
		public ModelAndView addDistrict(@ModelAttribute(value = "district") DistrictEntity district,
				BindingResult result) {

			ModelAndView model = new ModelAndView();
			adminService.addDistrict(district,new Long(1));
			List<DistrictEntity> districts = adminService.getAllDistricts();
			model.addObject("districts", districts);
			List<StateEntity> states = adminService.getAllStates();
			model.addObject("states", states);
			model.setViewName("admin/addDistrict");
			return model;
		}
		
		/*srihari ************** code **************** ended*/
		
		
		/*srihari ****code for adding mandals*******date 12/03/2014 *******started*/
		
		@RequestMapping(value = "/addMandal", method = RequestMethod.GET)
		public String addMandalFrom(ModelMap map) {
			map.addAttribute("mandal", new MandalEntity());
			List<MandalEntity> mandals=adminService.getAllMandals();
			map.addAttribute("mandals",mandals);
			
			List<DistrictEntity> districts=adminService.getAllDistricts();
			map.addAttribute("districts", districts);
			
			return "admin/addMandal";
		}
		
		 /*@RequestMapping("/state/{stateCode}")
		 public ModelAndView stateDetails(@PathVariable("stateCode") Long stateCode) {
			 ModelAndView model = new ModelAndView();
			
				StateEntity state = adminService.getState(stateCode);
				model.addObject("state", state);
				model.setViewName("admin/state");
				return model; 
		 }*/

		 
		@RequestMapping(value = "/addMandal", method = RequestMethod.POST)
		public ModelAndView addMandal(@ModelAttribute(value = "mandal") MandalEntity mandal,
				BindingResult result) {

			ModelAndView model = new ModelAndView();
			adminService.addMandal(mandal);
			List<MandalEntity> mandals=adminService.getAllMandals();
			model.addObject("mandals", mandals);
			List<DistrictEntity> districts=adminService.getAllDistricts();
			model.addObject("districts", districts);
			model.setViewName("admin/addMandal");
			return model;
		}
		
		/*srihari **************date 12/03/2014 **************** ended*/
		
		
		
	}


