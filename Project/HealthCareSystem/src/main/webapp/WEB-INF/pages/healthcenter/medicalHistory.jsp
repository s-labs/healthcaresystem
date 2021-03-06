<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Medical History Page</c:set>
<c:set var="action" scope="request">medicalhistory</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">

	<div class="main-container container-fluid">
		<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
		<script>
			$("#MIS").addClass("active");
			$("#MIS").addClass("open");
			$("#medicalhistory").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

				<h2>Medical History</h2>
				<c:choose>
					<c:when test="${choosepatient}">
							choose the patient from PIS then add details
						</c:when>
						<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>
						
					</c:when>
					<c:otherwise>
						<form:form method="post" action="medicalHistory"
							commandName="medicalHistory">

							<table>
								
								
									<tr>
										<td>uhid</td>
										<td>${medicalHistory.patient.uhid}</td>
									</tr>
									<tr>
										<td>Name</td>
										<td>${medicalHistory.patient.firstName} ${medicalHistory.patient.lastName}</td>
									</tr>
									
								<tr>
									<td>ip</td>
									<td><form:input path="ip" /></td>
								</tr>

								<tr>
									<td>op</td>
									<td><form:input path="op" /></td>
								</tr>

								<tr>
									<td>acc_patient</td>
									<td><form:input path="accPatient" /></td>
								</tr>

								<tr>
									<td>reason_for_visit</td>
									<td><form:input path="reasonForVisit" /></td>
								</tr>

								<tr>
									<td>present_history</td>
									<td><form:input path="presentHistory" /></td>
								</tr>

								<tr>
									<td>past_history</td>
									<td><form:input path="pastHistory" /></td>
								</tr>

								<tr>
									<td>personal_history</td>
									<td><form:input path="personalHistory" /></td>
								</tr>

								<tr>
									<td>family_history</td>
									<td><form:input path="familyHistory" /></td>
								</tr>

								<tr>
									<td>problem form</td>
									<td><form:input path="problemForm" /></td>
								</tr>

								<tr>
									<td>doctor name</td>
									<td><form:input path="doctorName" /></td>
								</tr>

								<tr>
									<td>notes</td>
									<td><form:input path="notes" /></td>
								</tr>

								<tr>
									<td>from date</td>
									<td><form:input path="fromDate" cssClass="datepicker"/></td>
								</tr>

								<tr>
									<td>to date</td>
									<td><form:input path="toDate" cssClass="datepicker"/></td>
								</tr>

								<tr>
									<td>progress</td>
									<td><form:input path="progress" /></td>
								</tr>

								<tr>
									<td>advice</td>
									<td><form:input path="advice" /></td>
								</tr>

								<tr>
									<td colspan="2"><input type="submit"
										value="SubmitMedicalHIstory" /></td>
								</tr>

							</table>
						</form:form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</template:page>