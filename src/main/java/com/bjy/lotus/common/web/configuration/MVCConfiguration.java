package com.bjy.lotus.common.web.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Spring Web MVC Context Configuration
 * @author biejunyang
 *
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages="com.bjy.lotus", useDefaultFilters=false, 
	includeFilters=@ComponentScan.Filter(Controller.class))
@PropertySources({@PropertySource("classpath:/application.properties")})
public class MVCConfiguration extends WebMvcConfigurerAdapter{

	@Autowired
	private Environment env;
	
	
	
	/**
	 * JSP视图解析器
	 * @return
	 */
	@Bean
	public InternalResourceViewResolver internalResourceViewResolver(){
		InternalResourceViewResolver internalViewResolver=new InternalResourceViewResolver("/WEB-INF/views/", ".jsp");
		internalViewResolver.setViewClass(JstlView.class);
		internalViewResolver.setPrefix(env.getProperty("view.jsp.prefix", "/WEB-INF/views/"));
		internalViewResolver.setSuffix(env.getProperty("view.jsp.suffix", ".jsp"));
		internalViewResolver.setOrder(env.getRequiredProperty("view.jsp.order", Integer.class));
		return internalViewResolver;
	}
	
	
	
	/**
	 * FreeMarker视图解析器
	 * @return
	 */
	@Bean
	public FreeMarkerViewResolver freeMarkerViewResolver(){
		FreeMarkerViewResolver freeMarkerViewResolver=new FreeMarkerViewResolver();
		freeMarkerViewResolver.setViewClass(FreeMarkerView.class);
		freeMarkerViewResolver.setCache(true);
		freeMarkerViewResolver.setContentType(env.getProperty("freemarker.contentType", "text/html;charset=utf-8"));
		freeMarkerViewResolver.setSuffix(env.getProperty("freemarker.suffix", ".ftl"));
		freeMarkerViewResolver.setExposeRequestAttributes(true);
		freeMarkerViewResolver.setExposeSessionAttributes(true);
		freeMarkerViewResolver.setOrder(env.getRequiredProperty("freemarker.order", Integer.class));
		return freeMarkerViewResolver;
	}
	
	
 
	
}
