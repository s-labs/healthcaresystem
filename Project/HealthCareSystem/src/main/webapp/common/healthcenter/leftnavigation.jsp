<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<div id="sidebar" class="sidebar">
	<div class="sidebar-shortcuts" id="sidebar-shortcuts">
		<ul class="nav nav-list">
			<li>
				<div class="btn-toolbar">
					<div class="btn-group">
						<c:set var="gridlevel" value="${user.healthcenter.level}" />
						<button id="G1" class="btn  disabled" data-toggle="dropdown">
							G1
							<c:if test="${gridlevel=='1' }">
								<span class="caret"></span>
							</c:if>
						</button>
						<button id="G2" class="btn  disabled" data-toggle="dropdown">
							G2
							<c:if test="${gridlevel=='2' }">
								<span class="caret"></span>
							</c:if>
						</button>
						<button id="G3" class="btn  disabled" data-toggle="dropdown">
							G3
							<c:if test="${gridlevel=='3' }">
								<span class="caret"></span>
							</c:if>
						</button>
						<button id="G4" class="btn  disabled" data-toggle="dropdown">
							G4
							<c:if test="${gridlevel=='4' }">
								<span class="caret"></span>
							</c:if>
						</button>
						$("#G"+"${gridlevel}").addClass("btn-primary");

					</div>
				</div>
			</li>

			<sec:authorize ifAnyGranted="ROLE_HC_ADMIN">
				<li>Role : HC Admin</li>
				<li>
				<li id="addDoctor"><a
					href="${pageContext.request.contextPath}/healthCenter/addDoctor">
						<i class="icon-desktop"></i><span class="menu-text"> Add
							Doctor </span>
				</a></li>
				<li id="addClerk"><a
					href="${pageContext.request.contextPath}/healthCenter/addClerk">
						<i class="icon-desktop"></i><span class="menu-text"> Add
							Clerk </span>
				</a></li>
				<li id="addHospitalInfo"><a
					href="${pageContext.request.contextPath}/healthCenter/addHospitalInfo">
						<i class="icon-desktop"></i><span class="menu-text"> Add
							Hospitalinfo </span>
				</a></li>
				<li id="allUsers"><a href="allUsers"> <i
						class="icon-desktop"></i><span class="menu-text"> All Users
					</span></a></li>


			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_CLERK">
				Role : Clerk
				<li id="HIS"><a class="dropdown-toggle" href="#"> <i
						class="icon-desktop"></i> <span class="menu-text"> HIS </span> <b
						class="arrow icon-angle-down"></b>
				</a>
					<ul class="submenu">
						<li><a
							href="${pageContext.request.contextPath}/healthCenter/viewHospitalDetails">
								<i class="icon-double-angle-right"></i> Hospital Details
						</a></li>
						<li id="hospitalisationHistory"><a
							href="${pageContext.request.contextPath}/healthCenter/hospitalisationHistory">
								<i class="icon-double-angle-right"></i> Hospitalisation History
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
								<li><a href="#"> <i class="icon-double-angle-right"></i>
										No patient Selected
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
						<li id="pregnancyOutcome"><a
							href="${pageContext.request.contextPath}/healthCenter/pregnancyOutcome">
								<i class="icon-double-angle-right"></i> Pregnancy Outcome
						</a></li>
						<li id="pncDetails"><a
							href="${pageContext.request.contextPath}/healthCenter/pncDetails">
								<i class="icon-double-angle-right"></i> PNC Details
						</a></li>
						<li id="childImmunisation"><a
							href="${pageContext.request.contextPath}/healthCenter/childImmunisation">
								<i class="icon-double-angle-right"></i> Child Immunisation
						</a></li>
						<li id="infantDetails"><a
							href="${pageContext.request.contextPath}/healthCenter/infantDetails">
								<i class="icon-double-angle-right"></i> Infant Details
						</a></li>
						<li id="medicalhistory"><a
							href="${pageContext.request.contextPath}/healthCenter/medicalHistory">
								<i class="icon-double-angle-right"></i> Medical History
						</a></li>
						<li id="surgicalHistory"><a
							href="${pageContext.request.contextPath}/healthCenter/surgicalHistory">
								<i class="icon-double-angle-right"></i> Surgical History
						</a></li>
						<li id="allergyHistory"><a
							href="${pageContext.request.contextPath}/healthCenter/allergyHistory">
								<i class="icon-double-angle-right"></i> Allergy History
						</a></li>
						<li id="medicationDetails"><a
							href="${pageContext.request.contextPath}/healthCenter/medicationDetails">
								<i class="icon-double-angle-right"></i> Medication Details
						</a></li>
						<li id="pregnancyHistory"><a
							href="${pageContext.request.contextPath}/healthCenter/pregnancyHistory">
								<i class="icon-double-angle-right"></i> Pregnancy History
						</a></li>
						<li id="medicationTreatment"><a
							href="${pageContext.request.contextPath}/healthCenter/medicationTreatment">
								<i class="icon-double-angle-right"></i> Medication Treatment
						</a></li>
						<li id="drugPrescription"><a
							href="${pageContext.request.contextPath}/healthCenter/drugPrescription">
								<i class="icon-double-angle-right"></i> Drug Prescription
						</a></li>
						<li id="disease"><a
							href="${pageContext.request.contextPath}/healthCenter/disease">
								<i class="icon-double-angle-right"></i> Disease Information
						</a></li>

					</ul></li>
				<li id="tng"><a
					href="${pageContext.request.contextPath}/healthCenter/tng"> <i
						class="icon-desktop"></i> <span class="menu-text"> TNG </span>
				</a></li>
				<li><b>Current Patient : </b> <br /> <c:choose>
						<c:when test="${currentPatient != null}">
					${currentPatient.firstName} ${currentPatient.lastName}
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
