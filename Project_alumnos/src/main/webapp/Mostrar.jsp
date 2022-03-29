<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
 <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mostrar</title>
</head>
<body>
	<h2>Mostrar Profesores</h2>
	<c:forEach items="${lista}" var="profe">     
       ${profe.nombre}
       ${profe.añoInicio}
       ${profe.cantidadAlumnos}
       <br>
    </c:forEach>
</body>
</html>