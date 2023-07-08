package in.gla.detail;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Register
 */
@WebServlet("/detail")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Register() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String email=request.getParameter("email");
		String course=request.getParameter("course");
		 response.setContentType("text/html");
		 PrintWriter pw =response.getWriter();
		 try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 pw.println("""
		 		<html>
		 		<head>
		 		<title>Detail</title>
		 		<link rel="stylesheet" href="reg.css">
		 		</head>
		 		<body>
		 		<table>
		 		<tr>
		 		<th>Name:</th>
		 		<td>"""+ name +""" 
		 			</td>
                </tr>
		 		<tr><th>Email:</th>
		 		<td>"""+email+"""
		 	    </td>
		 	    </tr>
		 	    <tr><th>Course: </th>
		 	    <td>"""+course +
		 	    """
		 			</td> 
		 			</tr>
		 		</table>	
		 				""" 
		 		);
		 		pw.close();
		}
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
