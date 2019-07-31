package com.sims.controller.filter;

import java.io.IOException;
import java.net.http.HttpRequest;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sims.utils.Utility;

/**
 * Servlet Filter implementation class SessionFilter
 */
@WebFilter("*")
public class SessionFilter implements Filter {

    /**
     * Default constructor. 
     */
    public SessionFilter() {
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
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

		HttpServletRequest req=(HttpServletRequest)request;
		HttpSession session=req.getSession(false);
		String reqUrl=req.getRequestURI();
		boolean isExcluded=Utility.isExcludedPattern(reqUrl);
		if(isExcluded) {
			chain.doFilter(request, response);
		}
		else if(session==null || session.getAttribute("name")==null) {
			((HttpServletResponse) response).sendRedirect("index.html#login-box");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
