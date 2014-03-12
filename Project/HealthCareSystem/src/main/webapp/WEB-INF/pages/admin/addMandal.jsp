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
			<h3>List Of Mandals......</h3>
			<table border="1">
				<thead>
					<tr>
						<th>S.No</th><th/>
						<th>Code</th><th/>
						<th>Name</th><th/>
						 <th>District Code</th><th/>
					</tr>
				</thead>
				<tbody>
					
					<c:forEach var="mandal" items="${mandals}" varStatus="status">
						<tr>
							<td>${status.count}</td><td/>
							<td>${mandal.code }</td><td/>
							<td>${mandal.name }</td><td/>
							<td>${mandal.districtCode}</td><td/>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<br/>

			<form:form method="post" action="addMandal" commandName="mandal">

				<table>

					<td>Select District</td>
						<td><form:select path="districtCode" >
						
						<c:forEach var="district" items="${districts}" varStatus="status">
						
							<form:option value="${district.code}">${district.name}</form:option>
					</c:forEach>
						</form:select>
						</td>
					
					<tr>
						<td>Mandal Name</td>
						<td><form:input path="name" />
						</td>	
					
						
					</tr>
					
				
					<tr>
						<td><td colspan="2"><input type="submit" value="add Mandal" /></td></td>
					</tr>
				</table>
			</form:form>
		</div>
	</div>
</template:page>