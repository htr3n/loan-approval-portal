package com.westbank;

import com.westbank.config.PersistenceConfiguration;
import com.westbank.config.ServiceConfiguration;
import com.westbank.config.WebMvcConfiguration;
import org.apache.cxf.transport.servlet.CXFServlet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

public class PortalWebApplicationInitializer implements org.springframework.web.WebApplicationInitializer {

    private static final Logger log = LoggerFactory.getLogger(PortalWebApplicationInitializer.class);

    @Override
    public void onStartup(ServletContext container) throws ServletException {
        log.info("Starting the web application ....");

        // Create the 'root' Spring application context
        AnnotationConfigWebApplicationContext rootContext = new AnnotationConfigWebApplicationContext();
        rootContext.register(PersistenceConfiguration.class);
        rootContext.register(ServiceConfiguration.class);

        // manage the lifecycle of the root context
        container.addListener(new ContextLoaderListener(rootContext));
        container.setInitParameter("defaultHtmlEscape", "true");

        // Create the dispatcher servlet's Spring application context
        AnnotationConfigWebApplicationContext webApplicationContext = new AnnotationConfigWebApplicationContext();
        webApplicationContext.register(WebMvcConfiguration.class);

        // Register and map the dispatcher servlet
        DispatcherServlet servlet = new DispatcherServlet(webApplicationContext);
        ServletRegistration.Dynamic dispatcherServlet = container.addServlet("portal", servlet);
        dispatcherServlet.setLoadOnStartup(1);
        dispatcherServlet.addMapping("*.html", "/portal/*");

        // Register and map the CXF servlet
        CXFServlet cxfServlet = new CXFServlet();
        ServletRegistration.Dynamic registration = container.addServlet("cxf", cxfServlet);
        registration.setLoadOnStartup(2);
        registration.addMapping("/services/*");
    }
}
