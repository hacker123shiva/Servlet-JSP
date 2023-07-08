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
@WebServlet("/page1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 //collect value from request 
		String uname=request.getParameter("uname");
		String uage=request.getParameter("uage");
		
		System.out.println("checkk1....");
		//create session to store current request into cookie session
		Cookie c3=new Cookie("uname",uname);
		System.out.println("checkk2....");
		Cookie c4=new Cookie("uage",uage);
		System.out.println("checkk3....");
				
				   //add cookie object
				response.addCookie(c3);
				System.out.println("checkk4....");
				response.addCookie(c4);
				System.out.println("checkk5....");
					
				
				//dispatch request to another page
				RequestDispatcher rd=request.getRequestDispatcher("/form2.html");
				rd.forward(request, response);
	}

}






















 
