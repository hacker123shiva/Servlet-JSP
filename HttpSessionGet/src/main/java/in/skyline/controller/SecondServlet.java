package in.skyline.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/page2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   //collect value from request 
				String uqual=request.getParameter("uqal");
				String udeg=request.getParameter("udeg");
				
				//create session to store current request into session
				HttpSession session=request.getSession();
				session.setAttribute("uqal", uqual);
				session.setAttribute("udeg", udeg);
				
				//dispatch request to another page
				RequestDispatcher rd=request.getRequestDispatcher("/form3.html");
				rd.forward(request, response);
	}

}
