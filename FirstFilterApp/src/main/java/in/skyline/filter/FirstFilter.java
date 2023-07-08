package in.skyline.filter;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
 

/**
 * Servlet Filter implementation class FirstFilter
 */
@WebFilter("/test")
public class FirstFilter   implements Filter {
  
	static {
		System.out.println("Filter get loaded...");
	}
    public FirstFilter() {
        System.out.println("Filter get instantatiate...");
    }
 
	public void init(FilterConfig fConfig) throws ServletException {
	System.out.println("filter object get intialized");	 
	}
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	   //PreProcessing logic
PrintWriter pw  =response.getWriter();

     pw.println("<h1> PreProcessed logic</h1>");
     
     
		// pass the request along the filter chain
		chain.doFilter(request, response);
		 
		 
		//postProcessing logic
	pw.println("<h1>PostProcessing Logic</h1>");
	}
	
	public void destroy() {
		System.out.println("Filter object get deleted");
	}
 
 

}
