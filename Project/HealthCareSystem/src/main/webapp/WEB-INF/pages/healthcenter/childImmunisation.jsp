<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="pageTitle">Health care System :: Admin Home Page</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="content">

		<div class="main-container container-fluid">
			<jsp:include page="/common/leftnavigation.jsp"></jsp:include>
			<script>
				$("#MIS").addClass("active");
				$("#MIS").addClass("open");
				$("#childImmunisation").addClass("active");
			</script>
			<div class="main-content">
				<div class="page-content">


					<form:form method="post" action="childImmunisation"
						commandName="childImmunisation">

						<table>

							<tr>
								<td>CHILDID</td>
								<td><form:input path="childId" /></td>
							</tr>

							<tr>
								<td>child_last_name</td>
								<td><form:input path="child_last_name" /></td>
							</tr>

							<tr>
								<td>child_middle_name</td>
								<td><form:input path="child_middle_name" /></td>
							</tr>

							<tr>
								<td>child_first_name</td>
								<td><form:input path="child_first_name" /></td>
							</tr>

							<tr>
								<td>gender</td>
								<td><form:input path="gender" /></td>
							</tr>

							<tr>
								<td>mother_name</td>
								<td><form:input path="mother_name" /></td>
							</tr>

							<tr>
								<td>father_name</td>
								<td><form:input path="father_name" /></td>
							</tr>

							<tr>
								<td>dob</td>
								<td><form:input path="dob" /></td>
							</tr>

							<tr>
								<td>age</td>
								<td><form:input path="age" /></td>
							</tr>

							<tr>
								<td>bcg_at_birth</td>
								<td><form:input path="bcg_at_birth" /></td>
							</tr>

							<tr>
								<td>opv0_at_birth</td>
								<td><form:input path="opv0_at_birth" /></td>
							</tr>

							<tr>
								<td>hepatatisb1_at_birth</td>
								<td><form:input path="hepatatisb1_at_birth" /></td>
							</tr>

							<tr>
								<td>dpt1_at_6weeks</td>
								<td><form:input path="dpt1_at_6weeks" /></td>
							</tr>

							<tr>
								<td>opv1_at_6weeks</td>
								<td><form:input path="opv1_at_6weeks" /></td>
							</tr>

							<tr>
								<td>hepatatisb2_at_6weeks</td>
								<td><form:input path="hepatatisb2_at_6weeks" /></td>
							</tr>

							<tr>
								<td>dpt2_at_10weeks</td>
								<td><form:input path="dpt2_at_10weeks" /></td>
							</tr>

							<tr>
								<td>opv2_at_10weeks</td>
								<td><form:input path="opv2_at_10weeks" /></td>
							</tr>

							<tr>
								<td>hepatatisb3_at_10weeks</td>
								<td><form:input path="hepatatisb3_at_10weeks" /></td>
							</tr>

							<tr>
								<td>dpt3_at_14weeks</td>
								<td><form:input path="dpt3_at_14weeks" /></td>
							</tr>

							<tr>
								<td>opv3_at_14weeks</td>
								<td><form:input path="opv3_at_14weeks" /></td>
							</tr>

							<tr>
								<td>hepatatisb4_at_10weeks</td>
								<td><form:input path="hepatatisb4_at_10weeks" /></td>
							</tr>


							<tr>
								<td>measles_9_12_months</td>
								<td><form:input path="measles_9_12_months" /></td>
							</tr>

							<tr>
								<td>vitamina_dose1_9_12_months</td>
								<td><form:input path="vitamina_dose1_9_12_months" /></td>
							</tr>

							<tr>
								<td>mr_vaccine_16_24_months</td>
								<td><form:input path="mr_vaccine_16_24_months" /></td>
							</tr>

							<tr>
								<td>dpt_booster_16_24_months</td>
								<td><form:input path="dpt_booster_16_24_months" /></td>
							</tr>

							<tr>
								<td>opv_booster_16_24_months</td>
								<td><form:input path="opv_booster_16_24_months" /></td>
							</tr>

							<tr>
								<td>vitamina_dose2_16_24_months</td>
								<td><form:input path="vitamina_dose2_16_24_months" /></td>
							</tr>

							<tr>
								<td>vitamina_dose3_16_24_months</td>
								<td><form:input path="vitamina_dose3_16_24_months" /></td>
							</tr>

							<tr>
								<td>vitamina_dose4to9_2yrs</td>
								<td><form:input path="vitamina_dose4to9_2yrs" /></td>
							</tr>

							<tr>
								<td>dt5_2yrs</td>
								<td><form:input path="dt5_2yrs" /></td>
							</tr>

							<tr>
								<td>tt10</td>
								<td><form:input path="tt10" /></td>
							</tr>

							<tr>
								<td>tt16</td>
								<td><form:input path="tt16" /></td>
							</tr>

							<tr>
								<td colspan="2"><input type="submit"
									value="SubmitchildImmunisation" /></td>
							</tr>

						</table>
					</form:form>
				</div>
			</div>
		</div>
	
	</div>
</template:page>