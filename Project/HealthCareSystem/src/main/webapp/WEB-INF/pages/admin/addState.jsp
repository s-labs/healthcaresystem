<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div class="header">
	<jsp:include page="/common/header.jsp"></jsp:include>
</div>

<hr/>
<div class="content">

	<div class="left">
	<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
	</div>
	<div class="right">

<form:form method="post" action="add" commandName="state">
  
    <table>
    
    <tr>
        <td>State Name</td>
        <td><form:input path="name" /></td>
    </tr>
    <tr>
        <td colspan="2">
            <input type="submit" value="add State"/>
        </td>
    </tr>
</table>
</form:form>
</div>
</div>
</body>
</html>