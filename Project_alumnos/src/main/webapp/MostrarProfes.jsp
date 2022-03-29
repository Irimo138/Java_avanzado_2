<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Mostrar Escuelas</h2>
	<c:forEach items="${lista}" var="escuela">     
       ${escuela.nombre}
       ${escuela.añoInicio}
       ${escuela.cantidadProfesor}
       <br>
    </c:forEach>
</body>
</html>