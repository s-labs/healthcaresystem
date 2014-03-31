<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Department of Health Center Service</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">

	<div class="main-container container-fluid">
		<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
		
		<c:set var="level" value="${healthcenter.level}"/>
		<script>
			$("#Grid${level}").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<div class="page-header position-relative">Grid ${level}</div>
				<h2> ${healthcenter.name}</h2>
				Users : 
				<table id="sample-table-1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>

						<th>S.No</th>
						<th>User Name</th>
						<th>Role</th>
						
					</tr>
				</thead>
				<c:forEach var="user" items="${healthcenter.users}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${user.username}</td>
						<td><c:forEach var="role" items="${user.roles}" varStatus="status">
						${role.authority} &nbsp; &nbsp;
						
						</c:forEach>
						</td>
						
				</c:forEach>
			</table>
			
			Patients :
			
			<table id="sample-table-1"
				class="table table-striped table-bordered table-hover">
				<thead>
					<tr>

						<th>S.No</th>
						<th>UHID</th>
						<th>Last Name</th>
						<th class="hidden-480">Details</th>
						<sec:authorize ifAnyGranted="ROLE_DOCTOR">
							<th class="hidden-480">Switch</th>
						</sec:authorize>
					</tr>
				</thead>
				<c:forEach var="patient" items="${healthcenter.patients}" varStatus="status">
					<tr>
						<td>${status.count}</td>
						<td>${patient.uhid}</td>
						<td>${patient.lastName}</td>
						<td><a
							href="${pageContext.request.contextPath}/dhs/patient/${patient.uhid}">details
						</a></td>
						
				</c:forEach>
			</table>
			</div>
		</div>
	</div>
</template:page>