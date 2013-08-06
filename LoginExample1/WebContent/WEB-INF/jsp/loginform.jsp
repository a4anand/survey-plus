<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
"http://www.w3.org/TR/html4/loose.dtd">

<html>

<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Example</title>

</head>

<body>

	<h3>Login Form</h3>

	<FONT color="blue"> <!-- <h5>User Name="root" and Password="root"</h5> -->

	</FONT>

	<form:form action="logincheck.html" commandName="loginForm">

		<table>

			<tr>

				<td>User Name:<FONT color="red"><form:errors
							path="userName" /></FONT></td>

			</tr>

			<tr>

				<td><form:input path="userName" /></td>

			</tr>

			<tr>

				<td>Password:<FONT color="red"><form:errors
							path="password" /></FONT></td>

			</tr>

			<tr>

				<td><form:password path="password" /></td>

			</tr>
			
			<tr>

				<td>Choose survey type:<FONT color="red"><form:errors
							path="survey_type" /></FONT></td>

			</tr>

			<tr>

				<form:radiobutton path="survey_type" value="S"/>Social 
				<form:radiobutton path="survey_type" value="P"/>Professional
				<form:radiobutton path="survey_type" value="E"/>Educational

			</tr>
			

			<%-- <input type="radio" name="radio_survey" value="social">Social
			<br>
			<input type="radio" name="radio_survey" value="professional">Professional
			<br>
			<input type="radio" name="radio_survey" value="educational">Educational
			<br>
			
			<td><form:input  path="radio_survey" /></td> --%>
			
			<tr>

				<td><input type="submit" value="Submit" /></td>

			</tr>

		</table>

	</form:form>

</body>

</html>