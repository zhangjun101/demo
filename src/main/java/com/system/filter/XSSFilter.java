package com.system.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ZHANGJUN
 * 防止xss工具过滤器
 */
public class XSSFilter  implements Filter{

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpservletRequest = (HttpServletRequest) request;
		XSSRequestWrapper xssRequestWrapper = new XSSRequestWrapper(httpservletRequest);
		chain.doFilter(xssRequestWrapper, response);
	}

	
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}

}
