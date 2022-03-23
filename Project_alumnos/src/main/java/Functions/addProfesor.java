package Functions;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Beans.Employee;

/**
 * Servlet implementation class addProfesor
 */
@WebServlet("/addProfe")
public class addProfesor extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = (String) request.getParameter("name");
		String empID = (String) request.getParameter("empID");
		
		RequestDispatcher rd = request.getRequestDispatcher("TestBean.jsp");
		rd.forward(request, response);
	}

}
