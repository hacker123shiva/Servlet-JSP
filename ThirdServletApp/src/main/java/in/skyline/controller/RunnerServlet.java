package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RunnerServlet
 */
public class RunnerServlet extends HttpServlet {
	 
  
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	public RunnerServlet() {
       System.out.println("RunnerServlet Instanstan..."); 
    }

  
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter pw=response.getWriter();
		 pw.println("""
		 		<html>
		 		<head>
		 		<title>Area Of Runner</title>
		 		</head>
		 		<body>
		 		<h1>Creating Servlet through eclipse is easy</h1>
		 		</body>
		 		</html>
		 		""");
		 pw.close();
		 
	}

}
