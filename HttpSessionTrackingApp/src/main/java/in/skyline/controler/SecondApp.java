package in.skyline.controler;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondApp
 */
@WebServlet("/test2")
public class SecondApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String qua=request.getParameter("qua");
			String deg=request.getParameter("deg");
			
			HttpSession session=request.getSession(); 
			session.setAttribute("qua", qua);
			session.setAttribute("deg", deg);
			
			RequestDispatcher rd=request.getRequestDispatcher("/form3.html");
			rd.forward(request, response);
	}

}
