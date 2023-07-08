package in.skyline.controler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ThirdApp
 */
@WebServlet("/test3")
public class ThirdApp extends HttpServlet {
	private static final long serialVersionUID = 1L;
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 String email=request.getParameter("email");
			String mobile=request.getParameter("mobile");
			
			HttpSession session=request.getSession(); 
			session.setAttribute("email", email);
			session.setAttribute("mobile", mobile);
			
			
			//retrive the data from session object
			Object name=session.getAttribute("name");
			Object age=session.getAttribute("age");
			Object qual=session.getAttribute("qua");
			Object deg=session.getAttribute("deg");
			Object mail=session.getAttribute("email");
			Object mob=session.getAttribute("mobile");
 
			//create a html page take from session object and then send the response
			response.setContentType("text/html");
			PrintWriter pw=response.getWriter();
			pw.println("<table>");
			pw.println("<tr><th>Name:</th><td>"+name+"</td></tr>");
			pw.println("<tr><th>Age:</th><td>"+age+"</td></tr>");
			pw.println("<tr><th>Qualification:</th><td>"+qual+"</td></tr>");
			pw.println("<tr><th>Degree:</th><td>"+deg+"</td></tr>");
			pw.println("<tr><th>Email:</th><td>"+mail+"</td></tr>");
			pw.println("<tr><th>Mobile:</th><td>"+mob+"</td></tr>");
			pw.close();
	}

}
