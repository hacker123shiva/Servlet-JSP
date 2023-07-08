package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstApp
 */
@WebServlet("/test1")
public class FirstApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String name=request.getParameter("name");
	 System.out.println(name);
	 request.setAttribute("name",name);
	 RequestDispatcher rd= request.getRequestDispatcher("/test2");
	 rd.forward(request, response);
	 
//	 PrintWriter pw=response.getWriter();
//	 pw.println("<h1>"+name+"</h1>");
//	 pw.close();
	}

}
