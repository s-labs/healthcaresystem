<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<div class="btn-toolbar">
	<div class="btn-group">
		<button class="btn  disabled" data-toggle="dropdown">G1</button>
		<button class="btn  disabled" data-toggle="dropdown">G2</button>
		<button class="btn  disabled" data-toggle="dropdown">G3</button>
		<button class="btn btn-primary disabled" data-toggle="dropdown">
			G4 <span class="caret"></span>
		</button>
	</div>
</div>
<sec:authorize ifAnyGranted="ROLE_HC_ADMIN">
Role : HC Admin
	<p>
		<a class="btn" href="addDoctor">Add Doctor</a>
		
		<c:if test="${action=='addDoctor' }"> >> </c:if>
	</p>
	<p>
		<a class="btn" href="addClerk">Add Clerk</a>
		<c:if test="${action=='addClerk' }"> >> </c:if>
	</p>
	<p>
		<a class="btn" href="#">Hospital info</a>
	</p>

</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_CLERK">
Role : Clerk
	<p>
		<a class="btn" href="his">HIS</a>
	</p>
	<p>
		<a class="btn" href="pis">PIS</a>
	</p>
	<p>
		<a class="btn" href="mis">MIS</a>
	</p>
	<p>
		<a class="btn" href="tng">TNG</a>
	</p>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_DOCTOR">
Role : Doctor
	<p>
		<a class="btn" href="his">HIS</a>
	</p>
	<p>
		<a class="btn" href="pis">PIS</a>
	</p>
	<p>
		<a class="btn" href="mis">MIS</a>
	</p>
	<p>
		<a class="btn" href="tng">TNG</a>
	</p>
</sec:authorize>
