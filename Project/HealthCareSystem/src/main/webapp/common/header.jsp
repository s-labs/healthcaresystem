<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Health Care System</title>
</head>
<body>
<div >
<div class="headtitle" style="width:500px;float:left">
<center> <h2> Health care System </h2> </center>
</div>
<div class="logoutSection" style="float:left">
<sec:authorize ifAnyGranted="ROLE_USER">
		
		<td>Hello, ${username} <a href="<c:url value="/j_spring_security_logout"/>">1Logout</a>
		</td>
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_USER">
		<td><a href=" <c:url value="/login.htm"/>">Login</a>
		</td>
	</sec:authorize>
</div>


</div>
<div class="clear"/>
</body>
</html>