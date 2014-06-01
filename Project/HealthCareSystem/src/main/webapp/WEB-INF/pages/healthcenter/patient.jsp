<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>


<c:set var="pageTitle">A grid based indian rural healthcare system :: Patient Master Index</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="main-container container-fluid">
		<jsp:include page="/common/healthcenter/leftnavigation.jsp"></jsp:include>
		<div class="main-content">
			<div class="page-content">
				<div id="accordion">
					<h3>Patient basic information</h3>
					<div>
						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>

									<th>Column</th>
									<th>Details</th>

								</tr>
							</thead>
							<tr>
								<td>UHID</td>
								<td>${patient.uhid }</td>
							</tr>
							<tr>
								<td>First Name</td>
								<td>${patient.firstName }</td>
							</tr>
							<tr>
								<td>Last Name</td>
								<td>${patient.lastName }</td>
							</tr>
							
							<tr>
								<td>Date of birth</td>
								<td>${patient.dob }</td>
							</tr>
							<tr>
								<td>Age</td>
								<td>${patient.age }</td>
							</tr>
							<tr>
								<td>Gender</td>
								<td>${patient.gender }</td>
							</tr>
							<tr>
								<td>Occupation</td>
								<td>${patient.occupation }</td>
							</tr>
							<tr>
								<td>Father / Husband Name</td>
								<td>${patient.fatherHusbandName}</td>
							</tr>
							<tr>
								<td>motherName</td>
								<td>${patient.motherName }</td>
							</tr>
							<tr>
								<td>addressLine1</td>
								<td>${patient.addressLine1 }</td>
							</tr>
							<tr>
								<td>addressLine2</td>
								<td>${patient.addressLine2 }</td>
							</tr>
							<tr>
								<td>pinCode</td>
								<td>${patient.pinCode}</td>
							</tr>
							<tr>
								<td>city/Town/Village</td>
								<td>${patient.cityTownVillage}</td>
							</tr>
							<tr>
								<td>mandal</td>
								<td>${patient.mandal}</td>
							</tr>
							<tr>
								<td>district</td>
								<td>${patient.district}</td>
							</tr>
							<tr>
								<td>state</td>
								<td>${patient.sate}</td>
							</tr>
							<tr>
								<td>email</td>
								<td>${patient.email}</td>
							</tr>
							<tr>
								<td>phone</td>
								<td>${patient.phone}</td>
							</tr>
							
							
						</table>
					</div>
					<h3>Medical History</h3>
					<div>
						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>

									<th>Column</th>
									<th>Details</th>

								</tr>
							</thead>
							<c:forEach var="medicalhistory" items="${patient.medicalhistory}"
								varStatus="status">
								<tr>
									<td colspan="2">This record ${status.count}</td>
								</tr>
								<tr>
									<td>In patient</td>
									<td>${medicalhistory.ip}</td>
								</tr>
								<tr>
									<td>Out patient</td>
									<td>${medicalhistory.op}</td>
								</tr>

							</c:forEach>
						</table>
					</div>
					<h3>Medication Details :</h3>
					<div>
						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>

									<th>Column</th>
									<th>Details</th>

								</tr>
							</thead>
							<c:forEach var="medicationDetails"
								items="${patient.medicationDetails}" varStatus="status">
								<tr>
									<td colspan="2">This record ${status.count}</td>
								</tr>
								<tr>
									<td>medication name</td>
									<td>${medicationDetails.medication_name}</td>
								</tr>
								<tr>
									<td>drug code</td>
									<td>${medicationDetails.drug_code}</td>
								</tr>
								<tr>
									<td>strength</td>
									<td>${medicationDetails.strength}</td>
								</tr>

								<tr>
									<td>dose</td>
									<td>${medicationDetails.dose}</td>
								</tr>

								<tr>
									<td>route</td>
									<td>${medicationDetails.route}</td>
								</tr>
								<tr>
									<td>frequency</td>
									<td>${medicationDetails.frequency}</td>
								</tr>
								<tr>
									<td>from_date</td>
									<td>${medicationDetails.from_date}</td>
								</tr>
								<tr>
									<td>to_date</td>
									<td>${medicationDetails.to_date}</td>
								</tr>
								<tr>
									<td>next_check_up</td>
									<td>${medicationDetails.next_check_up}</td>
								</tr>


							</c:forEach>
						</table>
					</div>
					<h3>Pregnancy History :</h3>
					<div>
						<table id="sample-table-1"
							class="table table-striped table-bordered table-hover">
							<thead>
								<tr>

									<th>Column</th>
									<th>Details</th>

								</tr>
							</thead>
							<c:forEach var="pregnancyHistory"
								items="${patient.pregnancyHistory}" varStatus="status">
								<tr>
									<td colspan="2">This record ${status.count}</td>
								</tr>
								<tr>
									<td>first_anc</td>
									<td>${pregnancyHistory.first_anc}</td>
								</tr>
								<tr>
									<td>second_anc</td>
									<td>${pregnancyHistory.second_anc}</td>
								</tr>
								<tr>
									<td>strength</td>
									<td>${pregnancyHistory.third_anc}</td>
								</tr>

								<tr>
									<td>fourth anc</td>
									<td>${pregnancyHistory.fourth_anc}</td>
								</tr>
								<tr>
									<td>tt1</td>
									<td>${pregnancyHistory.tt1}</td>
								</tr>
								<tr>
									<td>tt2</td>
									<td>${pregnancyHistory.tt2}</td>
								</tr>
								<tr>
									<td>ttbooster</td>
									<td>${pregnancyHistory.ttbooster}</td>
								</tr>
								<tr>
									<td>complication</td>
									<td>${pregnancyHistory.complication}</td>
								</tr>

								<tr>
									<td>rtis sti</td>
									<td>${pregnancyHistory.rti_sti}</td>
								</tr>
								<tr>
									<td>ifa tablets given</td>

									<td>${pregnancyHistory.ifa_tablets_given}</td>
								</tr>
								<tr>
									<td>anaemia hb level</td>
									<td>${pregnancyHistory.anaemia_hb_level}</td>

								</tr>
							</c:forEach>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
</template:page>