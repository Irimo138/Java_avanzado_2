package Functions;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

import Beans.Escuela;
import Beans.Profesor;
import SQL.conectionDB;

/**
 * Servlet implementation class ShowAllEscuelas
 */
@WebServlet("/showAllEscuelas")
public class ShowAllEscuelas extends HttpServlet {
	private static final long serialVersionUID = 1L;
	conectionDB c1;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		 c1 = new conectionDB();
		try {
			ArrayList<Escuela> lista = c1.mostrarEscuela();
			request.setAttribute("lista", lista);
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("MostrarProfes.jsp");
			requestDispatcher.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */


}
