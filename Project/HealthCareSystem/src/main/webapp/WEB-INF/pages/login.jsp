<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="template" tagdir="/WEB-INF/tags/template" %>

<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<c:set var="title">Health care System :: Login</c:set>
<template:page pageTitle="${pageTitle}" bodyCss="home">
<form method="post" action="j_spring_security_check">
    <table>
        <tr>
            <td> Login: </td>
            <td> <input type="text" name="j_username"> </td>
        </tr>
        <tr>
            <td> Password: </td>
            <td> <input type="password" name="j_password"> </td>
        </tr>
        <tr> 
           <td></td> <td colspan="2"> <input type="submit" value="submit">
            <input type="reset" value="reset"> </td>
        </tr>
    </table>
</form>

</template:page>