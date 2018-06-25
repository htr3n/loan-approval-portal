package com.westbank.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class WebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    static final Logger log = LoggerFactory.getLogger(WebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        log.info("Starting the web application ....");

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(PersistenceConfig.class);
        rootContext.register(WebServiceConfig.class);
        rootContext.refresh();

        // manage the lifecycle of the root context
        servletContext.addListener(new ContextLoaderListener(rootContext));

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext dispatcherServlet = new AnnotationConfigWebApplicationContext();
        dispatcherServlet.register(WebMvcConfig.class);

        // Register and map the dispatcher servlet
        DispatcherServlet servlet = new DispatcherServlet(dispatcherServlet);
        ServletRegistration.Dynamic registration = servletContext.addServlet("portal", servlet);
        registration.setLoadOnStartup(1);
        registration.addMapping("*.html", "/portal/*");
    }
}
