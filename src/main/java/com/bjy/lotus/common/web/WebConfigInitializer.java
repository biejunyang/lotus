package com.bjy.lotus.common.web;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.util.Log4jConfigListener;

import com.bjy.lotus.common.utils.ClassUtil;
import com.bjy.lotus.common.web.configuration.AppConfiguration;
import com.bjy.lotus.common.web.configuration.MVCConfiguration;

@SuppressWarnings("deprecation")
public class WebConfigInitializer implements WebApplicationInitializer{
	private final static Log log4j = LogFactory.getLog(WebConfigInitializer.class);
	
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
		

		//log4j configuration; Spring4.x已不推荐使用该日志处理,要在ContextLoaderListener之前
		servletContext.setInitParameter("log4jConfigLocation", "classpath:/log4j.properties");
		servletContext.addListener(Log4jConfigListener.class);
		
		//初始化Spring全局上下文
		initializeSpringConfig(servletContext);
				
		//初始化Spring MVC 上下文
		ApplicationContext appCtx=initializeSpringMVCConfig(servletContext);
		
		try {
			Class.forName("com.bjy.lotus.common.web.SystemContext");
			ClassUtil.setAccessibleValue(SystemContext.class, "applicationContext", appCtx);
			ClassUtil.setAccessibleValue(SystemContext.class, "servletContext", servletContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log4j.error("系统启动失败");
		}
	}
	
	
	
	private ApplicationContext initializeSpringMVCConfig(ServletContext webContainer){
		//create spring mvc application context
		AnnotationConfigWebApplicationContext mvcCtx=new AnnotationConfigWebApplicationContext();
		mvcCtx.register(MVCConfiguration.class);//load spring mvc configuration
	
		//register dispatch servlet
		ServletRegistration.Dynamic dispatchServlet=
				webContainer.addServlet("springMVC", new DispatcherServlet(mvcCtx));
		dispatchServlet.setLoadOnStartup(1);
		dispatchServlet.setAsyncSupported(true);
		dispatchServlet.addMapping("/");
		return mvcCtx;
	}
	
	
	
	
	private void initializeSpringConfig(ServletContext webContainer){
		AnnotationConfigWebApplicationContext appCtx=new AnnotationConfigWebApplicationContext();
		appCtx.register(AppConfiguration.class);//load spring application configuration
		webContainer.addListener(new ContextLoaderListener(appCtx));
		
	}
	
	
	
	
	
}
