<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: HC Admin Add Doctor Page</c:set>
<c:set var="action" scope="request">addDoctor</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="main-container container-fluid">
		<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
		<script>
			$("#addDoctor").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

				<c:choose>
					<c:when test="${not empty SUCCESS_MESSAGE}">
					${SUCCESS_MESSAGE}	</br>
						<a
							href="${pageContext.request.contextPath}/healthCenter/addDoctor">Add
							new other doctor</a>
					</c:when>
					<c:otherwise>
						<h2>Add Doctor</h2>
						<form:form method="post" action="addDoctor" commandName="userform">

							<table>

								<tr>
									<td>Doctor user Name</td>
									<td><form:input path="username" /></td>
								</tr>
								<tr>
									<td>password</td>
									<td><form:password path="password" /></td>
								</tr>
								<tr>
									<td>healthc center Id</td>
									<td><form:input path="healthcenterId" disabled="disabled" /></td>
								</tr>
								<tr>
									<td>Role</td>
									<td><form:input path="role" disabled="disabled" /></td>
								</tr>
								<tr>
									<td colspan="2"><input type="submit" value="add Doctor" /></td>
								</tr>
							</table>
						</form:form>
					</c:otherwise>
				</c:choose>
			</div>
		</div>
	</div>
</template:page>