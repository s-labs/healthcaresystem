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
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
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
	public String addDoctorFrom(ModelMap map, HttpSession session) {
		UserForm userform = new UserForm();

		long healthcenterid;
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null) {
			healthcenterid = user.getHealthcenter().getId();
			userform.setHealthcenterId(healthcenterid);
		}
		// userform.setHealthcenterId(healthcenterId);
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
	public ModelAndView patientDetails(
			@PathVariable("patientCode") Long patientCode) {
		ModelAndView model = new ModelAndView();
		PatientEntity patient = healthCenterService.getPatient(patientCode);
		model.addObject("patient", patient);
		model.setViewName("healthcenter/patient");
		return model;
	}
	
	@RequestMapping("/switchTopatient/{patientCode}")
	public ModelAndView switchTopatient(
			@PathVariable("patientCode") Long patientCode,HttpSession session) {
		
		ModelAndView model = new ModelAndView();
		PatientEntity patient = healthCenterService.getPatient(patientCode);
		
		session.setAttribute("currentPatient", patient);
		model.addObject("patient", patient);
		model.setViewName("healthcenter/patient");
		return model;
	}

	@RequestMapping("/viewAllPatients")
	public ModelAndView viewAllPatients() {
		ModelAndView model = new ModelAndView();
		List<PatientEntity> patients = healthCenterService.getAllPatients();
		model.addObject("patients", patients);
		model.setViewName("healthcenter/allPatients");
		return model;
	}
	// clerk

	@RequestMapping(value = "/addClerk", method = RequestMethod.GET)
	public String addClerkFrom(ModelMap map, HttpSession session) {
		UserForm userform = new UserForm();

		long healthcenterid;
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null) {
			healthcenterid = user.getHealthcenter().getId();
			userform.setHealthcenterId(healthcenterid);
		}
		// userform.setHealthcenterId(healthcenterId);
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

	// end of clerk

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public ModelAndView addState(
			@ModelAttribute(value = "patient") PatientEntity patient,
			BindingResult result) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addPatient(patient);
		List<PatientEntity> patients = healthCenterService.getAllPatients();
		model.addObject("patients", patients);
		model.setViewName("healthcenter/addPatient");
		return model;
	}
	
	// medical History

		@RequestMapping(value = "/medicalHistory", method = RequestMethod.GET)
		public String addMedicalHistoryFrom(ModelMap map, HttpSession session) {
			MedicalHistoryEntity medicalHistory = new MedicalHistoryEntity();
			PatientEntity patient = (PatientEntity) session.getAttribute("currentPatient");			
			medicalHistory.setPatient(patient);
			map.addAttribute("medicalHistory", medicalHistory);
			return "healthcenter/medicalHistory";
		}

		@RequestMapping(value = "/medicalHistory", method = RequestMethod.POST)
		public ModelAndView addMedicalHistory(
				@ModelAttribute(value = "medicalHistory") MedicalHistoryEntity medicalHistory, 
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			//System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session.getAttribute("currentPatient");			
			medicalHistory.setPatient(patient);
			healthCenterService.addMedicalHistory(medicalHistory);
			model.setViewName("healthcenter/medicalHistory");
			return model;
		}

		// end of medical History
	
		// medication Details 

			@RequestMapping(value = "/medicationDetails", method = RequestMethod.GET)
			public String addMedicationDetailsFrom(ModelMap map, HttpSession session) {
				MedicationDetailsEntity medicationDetails = new MedicationDetailsEntity();
				PatientEntity patient = (PatientEntity) session.getAttribute("currentPatient");			
				medicationDetails.setPatient(patient);
				map.addAttribute("medicationDetails", medicationDetails);
				return "healthcenter/medicationDetails";
			}
	
			@RequestMapping(value = "/medicationDetails", method = RequestMethod.POST)
			public ModelAndView addMedicationDetails(
					@ModelAttribute(value = "medicationDetails") MedicationDetailsEntity medicationDetails, 
					BindingResult result, HttpSession session) {
	
				ModelAndView model = new ModelAndView();
				//System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
				PatientEntity patient = (PatientEntity) session.getAttribute("currentPatient");			
				medicationDetails.setPatient(patient);
				healthCenterService.addMedicationDetails(medicationDetails);
				model.setViewName("healthcenter/medicationDetails");
				return model;
			}
	
			// end of medical History
	

}
