package com.healthcare.controller;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpSession;

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

import com.healthcare.form.UserForm;
import com.healthcare.model.AllergyHistoryEntity;
import com.healthcare.model.ChildImmunisationEntity;
import com.healthcare.model.DiseaseEntity;
import com.healthcare.model.DrugPrescriptionEntity;
import com.healthcare.model.HealthCenterEntity;
import com.healthcare.model.HospitalisationHistoryEntity;
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
		model.addObject("SUCCESS_MESSAGE", "doctor added successfully");
		healthCenterService.addUser(userform);

		model.setViewName("healthcenter/addDoctor");
		return model;
	}

	@RequestMapping(value = "/allUsers", method = RequestMethod.GET)
	public ModelAndView addUsers(HttpSession session) {
		ModelAndView model = new ModelAndView();
		UserEntity user = (UserEntity) session.getAttribute("user");
		long healthcenterid = 0;
		Set<UserEntity> users = new HashSet<UserEntity>();
		if (user != null) {
			healthcenterid = user.getHealthcenter().getId();
			System.out.println("healthcenterid: "+healthcenterid);
			users = healthCenterService
					.getAllUsersOfHealthCenter(healthcenterid);

		}

		model.addObject("users", users);
		model.setViewName("healthcenter/allUsers");
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
	public ModelAndView viewAllPatients(HttpSession session) {
		ModelAndView model = new ModelAndView();
		long healthcenterid = 0;
		UserEntity user = (UserEntity) session.getAttribute("user");
		Set<PatientEntity> patients = new HashSet<PatientEntity>();
		if (user != null) {
			healthcenterid = user.getHealthcenter().getId();
			System.out.println(" healthcenterid :"+healthcenterid);
			patients = healthCenterService
					.getAllPatientsOfHealthCenter(healthcenterid);

		}
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
		model.addObject("SUCCESS_MESSAGE", "clerk added successfully");

		model.setViewName("healthcenter/addClerk");
		return model;
	}

	// end of clerk

	@RequestMapping(value = "/addPatient", method = RequestMethod.POST)
	public ModelAndView addState(
			@ModelAttribute(value = "patient") PatientEntity patient,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		UserEntity user = (UserEntity) session.getAttribute("user");
		if (user != null) {
			HealthCenterEntity healthcenter = user.getHealthcenter();
			patient.setHealthCenter(healthcenter);
		}
		healthCenterService.addPatient(patient);
		List<PatientEntity> patients = healthCenterService.getAllPatients();
		model.addObject("patients", patients);
		model.setViewName("healthcenter/addPatient");
		return model;
	}
	
	// hospitalization

		@RequestMapping(value = "/hospitalisationHistory", method = RequestMethod.GET)
		public String addHospitalisationHistoryFrom(ModelMap map, HttpSession session) {
			HospitalisationHistoryEntity hospitalisationHistory = new HospitalisationHistoryEntity();
			UserEntity user = (UserEntity) session.getAttribute("user");
			Set<PatientEntity> patients = new HashSet<PatientEntity>();
			if (user != null) {
				Long healthcenterid = user.getHealthcenter().getId();
				System.out.println(" healthcenterid :"+healthcenterid);
				patients = healthCenterService
						.getAllPatientsOfHealthCenter(healthcenterid);

			}
			map.addAttribute("patients", patients);
			map.addAttribute("hospitalisationHistory", hospitalisationHistory);
			return "healthcenter/hospitalisationHistory";
		}

		@RequestMapping(value = "/hospitalisationHistory", method = RequestMethod.POST)
		public ModelAndView addHospitalisationHistory(
				@ModelAttribute(value = "hospitalisationHistory") HospitalisationHistoryEntity hospitalisationHistory,
				BindingResult result, HttpSession session) {

			ModelAndView model = new ModelAndView();
			
			healthCenterService.addHospitalisationHistory(hospitalisationHistory);
			model.setViewName("healthcenter/hospitalisationHistory");
			return model;
		}

		// end hospitalization

	// medical History

	@RequestMapping(value = "/medicalHistory", method = RequestMethod.GET)
	public String addMedicalHistoryFrom(ModelMap map, HttpSession session) {
		MedicalHistoryEntity medicalHistory = new MedicalHistoryEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		medicalHistory.setPatient(patient);
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "Medical History added successfully");
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
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "Medication details added successfully");
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
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "Pregnancy added successfully");
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
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "Medication Treatment added successfully");
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
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "surgical History added successfully");
		model.setViewName("healthcenter/surgicalHistory");
		return model;
	}

	// end of surgicalHistory

	// pregnancyOutcome start
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
		model.addObject("SUCCESS_MESSAGE", "Pregnancy Outcome added successfully");
		return model;
	}

	// pregnancyOutcome end

	// start of CHILD_IMMUNISATION
	@RequestMapping(value = "/childImmunisation", method = RequestMethod.GET)
	public String addChildImmunisationForm(ModelMap map, HttpSession session) {
		ChildImmunisationEntity childImmunisation = new ChildImmunisationEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		childImmunisation.setPatient(patient);
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "child Immunisation added successfully");
		model.setViewName("healthcenter/childImmunisation");
		return model;
	}

	// end of CHILD_IMMUNISATION
	// start INFANT_DETAILS
	@RequestMapping(value = "/infantDetails", method = RequestMethod.GET)
	public String addInfantDetailsForm(ModelMap map, HttpSession session) {
		InfantDetailsEntity infantDetails = new InfantDetailsEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		infantDetails.setPatient(patient);
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "infant Details added successfully");
		model.setViewName("healthcenter/infantDetails");
		return model;
	}

	// end INFANT_DETAILS

	// start ALLERGY_HISTORY
	@RequestMapping(value = "/allergyHistory", method = RequestMethod.GET)
	public String addallergyHistoryForm(ModelMap map, HttpSession session) {
		AllergyHistoryEntity allergyHistory = new AllergyHistoryEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		allergyHistory.setPatient(patient);
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "allergy History added successfully");
		
		model.setViewName("healthcenter/allergyHistory");
		return model;
	}

	// end ALLERGY_HISTORY

	// start pnc details
	@RequestMapping(value = "/pncDetails", method = RequestMethod.GET)
	public String addpncDetailsForm(ModelMap map, HttpSession session) {
		PncDetailsEntity pncDetails = new PncDetailsEntity();
		PatientEntity patient = (PatientEntity) session
				.getAttribute("currentPatient");
		pncDetails.setPatient(patient);
		if(patient == null) {
			map.addAttribute("choosepatient",true);
		}
		else
		{
			map.addAttribute("choosepatient",false);
		}
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
		model.addObject("SUCCESS_MESSAGE", "pnc details added successfully");
		
		model.setViewName("healthcenter/pncDetails");
		return model;
	}

	// end pnc details
	// drugPrescriptionLookup
	@RequestMapping(value = "/drugPrescription", method = RequestMethod.GET)
	public String addDrugPrescriptionForm(ModelMap map, HttpSession session) {
		DrugPrescriptionEntity drugPrescription = new DrugPrescriptionEntity();
		List<DiseaseEntity> diseases = healthCenterService.getAllDiseases();
		map.addAttribute("diseases", diseases);
		map.addAttribute("drugPrescription", drugPrescription);
		return "healthcenter/drugPrescription";
	}

	@RequestMapping(value = "/drugPrescription", method = RequestMethod.POST)
	public ModelAndView addDrugPrescription(
			@ModelAttribute(value = "drugPrescription") DrugPrescriptionEntity drugPrescription,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addDrugPrescription(drugPrescription);
		model.addObject("SUCCESS_MESSAGE", "drug prescription added successfully");
		

		model.setViewName("healthcenter/drugPrescription");
		return model;
	}

	// end
	// disease start
	@RequestMapping(value = "/disease", method = RequestMethod.GET)
	public String adddiseaseForm(ModelMap map, HttpSession session) {
		DiseaseEntity disease = new DiseaseEntity();
		map.addAttribute("disease", disease);
		return "healthcenter/disease";
	}

	@RequestMapping(value = "/disease", method = RequestMethod.POST)
	public ModelAndView addDisease(
			@ModelAttribute(value = "disease") DiseaseEntity disease,
			BindingResult result, HttpSession session) {

		ModelAndView model = new ModelAndView();
		healthCenterService.addDisease(disease);
		model.setViewName("healthcenter/disease");
		return model;
	}
	// disease end
	
	// tng start
		@RequestMapping(value = "/tng", method = RequestMethod.GET)
		public String tngForm(ModelMap map, HttpSession session) {
		
			return "healthcenter/tng";
		}

		@RequestMapping(value = "/tng", method = RequestMethod.POST)
		public ModelAndView tng(
				@RequestParam("tng") String tng, HttpSession session) {

			ModelAndView model = new ModelAndView();
			PatientEntity patient = (PatientEntity) session
					.getAttribute("currentPatient");
			healthCenterService.updatePatient(patient,tng);
			model.setViewName("healthcenter/tng");
			return model;
		}
		// tng end

}
