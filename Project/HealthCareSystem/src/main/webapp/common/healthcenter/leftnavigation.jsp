<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="sidebar" class="sidebar">
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<ul class="nav nav-list">
			<li>
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
			</li>

			<sec:authorize ifAnyGranted="ROLE_HC_ADMIN">
				<li>Role : HC Admin</li>
				<li>
				<li><a href="addDoctor"> <i class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink ${action=='addDoctor'?'arrowed-right':'' }">
							Add Doctor </span></a></li>
				<li><a href="addClerk"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink  ${action=='addClerk'?'arrowed-right':'' }">
							Add Clerk </span></a></li>
				<li><a href="addHospitalInfo"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink  ${action=='addHospitalInfo'?'arrowed-right':'' }">
							Add Hospitalinfo </span></a></li>

			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_CLERK">
Role : Clerk
				<li><a class="dropdown-toggle" href="#"> <i
						class="icon-desktop"></i> <span class="menu-text"> HIS </span> <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a href="viewHospitalDetails"> <i
								class="icon-double-angle-right"></i> Hospital Details
						</a></li>
						<li><a href="viewHospitalizationHistory"> <i
								class="icon-double-angle-right"></i> Hospitalization History
						</a></li>
					</ul></li>
				<li id="addPatient"><a class="dropdown-toggle"
					href="${pageContext.request.contextPath}/healthCenter/addPatient">
						<i class="icon-desktop"></i> <span class="menu-text"> Add
							Patient </span>
				</a></li>
				<li id="allPatients"><a class="dropdown-toggle"
					href="${pageContext.request.contextPath}/healthCenter/viewAllPatients">
						<i class="icon-desktop"></i> <span class="menu-text"> View
							All Patients </span>
				</a></li>

			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_DOCTOR">
				<li>Role : Doctor</li>
				<li id="PIS"><a class="dropdown-toggle" href="#"> <i
						class="icon-desktop"></i> <span class="menu-text"> PIS </span> <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<c:choose>
							<c:when test="${currentPatient != null}">
								<li><a
									href="${pageContext.request.contextPath}/healthCenter/patient/${currentPatient.uhid}">
										<i class="icon-double-angle-right"></i> Patient Master Index
								</a></li>
							</c:when>
							<c:otherwise>
								<li><a
									href="#">
										<i class="icon-double-angle-right"></i> No patient Selected
								</a></li>
							</c:otherwise>
						</c:choose>

						<li id="allPatients"><a
							href="${pageContext.request.contextPath}/healthCenter/viewAllPatients">
								<i class="icon-double-angle-right"></i> All Patients
						</a></li>

					</ul></li>
				<li id="MIS"><a class="dropdown-toggle" href="#"> <i
						class="icon-desktop"></i> <span class="menu-text"> MIS </span> <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li id="pregnancyOutcome"><a href="${pageContext.request.contextPath}/healthCenter/pregnancyOutcome"> <i class="icon-double-angle-right"></i>
								pregnancy Outcome
						</a></li>
						<li id="pncDetails" ><a href="${pageContext.request.contextPath}/healthCenter/pncDetails"> <i class="icon-double-angle-right"></i>
								PNC DETAILS **
						</a></li>
						<li id="childImmunisation"><a href="${pageContext.request.contextPath}/healthCenter/childImmunisation"> <i class="icon-double-angle-right"></i>
								CHILD IMMUNISATION **
						</a></li>
						<li id="infantDetails"><a href="${pageContext.request.contextPath}/healthCenter/infantDetails"> <i class="icon-double-angle-right"></i>
								INFANT DETAILS **
						</a></li>
						<li id="medicalhistory"><a href="${pageContext.request.contextPath}/healthCenter/medicalHistory"> <i
								class="icon-double-angle-right"></i> Medical History
						</a></li>
						<li id="surgicalHistory"><a href="${pageContext.request.contextPath}/healthCenter/surgicalHistory"> <i class="icon-double-angle-right"></i>
								Surgical History
						</a></li>
						<li id="allergyHistory"><a href="${pageContext.request.contextPath}/healthCenter/allergyHistory"> <i class="icon-double-angle-right"></i>
								ALLERGY HISTORY **
						</a></li>
						<li id="medicationDetails"><a href="${pageContext.request.contextPath}/healthCenter/medicationDetails"> <i class="icon-double-angle-right"></i>
								Medication Details
						</a></li>
						<li id="pregnancyHistory"><a href="${pageContext.request.contextPath}/healthCenter/pregnancyHistory"> <i class="icon-double-angle-right"></i>
								Pregnancy History
						</a></li>
						<li id="medicationTreatment"><a href="${pageContext.request.contextPath}/healthCenter/medicationTreatment"> <i class="icon-double-angle-right"></i>
								Medication Treatment 
						</a></li>
						<li id="drugPrescriptionLookup"><a href="${pageContext.request.contextPath}/healthCenter/drugPrescriptionLookup"> <i class="icon-double-angle-right"></i>
								DRUG PRESCIPTION LOOKUP TABLE**
						</a></li>
						<li id="diseaseInformationLookup"><a href="${pageContext.request.contextPath}/healthCenter/diseaseInformationLookup"> <i class="icon-double-angle-right"></i>
								DISEASE INFORMATION LOOKUP TABLE**
						</a></li>

					</ul></li>
				<li><a href="tng"> <i class="icon-desktop"></i> <span
						class="menu-text"> TNG </span>
				</a></li>
				<li>Patient Information <br /> <c:choose>
						<c:when test="${currentPatient != null}">
					${currentPatient.firstName}
					</c:when>
						<c:otherwise>
					no patient selected
					</c:otherwise>
					</c:choose>
				</li>

			</sec:authorize>
		</ul>
	</div>
</div>
