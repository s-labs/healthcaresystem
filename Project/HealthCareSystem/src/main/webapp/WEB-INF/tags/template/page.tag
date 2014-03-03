<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ taglib prefix="header" tagdir="/WEB-INF/tags/common/header" %>
<%@ taglib prefix="footer" tagdir="/WEB-INF/tags/common/footer" %>

<%@ attribute name="pageTitle" required="false"  %>

<%@ attribute name="bodyCss" required="false" type="java.lang.String" %>

<template:master pageTitle="${pageTitle}">

	<jsp:body>
		
		<div class="${bodyCss}">
			
			<header:header/>
					
			<div>
				<div class="inner float-group">
					<jsp:doBody/>
				</div>
			</div>
						
			<footer:footer/>
		
		</div>
	
	</jsp:body>
	
</template:master>