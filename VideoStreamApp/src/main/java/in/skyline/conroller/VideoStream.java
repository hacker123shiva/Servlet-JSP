package in.skyline.conroller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class VideoStream
 */
@WebServlet("/arrow")
public class VideoStream extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public VideoStream() {
 System.out.println("Servlet is instantiating...");
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletOutputStream os=response.getOutputStream();
		File f=new File("D:\\eclipse-workspace\\VideoStreamApp\\shiva.jpg");
		response.setContentType("image/jpg");
		FileInputStream fis =new FileInputStream(f);
		byte [] b=new byte[(int) f.length()];
		fis.read(b);
//		os.println("<h1>My name is Shiva");
		os.write(b);
		fis.close();
		os.close();
	}

}
