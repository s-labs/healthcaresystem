<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
			$("#HIS").addClass("active");
			$("#HIS").addClass("open");
			$("#hospitalisationHistory").addClass("active");
		</script>
			<div class="main-content">
				<div class="page-content">
			

			<form:form method="post" action="hospitalisationHistory" commandName="hospitalisationHistory">

				<table>
				
				<tr>
						<td>Patient</td>
						<td><form:select path="patient">
									<form:option value="" label="-- Choose one--" />
									<form:options items="${patients}" itemValue="uhid"
										itemLabel="fullName" />
								</form:select></td>
					</tr>

					<tr>
						<td>care_provider_name</td>
						<td><form:input path="care_provider_name" /></td>
					</tr>
					
					<tr>
						<td>care_provider_add_line1</td>
						<td><form:input path="care_provider_add_line1" /></td>
					</tr>
					
					<tr>
						<td>care_provider_add_line2</td>
						<td><form:input path="care_provider_add_line2" /></td>
					</tr>
					
					<tr>
						<td>care_provider_city</td>
						<td><form:input path="care_provider_city" /></td>
					</tr>
					
					<tr>
						<td>care_provider_mandal</td>
						<td><form:input path="care_provider_mandal" /></td>
					</tr>
					
					<tr>
						<td>care_provider_district</td>
						<td><form:input path="care_provider_district" /></td>
					</tr>
					
					<tr>
						<td>care_provider_state</td>
						<td><form:input path="care_provider_state" /></td>
					</tr>
					
					<tr>
						<td>care_provider_pin_num</td>
						<td><form:input path="care_provider_pin_num" /></td>
					</tr>
					
					<tr>
						<td>care_provider_phone_num</td>
						<td><form:input path="care_provider_phone_num" /></td>
					</tr>
					
					<tr>
						<td>care_provider_email</td>
						<td><form:input path="care_provider_email" /></td>
					</tr>
					
					
					<tr>
						<td>insurance_status</td>
						<td><form:input path="insurance_status" /></td>
					</tr>
					
					<tr>
						<td>insurance_id</td>
						<td><form:input path="insurance_id" /></td>
					</tr>
					
					<tr>
						<td>episode_type</td>
						<td><form:input path="episode_type" /></td>
					</tr>
					
					<tr>
						<td>episode_num</td>
						<td><form:input path="episode_num" /></td>
					</tr>
					
					<tr>
						<td>encounter_type</td>
						<td><form:input path="encounter_type" /></td>
					</tr>
					
					<tr>
						<td>encounter_num</td>
						<td><form:input path="encounter_num" /></td>
					</tr>
					
					<tr>
						<td>encounter_date_time</td>
						<td><form:input path="encounter_date_time" /></td>
					</tr>
					
					<tr>
						<td colspan="2"><input type="submit" value="hospitalisationHistory" />
						</td>
					</tr>
					
				</table>
			</form:form>
			</div>
		</div>
	</div>
</template:page>