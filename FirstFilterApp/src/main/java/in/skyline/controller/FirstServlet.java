package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet(urlPatterns={"/test"}, loadOnStartup = 1)
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	static {
		System.out.println("servlet get loaded...");
	}
	
	public FirstServlet(){
		System.out.println("servlet object get instantiate...");
	}
	
	public void init() {
		System.out.println("Servlet get intialize");
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
     
		PrintWriter pw=response.getWriter();
		pw.println("<h1>Inside the Servlet</h1>");
		 
	}

}
