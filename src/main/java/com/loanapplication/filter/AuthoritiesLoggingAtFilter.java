package com.loanapplication.filter;

import java.io.IOException;
import java.util.logging.Logger;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class AuthoritiesLoggingAtFilter implements Filter{

	private final Logger LOG = Logger.getLogger(AuthoritiesLoggingAtFilter.class.getName());
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		LOG.info("Authentication validation is in progress");
		chain.doFilter(request, response);
	}

}
