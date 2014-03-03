
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div class="header">
<div class="headtitle">
<center> <h2> Health care System </h2> </center>
</div>
<div class="logoutSection" >
<sec:authorize ifAnyGranted="ROLE_USER">
		
		<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>
		
	</sec:authorize>
	<sec:authorize ifNotGranted="ROLE_USER">
		<a href=" <c:url value="/login.htm"/>">Login</a>
		
	</sec:authorize>
</div>
</div>
