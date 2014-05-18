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
			<input type="button" value="Back" onclick="javascript:history.go(-1)">
				<table border=1>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Code</th>
							<th>Name</th>
							<th>State Code</th>
							<th>Details</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="district" items="${districts}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${district.code }</td>
								<td>${district.name }</td>
								<td>${district.state.name}</td>
								<td><a href="district/${district.code}">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h2>Add District</h2>
				<form:form method="post" action="addDistrict"
					commandName="districtform">

					<table>

						<tr>
							<td>District Name : </td>
							<td><form:input path="district.name" /></td>

						</tr>
						<tr>
							<td>State : </td>
							<td><select name="stateId">

									<c:forEach var="state" items="${states}" varStatus="status">

										<option value="${state.code}">${state.name}
									</c:forEach>
							</select></td>
						</tr>

						</tr>
						<tr>
							<td colspan="2"><input type="submit" value="add District" /></td>
						</tr>
					</table>
				</form:form>
				<input type="button" value="Back" onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>

</template:page>