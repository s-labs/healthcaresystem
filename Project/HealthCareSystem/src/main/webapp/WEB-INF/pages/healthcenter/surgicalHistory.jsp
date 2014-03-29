<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Surgical History</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#MIS").addClass("active");
				$("#MIS").addClass("open");
				$("#surgicalHistory").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">


					<form:form method="post" action="surgicalHistory"
						commandName="surgicalHistory">

						<table>
							uhid : ${medicalHistory.patient.uhid}
							<form:input path="patient"
								value="${surgicalHistory.patient.uhid}" />
							<tr>
								<td>Surgery</td>
								<td><form:input path="Surgery" /></td>
							</tr>

							<tr>
								<td>SurgeryDate</td>
								<td><form:input path="SurgeryDate" /></td>
							</tr>

							<tr>
								<td>doctorName</td>
								<td><form:input path="doctorName" /></td>
							</tr>

							<tr>
								<td>PlaceofSurgery</td>
								<td><form:input path="PlaceofSurgery" /></td>
							</tr>

							<tr>
								<td>SurgeryProcedure</td>
								<td><form:input path="SurgeryProcedure" /></td>
							</tr>

							<tr>
								<td>Status</td>
								<td><form:input path="Status" /></td>
							</tr>

							<tr>
								<td>Notes</td>
								<td><form:input path="Notes" /></td>
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