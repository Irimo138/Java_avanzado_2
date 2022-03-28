package Functions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Beans.Escuela;
import Beans.Profesor;
import SQL.conectionDB;

/**
 * Servlet implementation class funcionesEscuelaDB
 */
@WebServlet("/addCole")
public class funcionesEscuelaDB extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private conectionDB c1;
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		c1 = new conectionDB();
		String nombre = request.getParameter("nombre");
		String añoInicio = request.getParameter("inicio");
		String cantidadProfes = request.getParameter("profes");
		
		Escuela e = new Escuela();
		e.setNombre(nombre);
		Integer ano = Integer.parseInt(añoInicio);
		e.setAñoInicio(ano);
		int alumnos = Integer.parseInt(cantidadProfes);
		e.setCantidadProfesor(alumnos);
		try {
			c1.addEscuelaDB(e);
		} catch (ClassNotFoundException ex) {
			// TODO Auto-generated catch block
			ex.printStackTrace();
		}
		
	}

}