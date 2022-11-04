package com.example.servletdemo.listener;

import javax.servlet.*;
import java.util.Enumeration;

public class CustomerListener implements ServletContextListener {

    public CustomerListener() {
        System.out.println("new CustomerListener()");
    }

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("contextInitialized init");
        /* This method is called when the servlet context is initialized(when the Web application is deployed). */
        System.out.printf("contextInitialized event =%s\n", sce.getSource().getClass().toString());

        ServletContext servletContext = sce.getServletContext();

        Enumeration<String> attributeNames = servletContext.getAttributeNames();
        while (attributeNames.hasMoreElements()) {
            String name = attributeNames.nextElement();
            System.out.printf("    contextInitialized name=%s, value=%s\n", name, servletContext.getAttribute(name));
        }

        System.out.println("\n");

        Enumeration<String> initParams = servletContext.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String name = initParams.nextElement();
            System.out.printf("    contextInitialized init param's name=%s, value=%s\n", name, servletContext.getInitParameter(name));
        }

        System.out.println("contextInitialized init end...\n");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("contextDestroyed");
    }
}
