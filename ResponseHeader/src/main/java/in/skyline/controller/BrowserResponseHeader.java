package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BrowserResponseHeader
 */
@WebServlet(urlPatterns={"/test"},loadOnStartup = 1)
public class BrowserResponseHeader extends HttpServlet {
	private static final long serialVersionUID = 1L;
 static {
	 System.out.println("Servlet Loading....");
 }
 
 public BrowserResponseHeader() {
	 System.out.println("Sevlet instantiation...");
 }
 @Override
 public void init() throws ServletException{
	 System.out.println("Servlet initaillization...");
 }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	System.out.println("procesing");
	response.setContentType("text/html");
	PrintWriter pw=response.getWriter();
	pw.println("""
			<html>
			<head>
			<title>Request header</title>
			<link rel="stylesheet" href="style.css">
			</head>
			<body>
			<h1 class="h-1">Request header</h1>
			""");
	Enumeration<String> headerNames=request.getHeaderNames();
	pw.println("<table class='tb'>");
	pw.println("<tr><th>HeaderName</th><th>HeaderValue</th></tr>");
	while(headerNames.hasMoreElements()) {
		String headerName=headerNames.nextElement();
		String headerValue=request.getHeader(headerName);
		pw.println("<tr><td>"+headerName+"</td><td>"+headerValue+"</td></tr>");
	}
	pw.println("</table>");
	pw.println("""
			</body>
			</html>
			""");
	pw.close();
	
	}

}
