<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">
		
		<div class="leftSection">
			<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
		</div>
		<div class="rightSection">
			<table>
				<!-- <thead>
					<tr>
						<th>S.No</th>
						
						<th>Last Name</th>
					</tr>
				</thead> -->
				<tbody>
					<c:forEach var="patient" items="${patients}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							
							<td>${patient.lastName}</td>
					</c:forEach>
				</tbody>
			</table>
			

			<form:form method="post" action="addPatient" commandName="patient">

				<table>

					<tr>
						<td>last Name</td>
						<td><form:input path="lastName" /></td>
					</tr>
					
					<tr>
						<td>middl eName</td>
						<td><form:input path="middleName" /></td>
					</tr>
					
					<tr>
						<td>first Name</td>
						<td><form:input path="firstName" /></td>
					</tr>
					
					<tr>
						<td>dob</td>
						<td><form:input path="dob" /></td>
					</tr>
					
					<tr>
						<td>age</td>
						<td><form:input path="age" /></td>
					</tr>
					
					<tr>
						<td>gender</td>
						<td><form:input path="gender" /></td>
					</tr>
					
					<tr>
						<td>occupation</td>
						<td><form:input path="occupation" /></td>
					</tr>
					
					<tr>
						<td>father/Husband Name</td>
						<td><form:input path="fatherHusbandName" /></td>
					</tr>
					
					<tr>
						<td>mother Name</td>
						<td><form:input path="motherName" /></td>
					</tr>
					
					<tr>
						<td>address Line1</td>
						<td><form:input path="addressLine1" /></td>
					</tr>
					
					<tr>
						<td>address Line2</td>
						<td><form:input path="addressLine2" /></td>
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
						<td>emerContactPerName</td>
						<td><form:input path="emerContactPerName" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerRelationship</td>
						<td><form:input path="emerContactPerRelationship" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerAddressLine1</td>
						<td><form:input path="emerContactPerAddressLine1" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerAddressLine2</td>
						<td><form:input path="emerContactPerAddressLine2" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerPinCode</td>
						<td><form:input path="emerContactPerPinCode" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerCit</td>
						<td><form:input path="emerContactPerCit" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerMandal</td>
						<td><form:input path="emerContactPerMandal" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerDistrict</td>
						<td><form:input path="emerContactPerDistrict" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerState</td>
						<td><form:input path="emerContactPerState" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerPhone</td>
						<td><form:input path="emerContactPerPhone" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerPhoneNumber</td>
						<td><form:input path="emerContactPerPhoneNumber" /></td>
					</tr>
					
					<tr>
						<td>emerContactPerEmail</td>
						<td><form:input path="emerContactPerEmail" /></td>
					</tr>
					
					
					<tr>
						<td></td><td colspan="2"><input type="submit" value="add Patient" />
						</td>
					</tr>
					
				</table>
			</form:form>
		</div>
	</div>
</template:page>