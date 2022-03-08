<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>show</title>
		<link rel="stylesheet" href="/css/vista.css"/>
	</head>
	<body>
		<div class="titulo">
			<div>
				<form action="/logout" method="GET">
					<button type="submit" class="button1">
						<strong>Dashboard</strong>
					</button>
				</form>
			</div>
		</div>
		<div class="informacion">
		 	<div class="cuadro">
				<p> <c:out value="${nombre}"/></p>
				<p> <c:out value="${creador}"/></p>
				<p> <c:out value="${version}"/></p>
			</div>
		</div>
		<div>
			<form action="/languages/eliminar/${id}" method="POST" class="form2">
				<input type="hidden" name="_method" value="DELETE" />
					<button type="submit" class="button2">
						<Strong>Delete</Strong> 
					</button>
			</form>
		</div>
	</body>
</html>