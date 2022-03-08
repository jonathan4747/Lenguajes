<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="ISO-8859-1">
		<title>languages</title>
		<link rel="stylesheet" href="/css/index.css"/>
	</head>
	<body>
		<div >
			<div class="lista">
				<table>
				    <thead>
				        <tr>
				            <th>Name</th>
				            <th>Creator</th>
				            <th>version</th>
				            <th>Actions</th>
				        </tr>
				    </thead>
			    <tbody>
			         <c:forEach var="idiomas" items="${listaIdiomas}">
			         	<tr>		
									<th><a href="/languages/${idiomas.getId()}"><c:out value="${idiomas.getNombre()}"/></a></th> 
									<th><c:out value="${idiomas.getCreador()}"/></th> 
									<th><c:out value="${idiomas.getVersion()}"/></th>
									<th class="actions">
										<form action="/languages/eliminar/${idiomas.getId()}" method="POST" class="form2">
												<input type="hidden" name="_method" value="DELETE" />
												<button type="submit" class="button2">
															<Strong>Delete</Strong> 
												</button>
										</form>
										<a href="/languages/edit/${idiomas.getId()}">Edit</a>
									
									</th>
						</tr>
			         </c:forEach>
			    </tbody>
			   </table>
			</div>
		</div>
		<div>
			<div class="registro">
				<form:form method="POST" action="/languages" modelAttribute="idioma" class="form1">
					<div>
						<form:label path="nombre" for="nombre">
							Name:
						</form:label>
						<form:input path="nombre" type="text" name="nombre" id="nombre" />
						<form:errors path="nombre" class="error"/>
					</div>
					<div>
						<form:label path="creador" for="creador">
							Creator:
						</form:label>
						<form:input path="creador" type="text" name="creador" id="creador" />
						<form:errors path="creador" class="error"/>
					</div>
					<div>
						<form:label path="version" for="version">
							Version:
						</form:label>
						<form:input path="version" type="number" name="version" id="version" value="null" step="0.1" min="1" max="10" />
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