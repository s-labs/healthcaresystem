<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: infant Details</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#MIS").addClass("active");
				$("#MIS").addClass("open");
				$("#infantDetails").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">

					<h2>Infant details</h2>
					<c:choose>
						<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

						</c:when>
						<c:when test="${choosepatient}">
							choose the patient from PIS then add details
						</c:when>
						<c:otherwise>
							<form:form method="post" action="infantDetails"
								commandName="infantDetails">

								<table>


									<tr>
										<td>uhid</td>
										<td>${infantDetails.patient.uhid}</td>
									</tr>
									<tr>
										<td>Name</td>
										<td>${infantDetails.patient.firstName}
											${infantDetails.patient.lastName}</td>
									</tr>
									<tr>
										<td>OutcomeNumber</td>
										<td><form:input path="OutcomeNumber" /></td>
									</tr>

									<tr>
										<td>LastName</td>
										<td><form:input path="LastName" /></td>
									</tr>

									<tr>
										<td>MiddleName</td>
										<td><form:input path="MiddleName" /></td>
									</tr>

									<tr>
										<td>FirstName</td>
										<td><form:input path="FirstName" /></td>
									</tr>

									<tr>
										<td>Gender</td>
										<td><form:input path="Gender" /></td>
									</tr>
									<tr>
										<td>DateTimeofBirth</td>
										<td><form:input path="DateTimeofBirth"
												id="datetimepicker" /></td>
									</tr>
									<tr>
										<td>Weight</td>
										<td><form:input path="Weight" /></td>
									</tr>
									<tr>
										<td>Weight</td>
										<td><form:input path="Weight" /></td>
									</tr>
									<tr>
										<td>Initiated breast feeding within one hour</td>
										<td><form:select
												path="Initiatedbreastfeedingwithinonehour">
												<form:option value="1">Yes</form:option>
												<form:option value="0">No</form:option>

											</form:select></td>
									</tr>
									<tr>
										<td>Remarks</td>
										<td><form:input path="Remarks" /></td>
									</tr>

									<tr>
										<td colspan="2"><input type="submit"
											value="SubmitmedicationDetails" /></td>
									</tr>

								</table>
							</form:form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>
</template:page>