package aprendamos.servlets;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.ClienteDTO;

import aprendamos.java.service.LogueoService;

/**
 * Servlet implementation class LogueoServlet
 */
public class LogueoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	// LLAMAMOS AL SERVICIO
	LogueoService servicio = new LogueoService();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Recuperamos los parámetros que llegan en el request
		String vusuario = request.getParameter("usuario");
		String vclave = request.getParameter("clave");
		System.out.println(vusuario);
		System.out.println(vclave);

		// CREAMOS UN OBJETO DE TIPO CLIENTEDTO Y PASAMOS LOS ARGUMENTOS AL CONSTRUCTOR
		ClienteDTO candidato = new ClienteDTO(vusuario, vclave, null, null, null, 0);
		// INVOCAMOS AL MÉTODO DEL SERVICIO PARA VALIDAR EL USUARIO Y LE PASAMOS EL OBJETO CLIENTEDTO
		ClienteDTO validado = servicio.validaUsuario(candidato);
		// SI LA RESPUESTA DEL MÉTODO RETORNA DIFERENTE DE NULO
		if (validado != null) {
			// VALIDAMOS LA CLAVE
			if (validado.getClave().equals(vclave)) {
				// VERIFICAMOS SI EXISTE UNA SESION ACTIVA, SI EXISTE LA MATAMOS
				if (request.isRequestedSessionIdValid()) {
					HttpSession tempo = request.getSession(false);
					tempo.invalidate(); // MATAMOS LA SESION
				}

				// CREAMOS LA SEISON
				HttpSession lasession = request.getSession(true);

				// CARGAMOS DATOS A LA SESION
				lasession.setAttribute("usuario", validado);

				// REMITIMOS EL OBJETO AL SERVLET/JSP
				RequestDispatcher rd = request.getRequestDispatcher("/bienvenida.jsp");
				rd.forward(request, response);
			} else {
				request.setAttribute("msg", "Clave incorrecta!!!");
				RequestDispatcher rd = request.getRequestDispatcher("/logueo.jsp");
				rd.forward(request, response);
			}
		} else {
			request.setAttribute("msg", "Usuario incorrecto!!!");
			RequestDispatcher rd = request.getRequestDispatcher("/logueo.jsp");
			rd.forward(request, response);
		}
	}
}
