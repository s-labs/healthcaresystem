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
			$("#tng").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">


				<h2>Move to Next grid</h2>
				<form method="post" action="tng" class="form-horizontal">
					<div class="controls">
					<label>
						<input type="radio" name="tng" value="move"><span class="lbl"> Move to next grid  </span>
						</label>
						<label>
						<input type="radio" name="tng" value="cancel" /> <span class="lbl"> Continue
						to the current grid </span></label>
					</div>
					<input type="submit" value="update" />
				</form>
			</div>
		</div>
	</div>
</template:page>