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
		<div class="main-content">
			<div class="page-content"></div>
			<table id="sample-table-1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>

						<th>Column</th>
						<th>Details</th>

					</tr>
				</thead>
				<tr>
					<td>UHID</td>
					<td>${patient.uhid }</td>
				</tr>
				<tr>
					<td>First Name</td>
					<td>${patient.firstName }</td>
				</tr>
				<tr>
					<td>Last Name</td>
					<td>${patient.lastName }</td>
				</tr>
			</table>

			Medical History :
			<table id="sample-table-1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>

						<th>Column</th>
						<th>Details</th>

					</tr>
				</thead>
				<c:forEach var="medicalhistory" items="${patient.medicalhistory}"
					varStatus="status">
					<tr> <td colspan="2"> This record ${status.count} </td></tr>
					<tr>
						<td>In patient</td>
						<td>${medicalhistory.ip}</td>
					</tr>
					<tr>
						<td>Out patient</td>
						<td>${medicalhistory.op}</td>
					</tr>

				</c:forEach>
			</table>
		</div>
	</div>
</template:page>