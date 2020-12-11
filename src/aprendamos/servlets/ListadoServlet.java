package aprendamos.servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bean.ClienteDTO;

import aprendamos.java.service.MantenerClienteService;

/**
 * Servlet implementation class ListadoServlet
 */
public class ListadoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	MantenerClienteService servicio = new MantenerClienteService();

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String voperacionr = request.getParameter("operador");
		if (voperacionr.equals("listarClientes")) {
			this.listarClientes(request, response);
		}
	}


	private void listarClientes(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String vnom = request.getParameter("nombre");
		List<ClienteDTO> lis = servicio.listadoClientes(vnom);
		
		request.setAttribute("listadito", lis);
		System.out.println("Listado de clientes");
		
		RequestDispatcher rd = request.getRequestDispatcher("/listado.jsp");
		rd.forward(request, response);
	}

}