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
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();

		out.println("<h1>Hello This is First Servlet...</h1>");
		
		System.out.println("Request object adress is1 :: "+request.hashCode());
		System.out.println("Response object adress is1 :: "+response.hashCode());
		System.out.println("PrintWriter object address is1 :: "+out.hashCode());
		
		 
		RequestDispatcher rd = request.getRequestDispatcher("/test2");
		rd.include(request, response);
		System.out.println("control coming back...");
		
		System.out.println("Request object adress is3 :: "+request.hashCode());
		System.out.println("Response object adress is3 :: "+response.hashCode());
		System.out.println("PrintWriter object address is3 :: "+out.hashCode());
		out.println("<h1>Hiee This is First Servlet Again...</h1>");

		out.close();
		
		 
	}

}
