<%@page import="com.sun.corba.se.impl.protocol.giopmsgheaders.Message"%>
<html>
<head>
<title>Esta es mi primera pagina</title>
<link href="estilos/facilito.css" rel="stylesheet" type="text/css" />
<script type="text/javascript">
	function f_ingresa() {
		// podemos jugar con java script
	}
</script>
</head>
<body>
	<!-- Invocamos al servlet LogueoServlet mediante el alias definido en web.xml -->
	<form method="post" action="logueo">
		<table>
			<tr class="etiqueta">
				<td colspan="2"><img alt="El loguito"
					src="imagenes/logo_tiny.png">
				</td>
			</tr>
			<tr class="etiqueta">
				<td>Usuario:</td>
				<td><input type="text" name="usuario">
				</td>
			</tr>
			<tr class="etiqueta">
				<td>Clave:</td>
				<td><input type="password" name="clave">
				</td>
			</tr>
			<tr class="error general">
				<td colspan="2" align="center"></td>
			</tr>
			<tr>
				<td colspan="2" align="right"><input type="submit"
					name="boton01" value="Ingresar">
				</td>
			</tr>
			<tr>
				<td class="error_general">
					<%
				 		String msg = (String) request.getAttribute("msg");
				 		if (msg == null) {
				 			msg = "";
				 		}
				 	%>
				 	<%= msg %>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>