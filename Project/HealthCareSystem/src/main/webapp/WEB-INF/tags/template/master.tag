<!DOCTYPE html>

<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>
<%@ attribute name="pageTitle" required="false" %>
<%@ attribute name="metaDescription" required="false" %>
<%@ attribute name="metaKeywords" required="false" %>
<%@ attribute name="pageCss" required="false" fragment="true" %>
<%@ attribute name="pageScripts" required="false" fragment="true" %>
<head>
<title>
			${not empty pageTitle ? pageTitle : 'set Title'}
		</title>
		
		<template:styleSheets />
		<template:javaScripts />
		
</head>
<body>
 <jsp:doBody/>
</body>
