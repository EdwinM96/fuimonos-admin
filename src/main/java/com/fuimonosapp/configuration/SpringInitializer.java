package com.fuimonosapp.configuration;

import java.util.TimerTask;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import java.util.Timer;
import java.util.concurrent.TimeUnit;
import javax.servlet.MultipartConfigElement;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class SpringInitializer implements WebApplicationInitializer{
    
    private String TMP_FOLDER = "/tmp"; 
    private int MAX_UPLOAD_SIZE = 5 * 1024 * 1024; 
    
	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext ctx = new AnnotationConfigWebApplicationContext();
		
		ctx.register(SpringConfiguration.class);
		ctx.setServletContext(container);
		
		ServletRegistration.Dynamic servlet = container.addServlet("servlet", new DispatcherServlet(ctx));
		
		servlet.addMapping("/");
		servlet.setLoadOnStartup(1);
                
                
		
                
	}
	
}
