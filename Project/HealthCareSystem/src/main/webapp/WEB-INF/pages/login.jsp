<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template"%>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<c:set var="title">Health care System :: Login</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
	<div class="row-fluid">
		<div class="position-relative">
			<div id="login-box" class="login-box visible widget-box no-border">
				<div class="widget-body">
					<div class="widget-main">
						<h4 class="header blue lighter bigger">
							<i class="icon-coffee green"></i> Please Enter Your Information
						</h4>

						<div class="space-6"></div>
						<form method="post" action="j_spring_security_check">
							<fieldset>
								<label> <span class="block input-icon input-icon-right">
										<input type="text" class="span12" placeholder="Username"
										name="j_username" /> <i class="icon-user"></i>
								</span>
								</label> <label> <span class="block input-icon input-icon-right">
										<input type="password" class="span12" placeholder="Password"
										name="j_password" /> <i class="icon-lock"></i>
								</span>
								</label>

								<div class="space"></div>

								<div class="clearfix">
									<label class="inline"> <input type="checkbox" /> <span
										class="lbl"> Remember Me</span>
									</label>

									<button onclick="return true;"
										class="width-35 pull-right btn btn-small btn-primary">
										<i class="icon-key"></i> Login
									</button>
								</div>

								<div class="space-4"></div>
							</fieldset>
						</form>
					</div>
				</div>
			</div>
		</div>
		</div>
</template:page>