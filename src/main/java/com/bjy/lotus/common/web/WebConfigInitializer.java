package com.bjy.lotus.common.web;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;

import com.bjy.lotus.common.web.configuration.AppConfiguration;
import com.bjy.lotus.common.web.configuration.MVCConfiguration;

public class WebConfigInitializer implements WebApplicationInitializer{
	
	@Override
	public void onStartup(ServletContext servletContext) throws ServletException {
		String ctx=servletContext.getContextPath();
		if(ctx.endsWith("/")){
			ctx=ctx.substring(0, ctx.lastIndexOf("/"));
		}
		servletContext.setAttribute("ctx", ctx);
		
		/**
		 * 添加编码转换过滤器
		 */
		FilterRegistration.Dynamic filterRegistration=servletContext.addFilter("CharacterEncodingFilter", 
				new CharacterEncodingFilter("utf-8", true));
		filterRegistration.addMappingForUrlPatterns(null, false, "/*");
		filterRegistration.setAsyncSupported(true);
		
		
		
		//初始化Spring全局上下文
		initializeSpringConfig(servletContext);
				
		//初始化Spring MVC 上下文
		initializeSpringMVCConfig(servletContext);
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
