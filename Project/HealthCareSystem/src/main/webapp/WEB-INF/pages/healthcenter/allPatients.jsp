<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Patient Master Index</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="main-container container-fluid">
		<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
		<script>
			$("#PIS").addClass("active");
			$("#PIS").addClass("open");
			$("#allPatients").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content"></div>
			<table id="sample-table-1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>

						<th>S.No</th>
						<th>UHID</th>
						<th>Last Name</th>
						<th class="hidden-480">Details</th>
						<th class="hidden-480">Switch</th>
					</tr>
				</thead>
				<c:forEach var="patient" items="${patients}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${patient.uhid}</td>
						<td>${patient.lastName}</td>
						<td><a
							href="${pageContext.request.contextPath}/healthCenter/patient/${patient.uhid}">details
						</a></td>
						<td><a
							href="${pageContext.request.contextPath}/healthCenter/switchTopatient/${patient.uhid}">switch
								to this patient </a></td>
				</c:forEach>
			</table>
		</div>
	</div>
</template:page>