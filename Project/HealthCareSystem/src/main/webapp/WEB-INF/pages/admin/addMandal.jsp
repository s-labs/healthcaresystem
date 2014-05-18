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
			$("#addMandal").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<h2>List of All Mandals</h2>
				<table>
					<thead>
						<tr>
							<th>S.No</th>

							<th>Code</th>

							<th>Name</th>

							<th>District Code</th>

							<th>Details</th>

						</tr>
					</thead>
					<tbody>

						<c:forEach var="mandal" items="${mandals}" varStatus="status">
							<tr>
								<td>${status.count}</td>

								<td>${mandal.code }</td>

								<td>${mandal.name }</td>

								<td>${mandal.district.name}</td>

								<td><a href="mandal/${mandal.code}">Detail</a></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
				<br />
				<h2>Add new Mandal</h2>
				<form:form method="post" action="addMandal" commandName="mandal">

					<table>

						<td>Select District</td>
						<td><form:select path="district">

								<c:forEach var="district" items="${districts}"
									varStatus="status">

									<form:option value="${district.code}">${district.name}</form:option>
								</c:forEach>
							</form:select></td>

						<tr>
							<td>Mandal Name</td>
							<td><form:input path="name" /></td>


						</tr>


						<tr>
							<td>
							<td colspan="2"><input type="submit" value="add Mandal" /></td>
							</td>
						</tr>
					</table>
				</form:form>
				<input type="button" value="Back" onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>
</template:page>