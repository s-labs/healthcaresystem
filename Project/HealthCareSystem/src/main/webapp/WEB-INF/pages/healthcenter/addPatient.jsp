<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">
		
		<div class="leftSection">
			<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
		</div>
		<div class="rightSection">
<table>
				<thead>
					<tr>
						<th>S.No</th>
						
						<th>Last Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="patient" items="${patients}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							
							<td>${patient.lastName}</td>
					</c:forEach>
				</tbody>
			</table>
			

			<form:form method="post" action="addPatient" commandName="patient">

				<table>

					<tr>
						<td>last Name</td>
						<td><form:input path="lastname" /></td>
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="add Patient" />
						</td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</template:page>