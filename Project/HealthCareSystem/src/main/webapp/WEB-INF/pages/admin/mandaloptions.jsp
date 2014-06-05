<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<select name="mandal" id="mandal" onchange="onchangeMandal(this)">
<c:forEach var="mandal" items="${mandals}" varStatus="status">
	<option value="${mandal.code}">${mandal.name}</option>

</c:forEach>
</select>