<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>NES CHARACTERS COLLECTION SYSTEM v1.0</title>
</head>
<body>


	<h4>--------------------------------</h4>
	<h1> Online Exam System </h1>
	<h4>--------------------------------</h4>
	<h1> PLEASE LOG IN ... </h1>
	<h4>--------------------------------</h4>
	<%! 
		public String displayGreeting(int option) {
			if(option == 1)
				return "Login for Online Exam System";
			else
				return "You are not allowed to be here.";
	}	
	%>
	<strong> GREETING: <%= displayGreeting(1) %></strong>
	<h4>--------------------------------</h4>
	<h3 class="info"> ${ logoutInfo } </h3>
	<h4>--------------------------------</h4>
	
	<form method='POST' action="processLogin">
		Name:<input type="text" name="username"/><br/><br/>  
		Password:<input type="password" name="userpass"/><br/><br/>  
		
		<input type="submit" value = "LOG IN">
	</form>
	

</body>
</html>