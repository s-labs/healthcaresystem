<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="title">Health care System :: Admin Home Page</c:set>
 <template:page pageTitle="${pageTitle}" bodyCss="home"> 
	<div class="content">

		<div class="leftSection">
			<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		</div>
		<div class="rightSection">

			<table>
				<thead>
					<tr>
						<th>S.No</th>
						<th>Code</th>
						<th>Name</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="district" items="${districts}" varStatus="status">
						<tr>
							<td>${status.count}</td>
							<td>${district.code }</td>
							<td>${district.name }</td>
							<td>${district.stateCode}</td>
					</c:forEach>
				</tbody>
			</table>

			<form:form method="post" action="addDistrict" commandName="district">

				<table>

					<tr>
						<td>District Name</td>
						<td><form:input path="name" />
						</td>
						
					
						<td>State Code</td>
						<td><form:select path="stateCode" >
						
						<c:forEach var="state" items="${states}" varStatus="status">
						
							<form:option value="${state.code}">${state.name}</form:option>
					</c:forEach>
						</form:select>
						</td>
					</tr>
					
					</tr>
					<tr>
						<td colspan="2"><input type="submit" value="add District" /></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</template:page>