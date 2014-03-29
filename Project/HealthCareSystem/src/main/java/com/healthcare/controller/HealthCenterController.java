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
import com.healthcare.model.AllergyHistoryEntity;
import com.healthcare.model.ChildImmunisationEntity;
import com.healthcare.model.InfantDetailsEntity;
import com.healthcare.model.MedicalHistoryEntity;
import com.healthcare.model.MedicationDetailsEntity;
import com.healthcare.model.MedicationTreatmentEntity;
import com.healthcare.model.PatientEntity;
import com.healthcare.model.PncDetailsEntity;
import com.healthcare.model.PregnancyHistoryEntity;
import com.healthcare.model.PregnancyOutcomeEntity;
import com.healthcare.model.SurgicalHistoryEntity;
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
			@PathVariable("patientCode") Long patientCode, HttpSession session) {

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
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		medicalHistory.setPatient(patient);
		map.addAttribute("medicalHistory", medicalHistory);
		return "healthcenter/medicalHistory";
	}

	@RequestMapping(value = "/medicalHistory", method = RequestMethod.POST)
	public ModelAndView addMedicalHistory(
			@ModelAttribute(value = "medicalHistory") MedicalHistoryEntity medicalHistory,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
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
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		medicationDetails.setPatient(patient);
		map.addAttribute("medicationDetails", medicationDetails);
		return "healthcenter/medicationDetails";
	}

	@RequestMapping(value = "/medicationDetails", method = RequestMethod.POST)
	public ModelAndView addMedicationDetails(
			@ModelAttribute(value = "medicationDetails") MedicationDetailsEntity medicationDetails,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		medicationDetails.setPatient(patient);
		healthCenterService.addMedicationDetails(medicationDetails);
		model.setViewName("healthcenter/medicationDetails");
		return model;
	}

	// end of medical History

	// pegnancyhistory Details

	@RequestMapping(value = "/pregnancyHistory", method = RequestMethod.GET)
	public String addPregnancyHistoryFrom(ModelMap map, HttpSession session) {
		PregnancyHistoryEntity pregnancyHistory = new PregnancyHistoryEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		pregnancyHistory.setPatient(patient);
		map.addAttribute("pregnancyHistory", pregnancyHistory);
		return "healthcenter/pregnancyHistory";
	}

	@RequestMapping(value = "/pregnancyHistory", method = RequestMethod.POST)
	public ModelAndView addPregnancyHistory(
			@ModelAttribute(value = "pregnancyHistory") PregnancyHistoryEntity pregnancyHistory,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		pregnancyHistory.setPatient(patient);
		healthCenterService.addPregnancyHistory(pregnancyHistory);
		model.setViewName("healthcenter/pregnancyHistory");
		return model;
	}

	// end of pregnancy History
	// medication Treatment Details

		@RequestMapping(value = "/medicationTreatment", method = RequestMethod.GET)
		public String addMedicationTreatmentForm(ModelMap map, HttpSession session) {
			MedicationTreatmentEntity medicationTreatment = new MedicationTreatmentEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			medicationTreatment.setPatient(patient);
			map.addAttribute("medicationTreatment", medicationTreatment);
			return "healthcenter/medicationTreatment";
		}

		@RequestMapping(value = "/medicationTreatment", method = RequestMethod.POST)
		public ModelAndView addPregnancyHistory(
				@ModelAttribute(value = "medicationTreatment") MedicationTreatmentEntity medicationTreatment,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			medicationTreatment.setPatient(patient);
			healthCenterService.addMedicationTreatment(medicationTreatment);
			model.setViewName("healthcenter/medicationTreatment");
			return model;
		}

		// end of pregnancy History
		// start of surgicalHistory
		@RequestMapping(value = "/surgicalHistory", method = RequestMethod.GET)
		public String addSurgicalHistoryForm(ModelMap map, HttpSession session) {
			SurgicalHistoryEntity surgicalHistory = new SurgicalHistoryEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			surgicalHistory.setPatient(patient);
			map.addAttribute("surgicalHistory", surgicalHistory);
			return "healthcenter/surgicalHistory";
		}

		@RequestMapping(value = "/surgicalHistory", method = RequestMethod.POST)
		public ModelAndView addSurgicalHistory(
				@ModelAttribute(value = "surgicalHistory") SurgicalHistoryEntity surgicalHistory,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			surgicalHistory.setPatient(patient);
			healthCenterService.addSurgicalHistory(surgicalHistory);
			model.setViewName("healthcenter/surgicalHistory");
			return model;
		}

		// end of surgicalHistory
		
		//pregnancyOutcome start
		@RequestMapping(value = "/pregnancyOutcome", method = RequestMethod.GET)
		public String addPregnancyOutcomeForm(ModelMap map, HttpSession session) {
			PregnancyOutcomeEntity pregnancyOutcome = new PregnancyOutcomeEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			pregnancyOutcome.setPatient(patient);
			map.addAttribute("pregnancyOutcome", pregnancyOutcome);
			return "healthcenter/pregnancyOutcome";
		}

		@RequestMapping(value = "/pregnancyOutcome", method = RequestMethod.POST)
		public ModelAndView addSurgicalHistory(
				@ModelAttribute(value = "pregnancyOutcome") PregnancyOutcomeEntity pregnancyOutcome,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			pregnancyOutcome.setPatient(patient);
			healthCenterService.addPregnancyOutcome(pregnancyOutcome);
			model.setViewName("healthcenter/pregnancyOutcome");
			return model;
		}
		//pregnancyOutcome end
		
		//start of CHILD_IMMUNISATION
		@RequestMapping(value = "/childImmunisation", method = RequestMethod.GET)
		public String addChildImmunisationForm(ModelMap map, HttpSession session) {
			ChildImmunisationEntity childImmunisation = new ChildImmunisationEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			childImmunisation.setPatient(patient);
			map.addAttribute("childImmunisation", childImmunisation);
			return "healthcenter/childImmunisation";
		}

		@RequestMapping(value = "/childImmunisation", method = RequestMethod.POST)
		public ModelAndView addChildImmunisation(
				@ModelAttribute(value = "childImmunisation") ChildImmunisationEntity childImmunisation,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			childImmunisation.setPatient(patient);
			healthCenterService.addChildImmunisation(childImmunisation);
			model.setViewName("healthcenter/childImmunisation");
			return model;
		}		
		//end of CHILD_IMMUNISATION
		//start INFANT_DETAILS
		@RequestMapping(value = "/infantDetails", method = RequestMethod.GET)
		public String addInfantDetailsForm(ModelMap map, HttpSession session) {
			InfantDetailsEntity infantDetails = new InfantDetailsEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			infantDetails.setPatient(patient);
			map.addAttribute("infantDetails", infantDetails);
			return "healthcenter/infantDetails";
		}

		@RequestMapping(value = "/infantDetails", method = RequestMethod.POST)
		public ModelAndView addInfantDetails(
				@ModelAttribute(value = "infantDetails") InfantDetailsEntity infantDetails,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			infantDetails.setPatient(patient);
			healthCenterService.addInfantDetails(infantDetails);
			model.setViewName("healthcenter/infantDetails");
			return model;
		}		
		//end INFANT_DETAILS
		
		//start ALLERGY_HISTORY
		@RequestMapping(value = "/allergyHistory", method = RequestMethod.GET)
		public String addallergyHistoryForm(ModelMap map, HttpSession session) {
			AllergyHistoryEntity allergyHistory = new AllergyHistoryEntity();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			allergyHistory.setPatient(patient);
			map.addAttribute("allergyHistory", allergyHistory);
			return "healthcenter/allergyHistory";
		}

		@RequestMapping(value = "/allergyHistory", method = RequestMethod.POST)
		public ModelAndView addallergyHistory(
				@ModelAttribute(value = "allergyHistory") AllergyHistoryEntity allergyHistory,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			allergyHistory.setPatient(patient);
			healthCenterService.addallergyHistory(allergyHistory);
			model.setViewName("healthcenter/allergyHistory");
			return model;
		}	
		//end ALLERGY_HISTORY
		
		//start pnc details
				@RequestMapping(value = "/pncDetails", method = RequestMethod.GET)
				public String addpncDetailsForm(ModelMap map, HttpSession session) {
					PncDetailsEntity pncDetails = new PncDetailsEntity();
					PatientEntity patient = (PatientEntity) session
							.getAttribute("currentPatient");
					pncDetails.setPatient(patient);
					map.addAttribute("pncDetails", pncDetails);
					return "healthcenter/pncDetails";
				}

				@RequestMapping(value = "/pncDetails", method = RequestMethod.POST)
				public ModelAndView addpncDetails(
						@ModelAttribute(value = "pncDetails") PncDetailsEntity pncDetails,
						BindingResult result, HttpSession session) {

					ModelAndView model = new ModelAndView();
					// System.out.println("patient uhid"+medicalHistory.getPatient().getUhid());
					PatientEntity patient = (PatientEntity) session
							.getAttribute("currentPatient");
					pncDetails.setPatient(patient);
					healthCenterService.addPncDetails(pncDetails);
					model.setViewName("healthcenter/pncDetails");
					return model;
				}	
				//end pnc details

}
