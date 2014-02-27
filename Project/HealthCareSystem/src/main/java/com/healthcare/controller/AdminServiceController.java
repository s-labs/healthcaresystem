package com.healthcare.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.healthcare.model.StateEntity;
import com.healthcare.services.AdminService;

@Controller
public class AdminServiceController {
	
	@Autowired
    private AdminService  adminService;
	
	 @RequestMapping(value="/testyans",method = RequestMethod.GET)
	   public String printHello(ModelMap model) {
		 System.out.println(" thsi is hello message ");
	      model.addAttribute("message", "Hello Spring MVC Framework!!!!!!!");

	      return "hello";
	   }
	
	@RequestMapping(value = "/addState", method = RequestMethod.GET)
	public String addState(ModelMap map) {
		map.addAttribute("state", new StateEntity());
		return "admin/addState";
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String test(ModelMap map) {
		System.out.println("test ==> ");
		map.addAttribute("state", new StateEntity());
		return "admin/addState";
	}
	
	 @RequestMapping(value = "/add", method = RequestMethod.POST)
	    public String addEmployee(@ModelAttribute(value="state") StateEntity state, BindingResult result)
	    {
		 System.out.println(" ================ysna==================");
		 System.out.println(" name :"+state.getName());
		 	adminService.addState(state);
	        return "redirect:/";
	    }

}
