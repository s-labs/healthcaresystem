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
			$("#disease").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">


				<form:form method="post" action="disease"
					commandName="disease">

					<table>
						
						<tr>
							<td>diseaseName</td>
							<td><form:input path="diseaseName" /></td>
						</tr>

						<tr>
							<td>diseaseDescription</td>
							<td><form:input path="diseaseDescription" /></td>
						</tr>

						
						<tr>
							<td colspan="2"><input type="submit"
								value="Add Disease Information" /></td>
						</tr>

					</table>
				</form:form>
			</div>
		</div>
	</div>
</template:page>