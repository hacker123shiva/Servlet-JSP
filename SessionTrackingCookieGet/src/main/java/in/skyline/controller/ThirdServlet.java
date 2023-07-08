package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 

 

/**
 * Servlet implementation class ThirdServlet
 */
@WebServlet("/page3")
public class ThirdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//collect request value
		String umail=request.getParameter("umail");
		String umobile=request.getParameter("umobile");
		
		//get cookie object
		 Cookie[] c=request.getCookies();
		 
	 
		String uname=c[0].getValue();
		String uage=c[1].getValue();
		String uqual=c[2].getValue(); 
		String udeg=c[3].getValue();
	 
		
		PrintWriter pw=response.getWriter();
		pw.println("<html><head><title>Output page</title> <link rel='stylesheet' href='style.css'/> </head>");
		pw.println("<body><table>");
		pw.println("<tr><th>Name:</th><td>"+uname+"</td></tr>");
		pw.println("<tr><th>Age:</th><td>"+uage+"</td></tr>");
		pw.println("<tr><th>Qualification:</th><td>"+uqual+"</td></tr>");
		pw.println("<tr><th>Degree:</th><td>"+udeg+"</td></tr>");
		pw.println("<tr><th>Email:</th><td>"+umail+"</td></tr>");
		pw.println("<tr><th>Mobile:</th><td>"+umobile+"</td></tr>");
		pw.println("</table></body></html>");
		pw.close();
		
	   
 
		
	}

}
