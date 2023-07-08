package in.skyline.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet(urlPatterns="/test",loadOnStartup=1)
public class ImageResponseApp extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 static {
		System.out.println("Server Loading...."); 
	 }
	 
	 public ImageResponseApp() {
		 System.out.println("Servlet Instantiation...");
	 }
	 
	 public void init() throws ServletException{
		System.out.println("Servlet initialization..."); 
	 }
	 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	 
	    response.setContentType("image/jpg");
	    ServletOutputStream os=response.getOutputStream();
	    String path=getServletContext().getRealPath("shiva.jpg");
	    File file =new File("shiva.jpg");
	    FileInputStream fis=new FileInputStream(file);
	    
	    byte []b=new  byte[(int)file.length()];
	    fis.read(b); //reading and placing the image data into byte array
	    os.write(b); //writing the data as the response from byte array
	    os.flush();
	    fis.close();
	    os.close();
 
		
 
	}

}
