package in.skyline.filter;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Filter1
 */
@WebFilter("/test")
public class Filter1 extends HttpFilter implements Filter {
 
	private static final long serialVersionUID = 1L;
	 
	static {
		System.out.println("Filter object get loaded...");
	}
    public Filter1() {
        System.out.println("Filter object get instanstiated...");
    }
	 
	public void init(FilterConfig fConfig) throws ServletException {
		 super.init(fConfig);
		 init();
	}
	
	public void init() {
		System.out.println("Object get intialize...");
	}
 
	public void destroy() {
		System.out.println("Object get destroy");
	}

	 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 //Preprocessing 
		FilterConfig config=getFilterConfig();
	    ServletContext contex1 = request.getServletContext();
	    ServletContext contex2 =config.getServletContext();
	    
	   
	    contex1.log("A request is coming from:: "+request.getRemoteHost()+" for URL:: "+request.getRemoteAddr()+" at Date:: "+new Date());
	    System.out.println("Difference between ::" +contex1+" "+contex2);
	    contex2.log("A request is coming from:: "+request.getRemoteHost()+" for URL:: "+request.getRemoteAddr()+" at Date:: "+new Date());
	    PrintWriter pw =response.getWriter();
		pw.println("<h1>here we apply filter</h1>");

		// pass the request along the filter chain
		chain.doFilter(request, response);
		pw.close();
	}

 

}
