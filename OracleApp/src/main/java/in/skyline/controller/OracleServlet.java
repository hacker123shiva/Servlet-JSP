package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OracleServlet
 */
@WebServlet("/orc")
public class OracleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       static {
    	   System.out.println("Loading of Oracle Servlet Completed...");
       }
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 response.setContentType("text/html");
 PrintWriter pw=response.getWriter();
 pw.println("""
 	 
<html>
<head>
  <title>HTML Page with Heading and Marquee</title>
</head>
<body>
  <h1>This is Oracle  Page for Java</h1> <p>"""
		 +request.getParameter("uname")+""" 
		 		
		 		 </p>
  <marquee behavior="scroll" direction="left" scrollamount="5">
  Oracle can take Java
  </marquee>
</body>
</html>

 		""");
 pw.close();
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
