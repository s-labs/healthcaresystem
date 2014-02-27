<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>fist page</title>
</head>
<body>
	<sec:authorize ifAnyGranted="ROLE_USER">
		
		<td><a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		</td>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_USER">
		<td><a href=" <c:url value="/login.htm"/>">Login</a>
		</td>
	</sec:authorize>

	<h1>Message111111 : ${message}</h1>
</body>
</html>