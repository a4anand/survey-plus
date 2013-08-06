<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="core" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Spring3Example</title>

</head>

<body>

	<h3>
		Welcome
		<core:out value="${loginForm.userName}" />
		<%-- <core:out value="${loginForm.survey_type}" /> --%>
	</h3>

	<form:form action="surveytypecheck.html" commandName="surveyType">
		<tr>


			<td>Choose survey type:<FONT color="red"><form:errors
						 /></FONT> </td>

		</tr><BR><BR>

		 
			<br>
			<td><form:radiobutton path="type" value="S" />Social </td>
			<br>
			<td> <form:radiobutton path="type" value="P" />Professional</td>
			<br>
			<td><form:radiobutton path="type" value="E"  />Educational</td>
			<br><br>

		</tr> 

		<tr>

			<td><input type="submit" value="Submit" /></td>

		</tr>
	</form:form>
	<table>

		<tr>

			<td><a href="loginform.html">Back</a></td>

		</tr>

	</table>

</body>

</html>