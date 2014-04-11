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
			$("#addVillage").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<h2>List of All Villages</h2>
				<table>
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
						<c:forEach var="village" items="${villages}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${village.code }</td>
								<td>${village.name }</td>
								<td>${village.mandal.name}</td>
								<td><a href="village/${village.code}">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<h2>Add New Village</h2>
				<form:form method="post" action="addVillage" commandName="village">

					<table>

						<tr>
							<td>Village Name</td>
							<td><form:input path="name" /></td>
						</tr>
						<tr>
							<td>Select Mandal</td>
							<td><form:select path="mandal">

									<c:forEach var="mandal" items="${mandals}" varStatus="status">

										<form:option value="${mandal.code}">${mandal.name}</form:option>
									</c:forEach>
								</form:select></td>
						</tr>
						<tr>
							<td>Distance_0_5_KMS</td>
							<td><form:input path="Distance_0_5_KMS" />false-No , true-
								Yes</td>
						</tr>
						<tr>
							<td>Distance_5_10_KMS</td>
							<td><form:input path="Distance_5_10_KMS" />false-No , true-
								Yes</td>
						</tr>

						<tr>
							<td>Distance_More_Than10_KMS</td>
							<td><form:input path="Distance_More_Than10_KMS" />false-No
								, true- Yes</td>
						</tr>

						<tr>
							<td colspan="2"><input type="submit" value="add Village" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>

</template:page>