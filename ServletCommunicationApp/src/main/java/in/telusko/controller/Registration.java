package in.telusko.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Registration
 */
@WebServlet(
		urlPatterns = { "/reg" }, 
		initParams = { 
				@WebInitParam(name = "url", value = "jdbc:mysql://localhost:3306/telusko"), 
				@WebInitParam(name = "user", value = "root"), 
				@WebInitParam(name = "password", value = "root")
		})
public class Registration extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
  String name=request.getParameter("name");
  Integer age=Integer.parseInt(request.getParameter("age"));
  String email=request.getParameter("email");
  String mobile=request.getParameter("mobile");
  
  response.setContentType("text/html");
  PrintWriter pw =response.getWriter();
  //userage is less than 18 or greater than 30 not eligible 
  if(age<18||age>30) {
response.sendError(504,"Use age is not eligible for requirment");
	  //send the error response
	 
  }
  else {
	  //otherwise, student is eligible  for recuriment
	  pw.println("""
	<html><head>
<title>Output</title>
</head>
	  		<body>
	  		<font>
	  		<h2>telusko consultenncy Service</h2>
	  	   
	  		</font>
	  			<h2>User registration Details</h2>
	  		 <table>
    <tbody>
      <tr>
        <td>Name</td>
        <td>"""  +name + """
        		</td>
      </tr>
      <tr>
        <td>Age</td>
        <td>
        		""" + age + """
        				
        				</td>
      </tr>
      <tr>
        <td>Email</td><td>
        				"""
        	    +email+ """ 
        	    	
        	    		</td>
        	    		  <tr>
        <td>Mobile</td>
        <td>
        	    		"""+mobile+"""
        	    			</td>
      </tr>
      <tr>
        <td>Registration Status</td>
        <td>Registration Succesfull</td>	
        	    				  </tr>
        	    			    </tbody>
        	    			  </table>
        	    			     
        	    						"""
 
        		
        );
	  
  }
pw.close();
  
	}

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
