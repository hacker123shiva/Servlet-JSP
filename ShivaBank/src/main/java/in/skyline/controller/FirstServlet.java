package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Harsh Srivastava</h1>");
	ServletContext context = getServletContext().getContext("/Gpay");
      System.out.println(context);
      RequestDispatcher rd=context.getRequestDispatcher("/test2");
      rd.include(request, response);
      pw.println("<h1>Muskan Garg</h1>");
      System.out.println("shiva");
      pw.close();
//      
	}

}
