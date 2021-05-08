<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title> NES CHARACTER SYSTEM v1.0</title>
</head>
<body>

	<h2>------------------------------------------</h2>
	<h1> Online Exam System - LOGGED IN </h1>
	<h2>------------------------------------------</h2>
		<!-- CHARACTER NAME: ${ sessionScope.charUser.charName } </br>-->
		Employee First Name: ${ sessionScope.loggedInEmployee.firstname } </br>
		Employee Last Name: ${ sessionScope.loggedInEmployee.lastname } </br>
	<h2>------------------------------------------</h2>
	
	<form methor="GET" action="processLogout">
		<input type="submit" value="LOG OUT">
	</form>


</body>
</html>