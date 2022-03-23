<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title> Print Form</title>
</head>
<body>
	<form action="servletP" method="post">
		name: <input type="text" name="name">
		ID# <input type="text" name="empID">
		<input type="submit" value="Enviar">
	</form>
</body>
</html>