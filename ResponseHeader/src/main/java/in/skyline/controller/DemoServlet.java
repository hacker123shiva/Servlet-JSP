package in.skyline.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class DemoServlet
 */
@WebServlet(urlPatterns={"/demo"},loadOnStartup = 10)
public class DemoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	static {
		System.out.println("Loading of DemoSErvlet");
	}
	
	@Override
	public void init() {
		System.out.println("Initialization of DemoServlet");
	}
    public DemoServlet() {
         System.out.println("Instantiation of DemoServlet");
    }
@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       System.out.println("Client IP Address: "+request.getRemoteAddr());
       System.out.println("Host IP Address: "+request.getRemoteHost());
       System.out.println("Client Port Number: "+request.getRemotePort());
       System.out.println("Server Name: "+request.getServerName());
       System.out.println("Port Number: "+request.getServerPort());
	}

}
