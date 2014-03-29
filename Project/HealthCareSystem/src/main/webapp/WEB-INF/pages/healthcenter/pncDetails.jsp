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
				$("#pncDetails").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">


					<form:form method="post" action="pncDetails"
						commandName="pncDetails">

						<table>
							uhid : ${pncDetails.patient.uhid}
							<form:input path="patient" value="${pncDetails.patient.uhid}" />
							<tr>
								<td>PNCHomevisit</td>
								<td><form:input path="PNCHomevisit" /></td>
							</tr>

							<tr>
								<td>PNCComplications</td>
								<td><form:input path="PNCComplications" /></td>
							</tr>

							<tr>
								<td>POST_PARTUM_CONTRACEPTION_METHOD</td>
								<td><form:input path="POST_PARTUM_CONTRACEPTION_METHOD" /></td>
							</tr>

							<tr>
								<td>PNCCheckup</td>
								<td><form:input path="PNCCheckup" /></td>
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