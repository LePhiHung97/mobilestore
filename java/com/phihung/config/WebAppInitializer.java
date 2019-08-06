package com.phihung.config;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebAppInitializer implements WebApplicationInitializer {

    public void onStartup(ServletContext container) throws ServletException {
	AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
	context.register(SpringConfig.class);
	context.setServletContext(container);

	DispatcherServlet dispatcherServlet = new DispatcherServlet(context);
	dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);

	System.out.println("Hello");

    }
}
