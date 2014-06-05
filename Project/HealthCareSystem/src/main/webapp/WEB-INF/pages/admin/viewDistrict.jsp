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
			jQuery("#state").change(function(event) {
				var stateValue = $(this).val();
				url = "districtsUnderState?statecode=" + stateValue;
				jQuery.ajax({
					url : "districtsUnderState?statecode=" + stateValue,
					success : function(result) {

						jQuery("#districts").html(result);
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
			$("#viewDistrict").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

									<table>

							<tr>

								<td>Select State</td>
								<td><div id="statesdropdown">
										<select name="state" id="state">

											<c:forEach var="state" items="${states}" varStatus="status">
												<option value="${state.code}">${state.name}</option>
											</c:forEach>
										</select>
									</div></td>
							</tr>

						</table>
						<hr>
						<h1>Districts will be populated here</h1>
						<div id="districts"></div>

				
				<input type="button" value="Back"
					onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>

</template:page>