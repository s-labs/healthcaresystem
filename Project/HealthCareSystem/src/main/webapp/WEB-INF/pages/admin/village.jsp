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
				Village Code : ${village.code } <br /> Village Name :
				${village.name } <br /> Mandal Name : ${village.mandal.name}

				<c:choose>
					<c:when test="${empty village.healthCenter }">
						<h2>Set the healthcenter</h2>
						<form
							action="${pageContext.request.contextPath}/admin/associateHealthCenter"
							method="post">
							<input type="hidden" name="level" value="village" /> <input
								type="hidden" name="associateto" value="${village.code}" /> <select
								name="healthcenterid">

								<c:forEach items="${healthcenters}" var="healthcenter">
								${healthcenter.name}
									<option value="${healthcenter.id}">${healthcenter.name}</option>
								</c:forEach>
							</select> <input type="submit">
						</form>
					</c:when>
					<c:otherwise>
						<br /> HealthCenter Name : ${village.healthCenter.name}
					</c:otherwise>
				</c:choose>

				
				
			</div>
		</div>
	</div>

</template:page>