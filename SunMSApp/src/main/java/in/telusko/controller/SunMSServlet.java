package in.telusko.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SunMSServlet
 */
@WebServlet("/main")
public class SunMSServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    static {
    	System.out.println("Loading of Sunms servlet completed...");
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 response.setContentType("text/html");
	 
//using hyperlink	
	 PrintWriter pw=response.getWriter();
//	 pw.println("""
//	 	 
//<html>
//<head>
//  <title>Sun Page</title>
//</head>
//<body>
//  <h1>Sum Page</h1>
//  <p>This is Sunms.</p>
//  
// 
//
//  <h2>Java Resources:</h2>
//  <p>To learn more about Java, you can visit the official Oracle website:</p>
//  <a href="http://localhost:9999/OracleApp/orc" target="_blank">Oracle Java Website</a>
//</body>
//</html>
//
//	 		""");
//	 pw.close();  //if you close here you get illegal stateException 
	 //using redirect mechanism
	 String location ="http://localhost:9999/OracleApp/orc";
	 response.sendRedirect(location);
	 pw.close();
	 try {
		Thread.sleep(30000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 System.out.println("shiva");
	 
	 //Remember this method completed after that this redirect to Oracle
	 
	   
	}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
