package silab.nst.dan11.webapp.listener;


import silab.nst.dan11.webapp.sevlet.Servlet3;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.WebListener;

@WebListener
public class MyApplicationContextListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("Context is initialized");
        setContextAttribute(servletContextEvent.getServletContext());

        registerServlet(servletContextEvent.getServletContext());
    }

    private void registerServlet(ServletContext servletContext) {
        ServletRegistration.Dynamic servlet = servletContext.addServlet("Servlet3", Servlet3.class);
//        servlet.setInitParameter("", "");
        servlet.addMapping("/s3");
    }


    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("Context is destroyed");
    }

    private void setContextAttribute(ServletContext servletContext) {
        servletContext.setAttribute("user", "pera");
    }
}
