package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

 
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
public class TestServletApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	static {
		System.out.println("Loading of TestServletApp...");
	}
   
    public TestServletApp() {
        System.out.println("Servlet Instatntiation...");
    }

    public void init() {
    	System.out.println("Servlet intialization...");
    }
    
	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 ServletContext context=getServletContext();
	 context.setAttribute("skyline", "Shiva");
	 context.setAttribute("google", "Suder Pichai");
	 context.setAttribute("telusko", "Navin Reddy");
	 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		  
		 pw.println("""
					<html>
					<head>
					<title>Context Object</title>
					<link rel="stylesheet" href="style.css">
					</head>
					<body>
					<h1 class="h-1">Context Object</h1>
					""");
			Enumeration<String> parameterNames=context.getInitParameterNames();
			pw.println("<table class='tb'>");
			pw.println("<tr><th>ParameterName</th><th>ParameterValue</th></tr>");
			//static 
			while(parameterNames.hasMoreElements()) {
				String parameterName=parameterNames.nextElement();
				String parameterValue=context.getInitParameter(parameterName);
				pw.println("<tr><td>"+parameterName+"</td><td>"+parameterValue+"</td></tr>");
			}
			
			Enumeration<String> attributeNames=context.getAttributeNames();
 
			pw.println("<tr><th>AttributeName</th><th>AttributeValue</th></tr>");
			
			//dynamic 
			while(attributeNames.hasMoreElements()) {
				String attributeName=attributeNames.nextElement();
				Object attributeValue= context.getAttribute(attributeName);
				pw.println("<tr><td>"+attributeName+"</td><td>"+attributeValue+"</td></tr>");
			}
			pw.println("</table>");
			pw.println("""
					</body>
					</html>
					""");
			pw.close();
			
			//Illegal State exception 
			ServletOutputStream os=response.getOutputStream();
			 os.write(45);
			 os.close();
			 
	}

}
