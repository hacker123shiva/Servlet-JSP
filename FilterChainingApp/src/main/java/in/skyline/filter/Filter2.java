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
import javax.servlet.http.HttpFilter;

/**
 * Servlet Filter implementation class Filter2
 */
@WebFilter("/test")
public class Filter2 extends HttpFilter implements Filter {
       
    
	static {
		System.out.println("Filter2 get loaded...");
	}
    public Filter2() {
        System.out.println("Filter2 get instiate...");
    }

	 
	public void destroy() {
		System.out.println("Filter2 get destroy");
	}

 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
	 PrintWriter pw=response.getWriter();
	 pw.println("<h1>Second filter</h2>");
		chain.doFilter(request, response);
	pw.println("<h1>Second filter postprocessing completed");
	
	 
	}

 

}
