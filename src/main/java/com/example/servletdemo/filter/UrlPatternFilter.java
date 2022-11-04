package com.example.servletdemo.filter;

import javax.servlet.*;
import java.io.IOException;


public class UrlPatternFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.printf("UrlPatternFilter init\n");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.printf("  UrlPatternFilter receive request \n");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.printf("  UrlPatternFilter receive request After\n");
    }


    @Override
    public void destroy() {
        System.out.printf("UrlPatternFilter destroy\n");
    }
}
