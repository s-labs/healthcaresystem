<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="pageTitle">A grid based indian rural healthcare system :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<%-- <div class="leftSection">
	<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
	</div> --%>
	<div class="right">
	this is transferNextGrid.jsp(MIS) page<br/>
	<center> <h1>Transfer Grid Level</h1> 
	<form action="#" enctype=text/html>
			<div class="controls">
						<label>
							<input name="form-field-radio" type="radio" name="current" value="current"/>
								<span class="lbl"> Continue to current grid</span>
									</label>
					
			</div>
			<div class="controls">
						<label>
							<input name="form-field-radio" type="radio" name="current" value="current"/>
								<span class="lbl"> Move to next grid</span>
									</label>
					
			</div>
		<input type="submit" value="Submit">
	</form>
	</center>
	</div>
</template:page>



