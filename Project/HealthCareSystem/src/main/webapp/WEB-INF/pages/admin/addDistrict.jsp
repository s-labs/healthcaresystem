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
	<div class="main-container container-fluid">
		<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		<script>
			$("#addDistrict").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<c:choose>

					<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

					</c:when>
					<c:otherwise>

						<h2>Add District</h2>
						<form:form method="post" action="addDistrict"
							commandName="districtform">

							<table>

								<tr>
									<td>District Name :</td>
									<td><form:input path="district.name" /></td>

								</tr>
								<tr>
									<td>State :</td>
									<td><select name="stateId">

											<c:forEach var="state" items="${states}" varStatus="status">

												<option value="${state.code}">${state.name}
											</c:forEach>
									</select></td>
								</tr>
							</table>
							<hr>
							<table>
								<tr>
									<td colspan="2">
										<h1>Health center details</h1>
									</td>
								</tr>
								<tr>
									<td>HealthCenter Name</td>
									<td><input name="healthcenterName" /></td>
								</tr>

								<tr>
									<td>Level</td>
									<td><select name="healthcenterlevel">
											<option value="5">Village Sub Center</option>
											<option value="4">Primary Health Center</option>
									</select></td>
								</tr>
								<tr>
									<td>Next Level Health center</td>
									<td><b> <select name="nexthealthcenterid">
												<c:forEach var="healthcenter" items="${nextHealthCenters}"
													varStatus="status">

													<option value="${healthcenter.id}">${healthcenter.name}</option>
												</c:forEach>
										</select>
									</b>
								</tr>

								<tr>

								</tr>


								<tr>
									<td colspan="2"><input type="submit" value="add District" /></td>
								</tr>
							</table>
						</form:form>
					</c:otherwise>
				</c:choose>
				<input type="button" value="Back"
					onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>

</template:page>