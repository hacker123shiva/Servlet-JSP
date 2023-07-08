package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet({ "/SecondServlet", "/test" })
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//1. Set the response type 
		response.setContentType("text/html");
		 
		//2. Getting the Printwritter object to send the response
		PrintWriter out=response.getWriter();
		
		//3.Setting the html page to write the responnse
		out.println(""" 
				<html>
				<head>
				<title>Output</title>
				</head>
				<body>
				<h1>Shiva Srivastava</h1>
				</body>
				</html>
  """);
		//4. close the respone object
		out.close();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
