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
			$("#addHealthCenter").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<c:choose>

					<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

					</c:when>
					<c:otherwise>
						<h2>Add New Health center</h2>

						<form:form method="post" action="addHealthCenter"
							commandName="healthcenterform">

							<table>

								<tr>
									<td>Health Center Name</td>
									<td><form:input path="healthcenter.name" /></td>
								</tr>
								<tr>
									<td>level</td>
									<td><form:select path="healthcenter.level" >
										<form:option value="5">Village Sub Center</form:option>
										<form:option value="4">Primary Health Center</form:option>
										<form:option value="3">Community Health Center</form:option>
										<form:option value="2">Area Hospital</form:option>
										<form:option value="1">District Head Quaters</form:option>
									</form:select></td>
								</tr>
								<tr>
									<td>Next HealthCenter</td>
									<td><select name="next">

											<c:forEach var="healthcenter" items="${healthcenters}"
												varStatus="status">

												<option value="${healthcenter.id}">${healthcenter.name}
											</c:forEach>
									</select></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit"
										value="add Health Center" /></td>
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