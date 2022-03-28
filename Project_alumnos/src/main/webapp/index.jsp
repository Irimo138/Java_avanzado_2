<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Index</title>
</head>
<body>
<h2>Añadir Profesor</h2>
	<form action="addProfe" method="POST">
		Nombre: <input type="text" name="nombre">
		<br>
		Año inicio<input type="text" name="inicio">
		<br>
		Cantidad alumnos<input type="text" name="alumnos">
		<br>
		<input type="submit" value="Enviar">
	</form>
	<br>
	<form action="addCole" method="POST">
		Nombre: <input type="text" name="nombre">
		<br>
		Año inicio<input type="text" name="inicio">
		<br>
		Cantidad Profesor<input type="text" name="profes">
		<br>
		<input type="submit" value="Enviar">
	</form>
	<a href="/mostrarProfes">Mostrar</a>
</body>
</html>