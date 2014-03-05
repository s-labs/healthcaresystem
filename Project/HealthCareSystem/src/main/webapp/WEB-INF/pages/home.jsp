<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
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
	
	<sec:authorize ifAnyGranted="ROLE_ADMIN">
		
		your admin ... click here to go to admin home page <a href="admin/"> home page </a> <br/>
	</sec:authorize>
	<sec:authorize ifAnyGranted="ROLE_HEALTHCENTER">
		your healthcenter ... click here to go to healthcenter home page <a href="healthcenter/"> home page </a> <br/>
	</sec:authorize>
</body>
</html>