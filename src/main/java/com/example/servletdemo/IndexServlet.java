package com.example.servletdemo;

import javax.servlet.ServletConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

public class IndexServlet extends HttpServlet {

    @Override
    public void init() {
        System.out.println("IndexServlet init");
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        ServletConfig servletConfig = this.getServletConfig();

        Enumeration<String> initParams = servletConfig.getInitParameterNames();
        while (initParams.hasMoreElements()) {
            String name = initParams.nextElement();
            System.out.printf("    IndexServlet init param's name=%s, value=%s\n", name, servletConfig.getInitParameter(name));
        }

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "IndexServlet" + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
        System.out.println("IndexServlet destroy");
    }
    

}
