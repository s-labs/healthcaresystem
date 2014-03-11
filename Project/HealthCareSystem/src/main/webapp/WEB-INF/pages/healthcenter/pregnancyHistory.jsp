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
					

			<form:form method="post" action="pregnancyHistory" commandName="pregnancyHistory">

				<table>

					<tr>
						<td>lmp</td>
						<td><form:input path="lmp" /></td>
					</tr>
					
					<tr>
						<td>first_anc</td>
						<td><form:input path="first_anc" /></td>
					</tr>
					
					<tr>
						<td>second_anc</td>
						<td><form:input path="second_anc" /></td>
					</tr>
					
					<tr>
						<td>third_anc</td>
						<td><form:input path="third_anc" /></td>
					</tr>
					
					<tr>
						<td>fourth_anc</td>
						<td><form:input path="fourth_anc" /></td>
					</tr>
					
					<tr>
						<td>tt1</td>
						<td><form:input path="tt1" /></td>
					</tr>
					
					<tr>
						<td>tt2</td>
						<td><form:input path="tt2" /></td>
					</tr>
					
					<tr>
						<td>ttbooster</td>
						<td><form:input path="ttbooster" /></td>
					</tr>
					
					<tr>
						<td>complication</td>
						<td><form:input path="complication" /></td>
					</tr>
					
					<tr>
						<td>rti_sti</td>
						<td><form:input path="rti_sti" /></td>
					</tr>
					
					<tr>
						<td>ifa_tablets_given</td>
						<td><form:input path="ifa_tablets_given" /></td>
					</tr>
					
					<tr>
						<td>anaemia_hb_level</td>
						<td><form:input path="anaemia_hb_level" /></td>
					</tr>
						
					<tr>
						<td colspan="2"><input type="submit" value="pregnancyHistory" />
						</td>
					</tr>
					
				</table>
			</form:form>
		</div>
	</div>
</template:page>