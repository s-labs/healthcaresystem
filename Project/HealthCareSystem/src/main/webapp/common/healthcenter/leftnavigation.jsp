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
<li> Role : HC Admin </li>
	<li>
				<li><a href="addDoctor"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink ${action=='addDoctor'?'arrowed-right':'' }"> Add Doctor 
						
					</span></a></li>
				<li><a href="addClerk"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink  ${action=='addClerk'?'arrowed-right':'' }"> Add Clerk 
						
					</span></a></li>
				<li><a href="addHospitalInfo"> <i
						class="icon-hand-right icon-animated-hand-pointer blue"></i><span
						class="label label-large label-pink  ${action=='addHospitalInfo'?'arrowed-right':'' }"> Add Hospitalinfo 
						
					</span></a></li>

			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_CLERK">
Role : Clerk
	<li><a class="btn" href="his">HIS</a></li>
				<li><a class="btn" href="pis">PIS</a></li>
				<li><a class="btn" href="mis">MIS</a></li>
				<li><a class="btn" href="tng">TNG</a></li>
			</sec:authorize>
			<sec:authorize ifAnyGranted="ROLE_DOCTOR">
Role : Doctor
	<li><a class="btn" href="his">HIS</a></li>
				<li><a class="btn" href="pis">PIS</a></li>
				<li><a class="btn" href="mis">MIS</a></li>
				<li><a class="btn" href="tng">TNG</a></li>
			</sec:authorize>
		</ul>
	</div>
</div>
