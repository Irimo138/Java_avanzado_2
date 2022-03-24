package Functions;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import Beans.Profesor;
import SQL.conectionDB;

/**
 * Servlet implementation class funcionesProfeDB
 */
@WebServlet("/addProfe")
public class funcionesProfeDB extends HttpServlet {
	private conectionDB c1;
	
	private static final long serialVersionUID = 1L;

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				//Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java","root", "");
			
			
			//Statement stmt = conn.createStatement();
			String nombre = request.getParameter("nombre");
			String añoInicio = request.getParameter("añoInicio");
			String cantidadAlumnos = request.getParameter("alumnos");
			
			
			Profesor p = new Profesor(nombre, añoInicio, cantidadAlumnos);
			try {
				c1.addProfeDB(p);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
			
		}

	}
