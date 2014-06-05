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
				jQuery("#ajaxMessage").text("populating mandals ");
				var districtValue = $(this).val();
				url = "mandalsList.json?districtCode=" + districtValue;
				jQuery.ajax({
					url : "mandalsList.json?districtCode=" + districtValue,
					success : function(result) {

						jQuery("#mandalsdropdown").html(result);
						jQuery("#ajaxMessage").text(" mandals populated ");
					}
				});

			});

		});
		function onchangeMandal(sel) {
			var req = getXMLHTTP();
			var method = "GET";
			var url = "villagesundermandal?mandlcode=" + sel.value;

			if (req) {
				req.onreadystatechange = function() {
					if (req.readyState == 4) {
						// only if "OK"
						if (req.status == 200) {
							document.getElementById("villages").innerHTML = req.responseText;
							
							
						} else {
							onError(req);
						}
					}
				}
				req.open(method, url, true);
				req.send();
			}

		};

		function searchResults(results) {
			alert("search results");
		}
	</script>
	<div class="main-container container-fluid">
		<jsp:include page="/common/admin/leftnavigation.jsp"></jsp:include>
		<script>
			$("#viewVillage").addClass("active");
		</script>
		<div class="main-content">
			<div class="page-content">

				
						<h2>View Villages</h2>
					

							<table>

								
								<tr>
									<td>Select District</td>
									<td><select name="district" id="district">
											<option value="">Select District</option>
											<c:forEach var="district" items="${districts}"
												varStatus="status">

												<option value="${district.code}">${district.name}</option>
											</c:forEach>
										</select></td>
								</tr>
								<tr>
									<td>Select Mandal</td>
									<td><div id="mandalsdropdown">
											<select name="mandal" id="mandal">

												<c:forEach var="mandal" items="${mandals}"
													varStatus="status">
													<option value="${mandal.code}">${mandal.name}</option>
												</c:forEach>
											</select>
										</div>
										<div id="ajaxMessage">choose the district get the
											mandals</div></td>
								</tr>
								
							</table>
							<hr>
							<h1>Villages will be populated here</h1>
							<div id="villages">
							</div>
						
				
				<input type="button" value="Back"
					onclick="javascript:history.go(-1)">
			</div>
		</div>
	</div>

</template:page>