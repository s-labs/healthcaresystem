<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<%-- <div class="leftSection">
	<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
	</div> --%>
	<div class="right">
	this is patientInfoSystem.jsp
	<center> <h1>Patient Information System</h1> 
	<form action="#">
	<table>
	<tr>
		<td>Patient Name</td>
		<td><input type="text" name="patientName"> </td><br/>
	</tr>
	
	<tr>
		<td>Patient id</td><td><input type="text" name="patientId"></td><br/>
	</tr>
		
	<tr>
		<td>Age</td>
		<td><input type="text" name="age"></td><br/>
	</tr>
	
	<tr>
		<td>Location</td>
		<td><input type="text" name="age"></td><br/>
	</tr>
	
	<tr>
		<td>Weight</td>
		<td><input type="text" name="weight"></td><br/>
	</tr>
	
	<tr>
		<td>Admit Date</td>
		<td><input type="text" name="admitDate"></td><br/>
	</tr>
	
	<td>
		</td><td>
		<input type="submit" value="AddPatientInfo" /></td>
	<tr>
	</table>
	</form>
	</center>
	</div>
	
	
	
</template:page>