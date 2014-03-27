<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
			$("#MIS").addClass("active");
			$("#MIS").addClass("open");
			$("#medicationDetails").addClass("active");
		</script>
			<div class="main-content">
				<div class="page-content">


					<form:form method="post" action="medicationDetails"
						commandName="medicationDetails">

						<table>
							uhid : ${medicalHistory.patient.uhid}
							<form:input path="patient" value="${medicalHistory.patient.uhid}" />
							<tr>
								<td>medication_name</td>
								<td><form:input path="medication_name" /></td>
							</tr>

							<tr>
								<td>drug_code</td>
								<td><form:input path="drug_code" /></td>
							</tr>

							<tr>
								<td>strength</td>
								<td><form:input path="strength" /></td>
							</tr>

							<tr>
								<td>dose</td>
								<td><form:input path="dose" /></td>
							</tr>

							<tr>
								<td>route</td>
								<td><form:input path="route" /></td>
							</tr>

							<tr>
								<td>frequency</td>
								<td><form:input path="frequency" /></td>
							</tr>

							<tr>
								<td>from_date</td>
								<td><form:input path="from_date" /></td>
							</tr>

							<tr>
								<td>to_date</td>
								<td><form:input path="to_date" /></td>
							</tr>

							<tr>
								<td>next_check_up</td>
								<td><form:input path="next_check_up" /></td>
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
</template:page>