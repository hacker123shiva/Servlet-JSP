package in.skyline.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns = { "/reg","/pg1" }, initParams = {
		@WebInitParam(name = "url", value = "jdbc:mysql:///school"),
		@WebInitParam(name = "user", value = "root"), @WebInitParam(name = "password", value = "root") })
public class Page1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection connection=null;
    PreparedStatement pstmt=null;

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
	    String user=request.getParameter("username");
	    String email=request.getParameter("email");
	    String password=request.getParameter("password");
		int rowCount=0;
	    //Jdbc api 
	    String query="insert into student (username, email, password) values (?,?,?)";
	    if(connection!=null) {
	    	try {
				pstmt=connection.prepareStatement(query);
				if(pstmt!=null) {
					pstmt.setString(1, user);
					pstmt.setString(2, email);
					pstmt.setString(3, password);
					rowCount=pstmt.executeUpdate();
	
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		if(rowCount!=0)
		pw.println("""
 
 
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<html>
<head>
  <title>Login</title>
</head>
<body>
  <h1>Login</h1>
  <form action="./pg2" method="get">
    <label for="username">Username:</label>
    <input type="text" id="username" name="username" required><br><br>
    
    <label for="password">Password:</label>
    <input type="password" id="password" name="password" required><br><br>
    
    <input type="submit" value="Sign In">
  </form>
</body>
</html>
</body>
</html>
				""");
		else {
			pw.println("""
					 <h1>Registration failed</h1>

									""");	
		}
		pw.close();

	}

}
