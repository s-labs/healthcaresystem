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
	<script type="text/javascript" language="javascript">
		jQuery(document).ready(function() {
			jQuery("#district").change(function(event) {
				var districtValue = $(this).val();
				url = "districtHealthCenterCode?districtcode=" + districtValue;
				jQuery.ajax({
					url : "districtHealthCenterCode?districtcode=" + districtValue,
					success : function(result) {

						jQuery("#nextHealthCenter").html(result);
					}
				});

			});

		});
	</script>
	<div class="main-container container-fluid">
		<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		<script>
			$("#addMandal").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

				<c:choose>

					<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

					</c:when>
					<c:otherwise>
						<h2>Add new Mandal</h2>
						<form:form method="post" action="addMandal" commandName="mandal">

							<table>
								<tr>
									<td>Select District</td>
									<td><form:select path="district" id="district">

											<c:forEach var="district" items="${districts}"
												varStatus="status">

												<form:option value="${district.code}">${district.name}</form:option>
											</c:forEach>
										</form:select></td>
								</tr>
								<tr>
									<td>Mandal Name</td>
									<td><form:input path="name" /></td>
								</tr>
							</table>
							<hr>
							<table>
								<tr>
									<td colspan="2">
										<h1>Health center details</h1>
									</td>
								</tr>
								<tr>
									<td>HealthCenter Name</td>
									<td><input name="healthcenterName" /></td>
								</tr>

								<tr>
									<td>Level</td>
									<td><select name="healthcenterlevel">
											<option value="5">Village Sub Center</option>
											<option value="4">Primary Health Center</option>
									</select></td>
								</tr>
								<tr>
									<td>Next Level Health center</td>
									<td><b> <span id="nextHealthCenter"></span>
									</b>
								</tr>

								<tr>
								<tr>
									<td>
									<td colspan="2"><input type="submit" value="add Mandal" /></td>
									</td>
								</tr>
							</table>
						</form:form>
					</c:otherwise>
				</c:choose>
				<input type="button" value="Back"
					onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>
</template:page>