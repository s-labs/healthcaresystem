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
				$("#HIS").addClass("active");
				$("#HIS").addClass("open");
				$("#hospitalisationHistory").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">
					<h2>Add Hospitalisation History</h2>
					<c:choose>

						<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

						</c:when>
						<c:otherwise>
							<form:form method="post" action="hospitalisationHistory"
								commandName="hospitalisationHistory" id="myform">

								<table>

									<tr>
										<td>Patient</td>
										<td><form:select path="patient" required="required">
												<form:option value="" label="-- Choose one--" />
												<form:options items="${patients}" itemValue="uhid"
													itemLabel="fullName" />
											</form:select></td>
									</tr>

									<tr>
										<td>care provider name</td>
										<td><form:input path="care_provider_name" required="required"/></td>
									</tr>

									<tr>
										<td>care provider add line1</td>
										<td><form:input path="care_provider_add_line1" required="required" /></td>
									</tr>

									<tr>
										<td>care provider add line2</td>
										<td><form:input path="care_provider_add_line2" required="required"/></td>
									</tr>

									<tr>
										<td>care provider city</td>
										<td><form:input path="care_provider_city" required="required"/></td>
									</tr>

									<tr>
										<td>care provider mandal</td>
										<td><form:input path="care_provider_mandal" required="required"/></td>
									</tr>

									<tr>
										<td>care provider district</td>
										<td><form:input path="care_provider_district" required="required"/></td>
									</tr>

									<tr>
										<td>care provider state</td>
										<td><form:input path="care_provider_state" required="required"/></td>
									</tr>

									<tr>
										<td>care provider pin num</td>
										<td><form:input path="care_provider_pin_num" required="required"/></td>
									</tr>

									<tr>
										<td>care provider phone num</td>
										<td><form:input path="care_provider_phone_num" required="required"/></td>
									</tr>

									<tr>
										<td>care provider email</td>
										<td><form:input path="care_provider_email" required="required" /></td>
									</tr>


									<tr>
										<td>insurance_status</td>
										<td><form:input path="insurance_status" required="required"/></td>
									</tr>

									<tr>
										<td>insurance_id</td>
										<td><form:input path="insurance_id" required="required"/></td>
									</tr>

									<tr>
										<td>episode_type</td>
										<td><form:input path="episode_type" required="required"/></td>
									</tr>

									<tr>
										<td>episode num</td>
										<td><form:input path="episode_num" required="required"/></td>
									</tr>

									<tr>
										<td>encounter type</td>
										<td><form:input path="encounter_type" required="required" /></td>
									</tr>

									<tr>
										<td>encounter num</td>
										<td><form:input path="encounter_num" required="required"/></td>
									</tr>

									<tr>
										<td>encounter_date_time</td>
										<td><form:input path="encounter_date_time" required="required" id="datepicker"/></td>
									</tr>

									<tr>
										<td colspan="2"><input type="submit"
											value="hospitalisationHistory" /></td>
									</tr>

								</table>
							</form:form>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
</template:page>