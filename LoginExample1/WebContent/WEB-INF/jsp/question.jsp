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

	<h3>Question Form
	</h3>

	<FONT color="blue"> <!-- <h5>User Name="root" and Password="root"</h5> -->

	</FONT>

	<form:form action="question.html" commandName="questionForm">

		<table>

			<tr>

				<td>Q1. <FONT color="red"><form:form
							path="question" /><core:out value="${questionForm.question}" /></FONT></td>

			</tr>

			<tr>

				<td><form:radiobutton path="option"  /><core:out value="${questionForm.question}" /></td>

			</tr>
			<tr>

				<td><form:radiobutton path="option"  />Answer2</td>

			</tr>
			<tr>

				<td><form:radiobutton path="option"  />Answer3</td>

			</tr>
			<tr>

				<td><form:radiobutton path="option"  />Answer4</td>

			</tr>

			
			<tr>

				<td><input type="submit" value="Next" /></td>

			</tr>

		</table>

	</form:form>

</body>

</html>