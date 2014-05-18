<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Surgical History</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#MIS").addClass("active");
				$("#MIS").addClass("open");
				$("#pregnancyOutcome").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">

					<h2>Pregnancy outcome</h2>
					<c:choose>
						<c:when test="${choosepatient}">
							choose the patient from PIS then add details
						</c:when>
						<c:otherwise>
							<form:form method="post" action="pregnancyOutcome"
								commandName="pregnancyOutcome">

								<table>
									uhid : ${pregnancyOutcome.patient.uhid}
									<form:input path="patient"
										value="${pregnancyOutcome.patient.uhid}" />
									<tr>
										<td>PlaceofDelivery</td>
										<td><form:input path="PlaceofDelivery" /></td>
									</tr>

									<tr>
										<td>DeliveryType</td>
										<td><form:input path="DeliveryType" /></td>
									</tr>

									<tr>
										<td>complications</td>
										<td><form:input path="complications" /></td>
									</tr>

									<tr>
										<td>DateofDelivery</td>
										<td><form:input path="DateofDelivery" /></td>
									</tr>

									<tr>
										<td>DateofDischarge</td>
										<td><form:input path="DateofDischarge" /></td>
									</tr>

									<tr>
										<td>abortion</td>
										<td><form:input path="abortion" /></td>
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