package TestServer;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/jar")
public class CodeReturn extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		
		response.setContentType("image/jpeg");
		
		ServletContext ctx = getServletContext();
		
		InputStream is = ctx.getResourceAsStream("/mihawk.jpg");
		
		int read;
		byte[] bytes = new byte[1024];
		
		OutputStream os = response.getOutputStream();
		while((read = is.read(bytes)) != -1) {
			os.write(bytes,0,read);
		}
		os.flush();
		os.close();
	}
}
