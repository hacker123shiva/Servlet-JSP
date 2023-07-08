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
 * Servlet implementation class FirstServlet
 */
@WebServlet("/test1")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 //default response type is "text/html" only
 //since it is text/html automatically the response object will hold
 //<html><body></body></html>
		
		PrintWriter pw=response.getWriter();
		pw.println("<h1 style='color:red; text-align:center>This is FirstSErvlet</h1>");
//		pw.close(); 
		//Remember whenever you try to send response from other page using dispatch 
		//Donot open response in this page if you open that remember donot close it
	    RequestDispatcher rd=request.getRequestDispatcher("/test2");
	    rd.forward(request, response);
	    
	    System.out.println("Come back to current page");
	    //Note: No any effect of this code after return come to original page 
	    pw.println("<h1 style='color:red; text-align:center>This is FirstSErvlet</h1>");
	    pw.close();
	    
	    //In case of dispatching transfer goes to second and then come back
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
