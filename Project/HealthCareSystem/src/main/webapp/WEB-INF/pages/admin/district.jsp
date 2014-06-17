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
			$("#viewDistrict").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">
				District Code : ${district.code } <br /> District Name :
				${district.name } <br /> State Name : ${district.state.name}

				<c:choose>
					<c:when test="${empty district.healthCenter }">
						<h2>Set the healthcenter</h2>
						<form
							action="${pageContext.request.contextPath}/admin/associateHealthCenter"
							method="post">
							<input type="hidden" name="level" value="district" /> <input
								type="hidden" name="associateto" value="${district.code}" /> <select
								name="healthcenterid">

								<c:forEach items="${healthcenters}" var="healthcenter">
								${healthcenter.name}
									<option value="${healthcenter.id}">${healthcenter.name}</option>
								</c:forEach>
							</select> <input type="submit">
						</form>
					</c:when>
					<c:otherwise>
						<br /> HealthCenter Name : ${district.healthCenter.name}
						<br/>
						<h1>Health Center users : </h1>
						<table class="table table-striped table-bordered table-hover">
						<th>username</th>
						<th>role</th>
						<c:forEach var="user" items="${district.healthCenter.users}"
							varStatus="status">
							<tr>
						<td>${user.username }</td>
						<td><c:forEach var="role" items="${user.roles}" varStatus="status">
						${role.authority} &nbsp; &nbsp;<br/>
						
						</c:forEach>
						</td></tr>
						
							</c:forEach>
							
							</table>
							<br/>
							<a href="${pageContext.request.contextPath}/admin/addHCAdmin/${district.healthCenter.id}">Add new Health center admin</a>
					</c:otherwise>
				</c:choose>

				<br />
				<h2>Mandals :</h2>
				<table>
					<thead>
						<tr>
							<th>S.No</th>
							<th />
							<th>Code</th>
							<th />
							<th>Name</th>
							<th />
							<th>District Code</th>
							<th />
						</tr>
					</thead>
					<tbody>

						<c:forEach var="mandal" items="${mandals}"
							varStatus="status">
							<tr>
								<td>${status.count}</td>
								<td />
								<td>${mandal.code }</td>
								<td />
								<td>${mandal.name }</td>
								<td />
								<td>${mandal.district.name}</td>
								<td />
							</tr>
						</c:forEach>
					</tbody>
				</table>
				
				
			</div>
		</div>
	</div>

</template:page>