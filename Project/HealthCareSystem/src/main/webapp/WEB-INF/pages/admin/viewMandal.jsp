<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>



<c:set var="pageTitle">A grid based indian rural healthcare system :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<script type="text/javascript" language="javascript">
		jQuery(document).ready(function() {
			jQuery("#district").change(function(event) {
				var districtValue = $(this).val();
				url = "mandalsUnderDistrict?districtcode=" + districtValue;
				jQuery.ajax({
					url : "mandalsUnderDistrict?districtcode=" + districtValue,
					success : function(result) {

						jQuery("#mandals").html(result);
					}
				});

			});

		});

		function searchResults(results) {
			alert("search results");
		}
	</script>
	<div class="main-container container-fluid">
		<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		<script>
			$("#viewMandal").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

				<table>

					<tr>

						<td>Select district</td>
						<td><div id="statesdropdown">
								<select name="district" id="district">
									<option value="0">Select District</option>
									<c:forEach var="district" items="${districts}"
										varStatus="status">
										<option value="${district.code}">${district.name}</option>
									</c:forEach>
								</select>
							</div></td>
					</tr>

				</table>
				<hr>
				<h1>Mandals will be populated here</h1>
				<div id="mandals"></div>


				<input type="button" value="Back"
					onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>

</template:page>