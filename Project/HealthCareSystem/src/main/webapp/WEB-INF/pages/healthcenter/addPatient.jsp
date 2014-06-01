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
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#addPatient").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">
					
					<h2>Add Patient</h2>
					<c:choose>

						<c:when test="${not empty SUCCESS_MESSAGE}">
								${SUCCESS_MESSAGE}	</br>

						</c:when>
						<c:otherwise>

							<form:form method="post" action="addPatient"
								commandName="patient" id="addPatient" cssClass="form">

								<table>

									<tr>
										<td>last Name</td>
										<td><form:input path="lastName" required="required" /></td>
									</tr>

									<tr>
										<td>middl eName</td>
										<td><form:input path="middleName" /></td>
									</tr>

									<tr>
										<td>first Name</td>
										<td><form:input path="firstName" required="required" /></td>
									</tr>

									<tr>
										<td>Date of birth</td>
										<td><form:input path="dob" id="datepicker"/></td>
									</tr>

									<tr>
										<td>age</td>
										<td><form:input path="age" required="required"/></td>
									</tr>

									<tr>
										<td>gender</td>
										<td><form:input path="gender" required="required"/></td>
									</tr>

									<tr>
										<td>occupation</td>
										<td><form:input path="occupation"  required="required"/></td>
									</tr>

									<tr>
										<td>father/Husband Name</td>
										<td><form:input path="fatherHusbandName"  required="required"/></td>
									</tr>

									<tr>
										<td>mother Name</td>
										<td><form:input path="motherName"  required="required"/></td>
									</tr>

									<tr>
										<td>address Line1</td>
										<td><form:input path="addressLine1"  required="required" /></td>
									</tr>

									<tr>
										<td>address Line2</td>
										<td><form:input path="addressLine2"  required="required" /></td>
									</tr>

									<tr>
										<td>pinCode</td>
										<td><form:input path="pinCode" /></td>
									</tr>

									<tr>
										<td>city/Town/Village</td>
										<td><form:input path="cityTownVillage" /></td>
									</tr>

									<tr>
										<td>mandal</td>
										<td><form:input path="mandal" /></td>
									</tr>

									<tr>
										<td>district</td>
										<td><form:input path="district" /></td>
									</tr>

									<tr>
										<td>sate</td>
										<td><form:input path="sate" /></td>
									</tr>

									<tr>
										<td>email</td>
										<td><form:input path="email" /></td>
									</tr>

									<tr>
										<td>phone</td>
										<td><form:input path="phone" /></td>
									</tr>

									<tr>
										<td>emer Contact Person Name</td>
										<td><form:input path="emerContactPerName" /></td>
									</tr>

									<tr>
										<td>emergency Contact Person Relationship</td>
										<td><form:input path="emerContactPerRelationship" /></td>
									</tr>

									<tr>
										<td>emergency Contact Person Address Line1</td>
										<td><form:input path="emerContactPerAddressLine1" /></td>
									</tr>

									<tr>
										<td>Emergency Contact Person AddressLine2</td>
										<td><form:input path="emerContactPerAddressLine2" /></td>
									</tr>

									<tr>
										<td>Emergency Contact Person Pincode<td><form:input path="emerContactPerPinCode" /></td>
									</tr>
					
					<tr>
						<td>Emergency Contact Person Cit</td>
										
						
										<td><form:input path="emerContactPerCit" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person Mandal</td>
						<td><form:input path="emerContactPerMandal" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person District</td>
						<td><form:input path="emerContactPerDistrict" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person State</td>
						<td><form:input path="emerContactPerState" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person Phone</td>
						<td><form:input path="emerContactPerPhone" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person PhoneNumber</td>
						<td><form:input path="emerContactPerPhoneNumber" /></td>
					</tr>
					
					<tr>
						<td>Emergency Contact Person Email</td>
						<td><form:input path="emerContactPerEmail" /></td>
					</tr>
					
					
					<tr>
						<td></td>
										<td colspan="2"><input type="submit" value="add Patient" />
						</td>
					</tr>
					
				</table>
			</form:form>
			</c:otherwise>
			</c:choose>
		</div>
		</div>
	</div>

</template:page>