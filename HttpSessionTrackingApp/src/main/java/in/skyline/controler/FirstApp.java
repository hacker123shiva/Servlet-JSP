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
 * Servlet implementation class FirstApp
 */
@WebServlet("/test1")
public class FirstApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String name=request.getParameter("name");
	String age=request.getParameter("age");
	
	HttpSession session=request.getSession(); 
	session.setAttribute("name", name);
	session.setAttribute("age", age);
	
	RequestDispatcher rd=request.getRequestDispatcher("/form2.html");
	rd.forward(request, response);
	}

}
