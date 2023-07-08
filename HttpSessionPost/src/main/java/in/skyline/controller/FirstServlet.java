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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/page1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
   //collect value from request 
		String uname=request.getParameter("uname");
		String uage=request.getParameter("uage");
		
		//create session to store current request into session
		HttpSession session=request.getSession();
		session.setAttribute("uname", uname);
		session.setAttribute("uage", uage);
		
		//dispatch request to another page
		RequestDispatcher rd=request.getRequestDispatcher("/form2.html");
		rd.forward(request, response);
		
		 
	}
public void doPost(HttpServletRequest request, HttpServletResponse response) {
	try {
		doGet(request, response);
	} catch (ServletException | IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

}
