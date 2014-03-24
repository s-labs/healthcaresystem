<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<sec:authorize ifAnyGranted="ROLE_ADMIN">

	<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
</sec:authorize>
<sec:authorize ifAnyGranted="ROLE_HEALTHCENTER">

	<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
</sec:authorize>