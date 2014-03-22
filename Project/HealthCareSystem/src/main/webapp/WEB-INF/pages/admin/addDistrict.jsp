<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="main-container container-fluid">
		<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		<div class="main-content">
			<div class="page-content">

				<table>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Code</th>
							<th>Name</th>
							<th>State Code</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="district" items="${districts}" varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td>${district.code }</td>
								<td>${district.name }</td>
								<td>${district.state.name}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

				<form:form method="post" action="addDistrict"
					commandName="districtform">

					<table>

						<tr>
							<td>District Name</td>
							<td><form:input path="district.name" /></td>


							<td>State Code</td>
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
			</div>
		</div>
	</div>

</template:page>