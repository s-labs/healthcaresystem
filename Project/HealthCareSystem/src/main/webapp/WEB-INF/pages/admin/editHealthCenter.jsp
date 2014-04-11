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
				<h2>List of Health centers </h2>
				<table border=1>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>Level</th>
							<th>Next Center </th>
							<th> Edit </th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="healthcenter" items="${healthcenters}"
							varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${healthcenter.name }</td>
								<td>${healthcenter.level }</td>
								<td>${healthcenter.next.name }</td>
								<td> <a href="${pageContext.request.contextPath}/admin/editHealthCenter/${healthcenter.id}">Edit</a>
						</c:forEach>
					</tbody>
				</table>
				
				<h2> Add New Health center </h2>

				<form:form method="post" action="${pageContext.request.contextPath}/admin/editHealthCenter/"
					commandName="healthcenterform">

					<table>
					
					<tr>
							<td>id</td>
							<td><form:input path="healthcenter.id" /></td>
						</tr>

						<tr>
							<td>Health Center Name</td>
							<td><form:input path="healthcenter.name" /></td>
						</tr>
						<tr>
							<td>level</td>
							<td><form:input path="healthcenter.level" /></td>
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
							<td colspan="2"><input type="submit" value="add Health Center" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</template:page>