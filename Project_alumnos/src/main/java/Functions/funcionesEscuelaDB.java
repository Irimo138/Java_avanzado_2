package Functions;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Beans.Profesor;
import SQL.conectionDB;

/**
 * Servlet implementation class funcionesEscuelaDB
 */
@WebServlet("/addEscuela")
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
		String cantidadAlumnos = request.getParameter("alumnos");
		
		Profesor p = new Profesor();
		p.setNombre(nombre);
		Integer ano = Integer.parseInt(añoInicio);
		p.setAñoInicio(ano);
		int alumnos = Integer.parseInt(cantidadAlumnos);
		p.setAñoInicio(alumnos);
		try {
			c1.addProfeDB(p);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
