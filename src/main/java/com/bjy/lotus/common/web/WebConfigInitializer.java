package com.bjy.lotus.common.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

public class WebConfigInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		System.out.println("start laod configuration...................");
		//加载springmvc配置
		initializeSpringMVCConfig(servletContext);
		
		//加载spring全局配合
		initializeSpringConfig(servletContext);
		
		System.out.println("end laod configuration...................");
	}
	
	
	
	private void initializeSpringMVCConfig(ServletContext webContainer){
		//create spring mvc application context
		AnnotationConfigWebApplicationContext mvcCtx=new AnnotationConfigWebApplicationContext();
		mvcCtx.register(MVCConfiguration.class);//load spring mvc configuration
	
		//register dispatch servlet
		ServletRegistration.Dynamic dispatchServlet=
				webContainer.addServlet("springMVC", new DispatcherServlet(mvcCtx));
		dispatchServlet.setLoadOnStartup(1);
		dispatchServlet.setAsyncSupported(true);
		dispatchServlet.addMapping("/");
	}
	
	
	
	
	private void initializeSpringConfig(ServletContext webContainer){
		AnnotationConfigWebApplicationContext appCtx=new AnnotationConfigWebApplicationContext();
		appCtx.register(AppConfiguration.class);//load spring mvc configuration
		webContainer.addListener(new ContextLoaderListener(appCtx));
	}
	
	
	
	
	
}
