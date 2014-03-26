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
				<li><a href="addDoctor"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
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
				<li>
					<a class="dropdown-toggle" href="#"> <i
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
					</ul>
				</li>
				<li>
					<a class="dropdown-toggle" href="${pageContext.request.contextPath}/healthCenter/addPatient"> <i
						class="icon-desktop"></i> <span class="menu-text"> Add Patient </span> 
					</a>
					
				</li>
				<li>
					<a class="dropdown-toggle" href="${pageContext.request.contextPath}/healthCenter/viewAllPatients"> <i
						class="icon-desktop"></i> <span class="menu-text"> View All Patients </span> 
					</a>
					
				</li>
				
			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_DOCTOR">
					<li> Role : Doctor </li>
					<li>
					<a class="dropdown-toggle" href="#"> <i
						class="icon-desktop"></i> <span class="menu-text"> PIS </span> <b
						class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li><a href="${pageContext.request.contextPath}/healthCenter/viewPatients"> <i
								class="icon-double-angle-right"></i> Patient Master Index
						</a></li>
						
					</ul>
				</li>
					<li>
					<a class="dropdown-toggle" href="#"> 
						<i class="icon-desktop"></i> <span class="menu-text"> MIS </span> <b class="arrow icon-angle-down"></b>
					</a>
					<ul class="submenu">
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> PO </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> PD </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> CI </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> ID </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> MH </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> SH </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> AH </a>
						</li>
						<li>
						
							<a href="po"> <i class="icon-double-angle-right"></i> MD </a>
						</li>
						<li>						
							<a href="po"> <i class="icon-double-angle-right"></i> MT </a>
						</li>
						<li>						
							<a href="po"> <i class="icon-double-angle-right"></i> DPL </a>
						</li>
						
					</ul>
				</li>
				<li>
					<a href="tng"> <i class="icon-desktop"></i> <span class="menu-text"> TNG </span> </a>					
				</li>

			</sec:authorize>
		</ul>
	</div>
</div>
