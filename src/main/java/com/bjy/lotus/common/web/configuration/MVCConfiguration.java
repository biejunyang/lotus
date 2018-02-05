package com.bjy.lotus.common.web.configuration;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerView;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

import com.bjy.lotus.common.web.MyWebDataBindingInitializer;

/**
 * Spring Web MVC Context Configuration
 * @author biejunyang
 *
 */
@Configuration
//@EnableWebMvc
@ComponentScan(basePackages="com.bjy.lotus", useDefaultFilters=false, 
	includeFilters=@ComponentScan.Filter(Controller.class))
@PropertySources({@PropertySource("classpath:/application.properties")})
public class MVCConfiguration extends WebMvcConfigurationSupport{

	@Autowired
	private Environment env;
	
	
	//添加自定义的转换器，和格式化器
	@Override
	public void addFormatters(FormatterRegistry registry) {
//		registry.addFormatterForFieldAnnotation(new DateTimeFormatAnnotationFormatterFactory());
	}
	
	
	//添加自定义的HttpMesageConverter
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		// TODO Auto-generated method stub
		super.configureMessageConverters(converters);
	}
	
	
	
	@Override
	protected ConfigurableWebBindingInitializer getConfigurableWebBindingInitializer() {
		ConfigurableWebBindingInitializer initializer = new MyWebDataBindingInitializer();
		initializer.setConversionService(mvcConversionService());
		initializer.setValidator(mvcValidator());
		initializer.setMessageCodesResolver(getMessageCodesResolver());
		return initializer;
	}
	
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
	
	
	/**
	 * 映射静态资源文件
	 */
	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/assets/**").addResourceLocations("classpath:/assets/");
		registry.addResourceHandler("/assets/**").addResourceLocations("/resources/");
	}
 
	
}
