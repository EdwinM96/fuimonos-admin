package com.fuimonosapp.configuration;

import java.util.TimerTask;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInitializer implements WebApplicationInitializer{
    
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(container);
		
		ServletRegistration.Dynamic servlet = container.addServlet("christmas-cards", new DispatcherServlet(ctx));
		
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
		
                
	}
	
}
