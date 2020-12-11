<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- Referenciamos a la librería core de JSTL -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%-- 
<%@page import="aprendamos.java.bean.ClienteDTO"%>
--%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css">
</head>
<body>
	<table>
		<tr>
			<!-- Aqui va la cabecera -->
			<td colspan="2" align="center"><jsp:include page="cabecera.jsp" /></td>
		</tr>
		<tr>
			<!-- Aqui va el menu -->
			<td><jsp:include page="menu.jsp" /></td>
			<!-- Aqui va el cuerpo -->
			<td>
				<form method="post" action="ListadoServlet">
					<input type="hidden" name="operador" value="listarClientes">
					<table class="control">
						<tr>
							<td colspan="2" class="titulo">Listado de clientes</td>
						</tr>
						<tr>
							<td>Nombre:</td>
							<td><input type="text" name="nombre"></td>
							<td><input type="submit" name="boton" value="Listar"></td>
						</tr>
						<!-- Aquí visualizamos el listado, para ello 
							usaremos la etiqueta JSTL foreach.
							En el atributo items referenciamos el collection a iterar
							En el atributo var, colocamos el nombre de una variable
							que representará el contenido del collection
							por cada iteración
						 -->
						<c:forEach var="pun" items="${requestScope.listadito}">
							<tr>
								<td>${pun.nombre}</td>
								<td>${pun.direccion}</td>
								<td>${pun.fecnac}</td>
								<td>${pun.telefono}</td>
							</tr>
						</c:forEach>
					</table>
				</form>
			</td>
		</tr>
		<tr>
			<!-- Aqui va el pie -->
			<td colspan="2" align="center"><jsp:include page="pie.jsp" /></td>
		</tr>
	</table>
</body>
</html>