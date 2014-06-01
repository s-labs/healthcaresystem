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
				$("#allergyHistory").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">

					<c:choose>
						<c:when test="${choosepatient}">
							choose the patient from PIS then add details
						</c:when>
						<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>
						
					</c:when>
						<c:otherwise>
							<form:form method="post" action="allergyHistory"
								commandName="allergyHistory">

								<table>

								<tr>
										<td>uhid</td>
										<td>${allergyHistory.patient.uhid}</td>
									</tr>
									<tr>
										<td>Name</td>
										<td>${allergyHistory.patient.firstName} ${allergyHistory.patient.lastName}</td>
									</tr>
									
									<tr>
										<td>allergicTO</td>
										<td><form:input path="allergicTO" /></td>
									</tr>

									<tr>
										<td>reactionDate</td>
										<td><form:input path="reactionDate" /></td>
									</tr>

									<tr>
										<td>reactionType</td>
										<td><form:input path="reactionType" /></td>
									</tr>

									<tr>
										<td>prescription</td>
										<td><form:input path="prescription" /></td>
									</tr>

									<tr>
										<td>notes</td>
										<td><form:input path="notes" /></td>
									</tr>

									<tr>
										<td>doctorName</td>
										<td><form:input path="doctorName" /></td>
									</tr>
									<tr>
										<td colspan="2"><input type="submit"
											value="submit allergy history" /></td>
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