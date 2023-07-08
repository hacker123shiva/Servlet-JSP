package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Page2
 */
@WebServlet(urlPatterns = { "/login","/pg2" }, initParams = {
		@WebInitParam(name = "url", value = "jdbc:mysql:///school"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "root") })
public class Page2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
    public Page2() {
     System.out.println("page2 instatntiate...");
    }
    
    Connection connection=null;
    PreparedStatement pstmt=null;
    ResultSet rs=null;

public void init() {
	ServletConfig scg=getServletConfig();
	String url=scg.getInitParameter("url");
	String user=scg.getInitParameter("user");
	String password=scg.getInitParameter("password");
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		connection=DriverManager.getConnection(url, user, password);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	

  public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  response.setContentType("text/html");
		PrintWriter pw =response.getWriter();
	 
		String user=request.getParameter("username");
		String pass=request.getParameter("password");
	  
	  //jdbc api
	  String query="select username from student where username=? and password=?";
	  try {
		pstmt=connection.prepareStatement(query);
		if(pstmt!=null) {
			pstmt.setString(1, user);
			pstmt.setString(2,pass);
			rs=pstmt.executeQuery();
			if(rs!=null) {
				if(rs.next()) {
					pw.println("""
<h1> You are succesfull login </h1>
<p>Your credential, you have 100million dollar</p>

							""");
				}
				else {
      pw.println("""
      		<h1>You are failed to login</h1>
      		""");
					
				}
			}
			
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		 
		pw.close();
	}

}
