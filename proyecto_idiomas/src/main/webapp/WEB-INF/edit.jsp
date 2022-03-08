<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>Edit</title>
		<link rel="stylesheet" href="/css/edit.css"/>
		
	</head>
	<body>
		<div class="botones">
			<div>
				<form action="/logout" method="GET">
					<button type="submit" class="button3">
						<strong>Dashboard</strong>
					</button>
				</form>
			</div>
			<div>
				<form action="/languages/eliminar/${id}" method="POST" class="form3">
					<input type="hidden" name="_method" value="DELETE" />
						<button type="submit" class="button2">
							<Strong>Delete</Strong> 
						</button>
				</form>
			</div>
		</div>
		<div>
			<div class="registro">
				<form:form method="POST" action="/languages/edit/${id}" modelAttribute="idioma" class="form2">
					<input type="hidden" name="_method" value="PUT" />
					<div>
						<form:label path="nombre" for="nombre">
							Name:
						</form:label>
						<form:input path="nombre" type="text" name="nombre" id="nombre" placeholder="${nombre}"/>
						<form:errors path="nombre" class="error"/>
					</div>
					<div>
						<form:label path="creador" for="creador">
							Creator:
						</form:label>
						<form:input path="creador" type="text" name="creador" id="creador" placeholder="${creador}"/>
						<form:errors path="creador" class="error"/>
					</div>
					<div>
						<form:label path="version" for="version">
							Version:
						</form:label>
						<form:input path="version" type="number" name="version" id="version" value="null" placeholder="${version}" step="0.1" min="1" max="10" />
						<form:errors path="version"/>
					</div>
					<button type="submit" class="button1">
						Submit
					</button>
				</form:form>
			</div>
		</div>
	
	</body>
</html>