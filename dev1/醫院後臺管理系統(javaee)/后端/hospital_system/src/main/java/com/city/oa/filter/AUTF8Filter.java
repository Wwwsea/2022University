package com.city.oa.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * UTF8转码过滤器
 */
@WebFilter("/*")
public class AUTF8Filter implements Filter {

    /**
     * Default constructor. 
     */
    public AUTF8Filter() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest request=(HttpServletRequest)req;
		HttpServletResponse response=(HttpServletResponse)res;
		
		String uri=request.getRequestURI();
		
		request.setCharacterEncoding("UTF-8");
		
	
		
		response.setHeader("Access-Control-Allow-Origin", "*");
		/* 允许跨域的请求方法GET, POST, HEAD 等 */
		
		response.setHeader("Access-Control-Allow-Methods", "*");
		
		response.setHeader("Access-Control-Max-Age", "4200");
		
		response.setHeader("Access-Control-Allow-Headers", "*");
		
		response.setHeader("Access-Control-Allow-Credentials", "*");
		
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
