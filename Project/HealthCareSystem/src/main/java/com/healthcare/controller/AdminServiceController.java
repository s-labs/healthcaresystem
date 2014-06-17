package com.healthcare.controller;



import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServlet;

import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.healthcare.form.DistrictForm;
import com.healthcare.form.HealthCenterForm;
import com.healthcare.model.DistrictEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.MandalEntity;
import com.healthcare.model.StateEntity;
import com.healthcare.model.UserEntity;
import com.healthcare.model.VillageEntity;
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
		model.addObject("SUCCESS_MESSAGE", "successfull added the State");
		return model;
	}

	@RequestMapping(value = "/allDistricts", method = RequestMethod.GET)
	public String allDistricts(ModelMap map) {

		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);
		return "admin/allDistricts";
	}

	@RequestMapping("/district/{districtCode}")
	public ModelAndView districtDetails(
			@PathVariable("districtCode") Long districtCode) {
		ModelAndView model = new ModelAndView();

		DistrictEntity district = adminService.getDistrict(districtCode);
		model.addObject("district", district);
		Set<MandalEntity> mandals = adminService
				.getMandalsOfdistirict(districtCode);
		model.addObject("mandals", mandals);
		model.addObject("mandal", new MandalEntity());
		model.setViewName("admin/district");
		return model;
	}
	
	@RequestMapping("/deletedistrict/{districtCode}")
	public ModelAndView deleteDistrict(
			@PathVariable("districtCode") Long districtCode) {
		ModelAndView model = new ModelAndView();

		adminService.deleteDistrict(districtCode);
		model.setViewName("success");
		model.addObject("SUCCESS_MESSAGE", "district deleted successfully");
		return model;
	}
	
	@RequestMapping("/deletemandal/{mandalCode}")
	public ModelAndView deleteMandal(
			@PathVariable("mandalCode") Long mandalCode) {
		ModelAndView model = new ModelAndView();

		adminService.deleteMandal(mandalCode);
		model.setViewName("success");
		
		model.addObject("SUCCESS_MESSAGE", "mandal deleted successfully");
		return model;
	}

	@RequestMapping(value="/mandalsList",method=RequestMethod.GET, headers="Accept=application/json", produces = "application/json;charset=UTF-8")
	
	public ModelAndView mandalsList(
			@RequestParam("districtCode") Long districtCode) {
		ModelAndView model = new ModelAndView();
		System.out.println("mandals list");
		
		Set<MandalEntity> mandals = adminService
				.getMandalsOfdistirict(districtCode);
		model.addObject("mandals", mandals);
		model.setViewName("admin/mandaloptions");
		return model;
	}

	@RequestMapping(value = "/addDistrict", method = RequestMethod.GET)
	public String addDistrictFrom(ModelMap map) {
		map.addAttribute("districtform", new DistrictForm());
		List<StateEntity> states = adminService.getAllStates();		
		map.addAttribute("states", states);
		List<HealthCenterEntity> healthcenters = adminService.getHealthCentersOfLevel(1);
		map.addAttribute("nextHealthCenters", healthcenters);
		
		return "admin/addDistrict";
	}

	@RequestMapping(value = "/addDistrict", method = RequestMethod.POST)
	public ModelAndView addDistrict(
			@ModelAttribute(value = "districtform") DistrictForm districtform,
			BindingResult result,@RequestParam("healthcenterName") String healthcenterName,@RequestParam("nexthealthcenterid") long nexthealthcenterid,@RequestParam("healthcenterlevel") int healthcenterlevel) {

		ModelAndView model = new ModelAndView();
		HealthCenterForm healthcenterform = new HealthCenterForm();
		HealthCenterEntity healthcenter = new HealthCenterEntity();
		healthcenter.setLevel(healthcenterlevel);
		healthcenter.setName(healthcenterName);
		healthcenterform.setHealthcenter(healthcenter );
		healthcenterform.setNext(nexthealthcenterid);
		healthcenter = adminService.addHealthCenter(healthcenterform );
		districtform.getDistrict().setHealthCenter(healthcenter);

		adminService.addDistrict(districtform.getDistrict(),
				districtform.getStateId());
		model.addObject("SUCCESS_MESSAGE", "district added successfully");
		model.setViewName("admin/addDistrict");
		return model;
	}
	
	@RequestMapping(value = "/viewDistrict", method = RequestMethod.GET)
	public String viewDistirct(ModelMap map) {
		
		List<StateEntity> states = adminService.getAllStates();
		map.addAttribute("states", states);

		return "admin/viewDistrict";
	}
	
	@RequestMapping(value="districtsUnderState")
	public ModelAndView getDistrictsOfaState(@RequestParam("statecode") Long stateCode) {
		ModelAndView model = new ModelAndView();

		StateEntity state = adminService.getDistrictsOfaState(stateCode);
		model.addObject("state", state);
		
		model.setViewName("admin/districtsunderstate");
		return model;
	}

	@RequestMapping(value = "/addMandal", method = RequestMethod.GET)
	public String addMandalFrom(ModelMap map) {
		map.addAttribute("mandal", new MandalEntity());
		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);

		return "admin/addMandal";
	}

	@RequestMapping("districtHealthCenterCode")
	public ModelAndView districtHealthCenterCode(@RequestParam("districtcode") Long districtcode) {
		ModelAndView model = new ModelAndView();

		DistrictEntity district = adminService.getDistrict(districtcode);
		model.addObject("healthcenter", district.getHealthCenter());
		
		model.setViewName("admin/nextHealthCenterId");
		return model;
	}
	@RequestMapping(value = "/addMandal", method = RequestMethod.POST)
	public ModelAndView addMandal(
			@ModelAttribute(value = "mandal") MandalEntity mandal,
			BindingResult result,@RequestParam("healthcenterName") String healthcenterName,@RequestParam("nexthealthcenterid") long nexthealthcenterid,@RequestParam("healthcenterlevel") int healthcenterlevel) {

		ModelAndView model = new ModelAndView();
		HealthCenterForm healthcenterform = new HealthCenterForm();
		HealthCenterEntity healthcenter = new HealthCenterEntity();
		healthcenter.setName(healthcenterName);
		healthcenter.setLevel(healthcenterlevel);
		healthcenterform.setHealthcenter(healthcenter );
		healthcenterform.setNext(nexthealthcenterid);
		healthcenter = adminService.addHealthCenter(healthcenterform );
		mandal.setHealthCenter(healthcenter);
		adminService.addMandal(mandal);
		model.addObject("SUCCESS_MESSAGE", "mandal added successfully");
		model.setViewName("admin/addMandal");
		return model;
	}
	
	
	@RequestMapping(value = "/viewMandal", method = RequestMethod.GET)
	public String viewMandal(ModelMap map) {
		
		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);

		return "admin/viewMandal";
	}

	@RequestMapping(value="mandalsUnderDistrict")
	public ModelAndView getMandalsOfaDistrict(@RequestParam("districtcode") Long districtcode) {
		ModelAndView model = new ModelAndView();

		DistrictEntity district = adminService.getMandalsOfaDistrict(districtcode);
		model.addObject("district", district);
		
		model.setViewName("admin/mandalsunderdistrict");
		return model;
	}
	
	@RequestMapping("/mandal/{mandalCode}")
	public ModelAndView mandalDetails(
			@PathVariable("mandalCode") Long mandalCode) {
		ModelAndView model = new ModelAndView();

		MandalEntity mandal = adminService.getMandal(mandalCode);
		model.addObject("mandal", mandal);
		model.setViewName("admin/mandal");
		return model;
	}

	// village

	@RequestMapping(value = "/addVillage", method = RequestMethod.GET)
	public String addVillageFrom(ModelMap map) {
		map.addAttribute("village", new VillageEntity());
		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);

		return "admin/addVillage";
	}
	@RequestMapping(value = "/viewVillage", method = RequestMethod.GET)
	public String viewVillage(ModelMap map) {
		map.addAttribute("village", new VillageEntity());
		List<DistrictEntity> districts = adminService.getAllDistricts();
		map.addAttribute("districts", districts);

		return "admin/viewVillage";
	}

	@RequestMapping(value = "/addVillage", method = RequestMethod.POST)
	public ModelAndView addVillage(
			@ModelAttribute(value = "village") VillageEntity village,
			BindingResult result,@RequestParam("healthcenterName") String healthcenterName,@RequestParam("nexthealthcenterid") long nexthealthcenterid,@RequestParam("healthcenterlevel") int healthcenterlevel) {

		ModelAndView model = new ModelAndView();
		HealthCenterForm healthcenterform = new HealthCenterForm();
		HealthCenterEntity healthcenter = new HealthCenterEntity();
		healthcenter.setLevel(healthcenterlevel);
		healthcenter.setName(healthcenterName);
		healthcenterform.setHealthcenter(healthcenter );
		
		healthcenterform.setNext(nexthealthcenterid);
		healthcenter = adminService.addHealthCenter(healthcenterform );
		village.setHealthCenter(healthcenter);
		adminService.addVillage(village);
		model.addObject("SUCCESS_MESSAGE", "village added successfully");

		model.setViewName("admin/addVillage");
		return model;
	}
	
	@RequestMapping(value="villagesundermandal")
	public ModelAndView getVillagesOfaMandal(@RequestParam("mandlcode") Long mandalCode) {
		ModelAndView model = new ModelAndView();

		MandalEntity mandal = adminService.getVillagesOfaMandal(mandalCode);
		model.addObject("mandal", mandal);
		
		model.setViewName("admin/villagesundermandal");
		return model;
	}

	@RequestMapping("/village/{villageCode}")
	public ModelAndView villageDetails(
			@PathVariable("villageCode") Long villageCode) {
		ModelAndView model = new ModelAndView();

		VillageEntity village = adminService.getVillage(villageCode);
		model.addObject("village", village);
		//List<HealthCenterEntity> healthcenters = adminService
			//	.getAllHealthCenters();
		//model.addObject("healthcenters", healthcenters);
		model.setViewName("admin/village");
		return model;
	}
	
	@RequestMapping("mandalsHealthCenterCode")
	public ModelAndView healthcentersUnderMandal(@RequestParam("mandlcode") Long mandalCode) {
		ModelAndView model = new ModelAndView();

		MandalEntity mandal = adminService.getMandal(mandalCode);
		model.addObject("healthcenter", mandal.getHealthCenter());
		
		model.setViewName("admin/nextHealthCenterId");
		return model;
	}

	// End of village

	@RequestMapping(value = "/addHealthCenter", method = RequestMethod.GET)
	public String addHealthCenterFrom(ModelMap map) {
		map.addAttribute("healthcenterform", new HealthCenterForm());
		return "admin/addHealthCenter";
	}

	@RequestMapping(value = "/associateHealthCenter", method = RequestMethod.POST)
	public String associateHealthCenter(
			@RequestParam(value = "level", required = true) String level,
			@RequestParam(value = "healthcenterid", required = true) long healthcenterid,
			@RequestParam(value = "associateto", required = true) long associateto) {

		adminService
				.associateHealthCenterto(healthcenterid, associateto, level);

		return "redirect:" + level + "/" + associateto;

	}

	@RequestMapping(value = "/addHealthCenter", method = RequestMethod.POST)
	public ModelAndView addHealthCenter(
			@ModelAttribute(value = "healthcenterform") HealthCenterForm healthcenterform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addHealthCenter(healthcenterform);
	
		model.addObject("SUCCESS_MESSAGE", "village added successfully");
		model.setViewName("admin/addHealthCenter");
		return model;
	}

	@RequestMapping(value = "/editHealthCenter/{healthcentercode}", method = RequestMethod.GET)
	public String editHealthCenterForm(
			@PathVariable("healthcentercode") Long healthcentercode,
			ModelMap map) {

		HealthCenterEntity healthcenter = adminService
				.getHealthCenter(healthcentercode);
		HealthCenterForm healthcenterform = new HealthCenterForm();
		healthcenterform.setHealthcenter(healthcenter);
		map.addAttribute("healthcenterform", healthcenterform);
		List<HealthCenterEntity> healthcenters = adminService
				.getAllHealthCenters();
		map.addAttribute("healthcenters", healthcenters);

		return "admin/editHealthCenter";
	}

	@RequestMapping(value = "/editHealthCenter", method = RequestMethod.POST)
	public ModelAndView editHealthCenter(
			@ModelAttribute(value = "healthcenterform") HealthCenterForm healthcenterform,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.updateHealthCenter(healthcenterform);
		List<HealthCenterEntity> healthcenters = adminService
				.getAllHealthCenters();
		model.addObject("healthcenters", healthcenters);
		model.setViewName("admin/addHealthCenter");
		return model;
	}

	@RequestMapping(value = "/addHCAdmin", method = RequestMethod.GET)
	public String addHCAdminFrom(ModelMap map) {
		List<HealthCenterEntity> healthcenters = adminService
				.getAllHealthCenters();
		map.addAttribute("healthcenters", healthcenters);
		map.addAttribute("user", new UserEntity());

		return "admin/addHCAdmin";
	}
	
	@RequestMapping(value = "/addHCAdmin/{healthcentercode}", method = RequestMethod.GET)
	public String addHCAdminFrom(ModelMap map,@PathVariable("healthcentercode") long healthcentercode) {
		List<HealthCenterEntity> healthcenters = new ArrayList<HealthCenterEntity>();
		HealthCenterEntity healthcenter;
		healthcenter = adminService.getHealthCenter(healthcentercode);
		
		healthcenters.add(healthcenter);
		map.addAttribute("healthcenters", healthcenters);
		map.addAttribute("user", new UserEntity());

		return "admin/addHCAdmin";
	}

	@RequestMapping(value = "/addHCAdmin", method = RequestMethod.POST)
	public ModelAndView addHCAdmin(
			@ModelAttribute(value = "user") UserEntity user,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addHCAdmin(user);

		model.addObject("SUCCESS_MESSAGE",
				"successfull added the Healthcenter Admin user");
		model.setViewName("admin/addHCAdmin");
		return model;
	}

	// /add ROLE_DHS
	@RequestMapping(value = "/addDHSAdmin", method = RequestMethod.GET)
	public String addDHSFrom(ModelMap map) {

		map.addAttribute("user", new UserEntity());

		return "admin/addDHS";
	}

	@RequestMapping(value = "/addDHSAdmin", method = RequestMethod.POST)
	public ModelAndView addHHS(@ModelAttribute(value = "user") UserEntity user,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		adminService.addDHSAdmin(user);

		model.addObject("SUCCESS_MESSAGE", "successfull added the DHS user");
		model.setViewName("admin/addDHS");
		return model;
	}

}
