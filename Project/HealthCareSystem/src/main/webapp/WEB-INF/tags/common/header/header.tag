
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>


<div class="navbar">
	<div class="navbar-inner">
		<div class="container-fluid">
			<a href="#" class="brand"> <small> <i class=""></i>Health
					care System
			</small></a>
			<ul class="nav ace-nav pull-right">
				<li class="light-blue"><sec:authorize ifAnyGranted="ROLE_USER">

						<a href="<c:url value="/j_spring_security_logout"/>">Logout</a>

					</sec:authorize> <sec:authorize ifNotGranted="ROLE_USER">
						<a href=" <c:url value="/login.htm"/>">Login</a>

					</sec:authorize></li>
			</ul>
		</div>
	</div>
</div>
