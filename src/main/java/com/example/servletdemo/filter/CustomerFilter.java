package com.example.servletdemo.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class CustomerFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("CustomerFilter init");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;

        System.out.printf("  CustomerFilter receive getRequestURI=%s \n", httpServletRequest.getRequestURI());
        System.out.printf("  CustomerFilter receive getRequestURL=%s \n", httpServletRequest.getRequestURL());

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.printf("  CustomerFilter receive getRequestURI After\n");

    }

    @Override
    public void destroy() {
        System.out.println("CustomerFilter destroy");
    }
}
