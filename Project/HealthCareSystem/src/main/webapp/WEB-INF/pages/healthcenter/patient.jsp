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
			<table>
				<tr>
					<td>UHID : ${patient.uhid }</td>
				</tr>
				<tr>
					<td>First Name : ${patient.firstName }</td>
				</tr>
				<tr>
					<td>Last Name : ${patient.lastName }</td>
				</tr>
			</table>
		</div>
	</div>
</template:page>