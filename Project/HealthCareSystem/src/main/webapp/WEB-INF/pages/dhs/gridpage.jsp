<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Department of Health Center Service</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">

	<div class="main-container container-fluid">
		<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
		<script>
			$("#Grid${level}").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				<div class="page-header position-relative">Grid ${level}</div>
				
				<table border=1>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Name</th>
							<th>Level</th>
							<th>Next Center </th>
							<th> Details </th>
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
								<td> <a href="${pageContext.request.contextPath}/dhs/healthcenter/${healthcenter.id}">Details</a>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</template:page>