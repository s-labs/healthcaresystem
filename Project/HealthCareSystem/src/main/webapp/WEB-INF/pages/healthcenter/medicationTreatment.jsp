<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#MIS").addClass("active");
				$("#MIS").addClass("open");
				$("#medicationTreatment").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">


					<form:form method="post" action="medicationTreatment"
						commandName="medicationTreatment">

						<table>
							<tr>
									<td>uhid</td>
									<td>${medicationTreatment.patient.uhid}</td>
								</tr>
								<tr>
									<td>Name</td>
									<td>${medicationTreatment.patient.firstName}
										${medicationTreatment.patient.lastName}</td>
								</tr>
							<tr>
								<td>ClinicalExamVitalsSystolicBP</td>
								<td><form:input path="ClinicalExamVitalsSystolicBP" /></td>
							</tr>

							<tr>
								<td>ClinicalExamVitalsDiastolicBP</td>
								<td><form:input path="ClinicalExamVitalsDiastolicBP" /></td>
							</tr>

							<tr>
								<td>ClinicalExamPulseRate</td>
								<td><form:input path="ClinicalExamPulseRate" /></td>
							</tr>

							<tr>
								<td>ClinicalExamTemperature</td>
								<td><form:input path="ClinicalExamTemperature" /></td>
							</tr>

							<tr>
								<td>ClinicalExamHeight_cms</td>
								<td><form:input path="ClinicalExamHeight_cms" /></td>
							</tr>

							<tr>
								<td>ClinicalExamWeight_kgs</td>
								<td><form:input path="ClinicalExamWeight_kgs" /></td>
							</tr>

							<tr>
								<td>BloodGroup</td>
								<td><form:input path="BloodGroup" /></td>
							</tr>

							<tr>
								<td>ClinicalExamObservation</td>
								<td><form:input path="ClinicalExamObservation" /></td>
							</tr>

							<tr>
								<td>InvestigationResults</td>
								<td><form:input path="InvestigationResults" /></td>
							</tr>

							<tr>
								<td>ClinicalSummary</td>
								<td><form:input path="ClinicalSummary" /></td>
							</tr>
							<tr>
								<td>DiagnosisType</td>
								<td><form:input path="DiagnosisType" /></td>
							</tr>
							<tr>
								<td>DiagnosisCodeName</td>
								<td><form:input path="DiagnosisCodeName" /></td>
							</tr>
							<tr>
								<td>DiagnosisCode</td>
								<td><form:input path="DiagnosisCode" /></td>
							</tr>
							<tr>
								<td>DiagnosisDescription</td>
								<td><form:input path="DiagnosisDescription" /></td>
							</tr>
							<tr>
								<td>TreatmentPlanInvestigations</td>
								<td><form:input path="TreatmentPlanInvestigations" /></td>
							</tr>
							<tr>
								<td>TreatmentPlanMedication</td>
								<td><form:input path="TreatmentPlanMedication" /></td>
							</tr>
							<tr>
								<td>TreatmentPlanProcedure</td>
								<td><form:input path="TreatmentPlanProcedure" /></td>
							</tr>
							<tr>
								<td>TreatmentPlanReferral</td>
								<td><form:input path="TreatmentPlanReferral" /></td>
							</tr>
							<tr>
								<td>OtherTreatmentPlanType</td>
								<td><form:input path="OtherTreatmentPlanType" /></td>
							</tr>
							<tr>
								<td>OtherTreatmentPlanDetails</td>
								<td><form:input path="OtherTreatmentPlanDetails" /></td>
							</tr>

							<tr>
								<td>CurrentClinicalStatus</td>
								<td><form:input path="CurrentClinicalStatus" /></td>
							</tr>
							<tr>
								<td colspan="2"><input type="submit"
									value="SubmitmedicationDetails" /></td>
							</tr>

						</table>
					</form:form>
				</div>
			</div>
		</div>
	</div>
</template:page>