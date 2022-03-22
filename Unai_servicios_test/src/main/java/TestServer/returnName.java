package TestServer;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/saluda")
public class returnName extends HttpServlet{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String nombre = request.getParameter("name");
		
		String mensaje = "Hola "+ nombre;
		request.setAttribute(nombre, mensaje);
		
		RequestDispatcher rd = request.getRequestDispatcher("nombre");
		rd.forward(request, response);
	}
}
