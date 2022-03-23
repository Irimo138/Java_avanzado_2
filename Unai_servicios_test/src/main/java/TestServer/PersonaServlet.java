package TestServer;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

import Beans.Employee;
import Beans.Person;

/**
 * Servlet implementation class PersonaServlet
 */
@WebServlet("/servletP")
public class PersonaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Employee p1 = new Employee();
		String name = (String) request.getParameter("name");
		String empID = (String) request.getParameter("empID");
		
		p1.setName(name);
		p1.setEmpID(empID);
		
		request.setAttribute("persona", p1);
		
		RequestDispatcher rd = request.getRequestDispatcher("TestBean.jsp");
		rd.forward(request, response);
	}

}
