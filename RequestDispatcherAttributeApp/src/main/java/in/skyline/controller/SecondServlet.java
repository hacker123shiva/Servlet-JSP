package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet("/test2")
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 PrintWriter pw=response.getWriter();
//		 pw.println("<table>");
//		 pw.println("<tr><th>AttributeName</th><th>AttributeValue</th>");
//		 Enumeration<String> attributeNames=request.getAttributeNames();
//		 while(attributeNames.hasMoreElements()) {
//			 String attributeName=attributeNames.nextElement();
//			 Object attributeValue=request.getAttribute(attributeName);
//			 pw.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
//		 }
//		 pw.close();
		 pw.println("shiva");
		 pw.flush();
		 
		RequestDispatcher rd= request.getRequestDispatcher("/test1");
		rd.forward(request, response);
		 
	}

}
