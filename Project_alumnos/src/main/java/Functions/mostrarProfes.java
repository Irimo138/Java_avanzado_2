package Functions;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Beans.Profesor;
import SQL.conectionDB;

/**
 * Servlet implementation class mostrarProfes
 */
@WebServlet("/mostrarProfes")
public class mostrarProfes extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private conectionDB c1;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 c1 = new conectionDB();
		try {
			ArrayList<Profesor> lista = c1.mostrarProfes();
			request.setAttribute("lista", lista);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("Mostrar.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
