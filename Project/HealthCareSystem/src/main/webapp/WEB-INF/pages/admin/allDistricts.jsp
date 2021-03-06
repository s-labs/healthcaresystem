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
			$("#allDistricts").addClass("active");
			</script>
		<div class="main-content">
			<div class="page-content">

				<table>
					<thead>
						<tr>
							<th>S.No</th>
							<th>Code</th>
							<th>Name</th>
							<th>State Code</th>
							<th>Detail</th>
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

			</div>
		</div>
	</div>

</template:page>