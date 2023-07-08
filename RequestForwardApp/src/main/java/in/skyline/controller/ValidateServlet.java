package in.skyline.controller;

import java.io.IOException;
import java.util.Set;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/test1")
public class ValidateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String uname=request.getParameter("uname");
		 String upwd=request.getParameter("upwd");
		 ServletContext context=getServletContext();
		 if(uname.equals("sachin")&&upwd.equals("tendulkar")) {
			 
			 
			 RequestDispatcher rd=context.getRequestDispatcher("/inbox.jsp");
			 rd.forward(request, response);
		 }
		 else {
			 RequestDispatcher rd=request.getRequestDispatcher("/error.jsp");
			 rd.forward(request, response);
		 }
	}

}
