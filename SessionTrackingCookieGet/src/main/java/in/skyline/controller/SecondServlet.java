package in.skyline.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

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
				String uqul=request.getParameter("uqul");
				String udeg=request.getParameter("udeg");
				
				//create session to store current request into cookie session
				Cookie c3=new Cookie("uqul",uqul);
				Cookie c4=new Cookie("udeg",udeg);
				
				   //add cookie object
				response.addCookie(c3);
				response.addCookie(c4);
					
				
				//dispatch request to another page
				RequestDispatcher rd=request.getRequestDispatcher("/form3.html");
				rd.forward(request, response);
	}

}
