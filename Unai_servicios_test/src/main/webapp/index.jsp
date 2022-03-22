<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Test</title>
</head>
<body>
	<h1>UNAI, LO LOGRE!!</h1>
	<a href="testeo">Click here!</a>
	<br>
	<a href="jar">test Img</a>
	<br>
	<a href="saluda"> Saluda</a>
	
	<form action="nombre" method="POST">
	
		<input type="text" name="name"/>
		<input type="submit" value="send"/>
		
	</form>
	
	<p>Hello <%= request.getAttribute("name") %></p>
	
	
</body>
</html>