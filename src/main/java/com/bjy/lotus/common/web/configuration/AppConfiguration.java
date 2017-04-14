package com.bjy.lotus.common.web.configuration;

import java.io.IOException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.freemarker.FreeMarkerConfigurationFactory;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import freemarker.template.TemplateException;

/**
 * Spring Application Context Configuration
 * @author biejunyang
 *
 */
@Configuration
@PropertySources({@PropertySource("classpath:/application.properties")})
@ComponentScan(basePackages="com.bjy.lotus", 
	excludeFilters={@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(Configuration.class)})
public class AppConfiguration {
	
	@Autowired
	private Environment env;
	
	
	/**
	 * Freemarker模板设置
	 * @return
	 * @throws TemplateException 
	 * @throws IOException 
	 */
	@Bean
	public FreeMarkerConfigurer freeMarkerConfigurer(FreeMarkerConfigurationFactory configurationFactory) throws IOException, TemplateException{
		FreeMarkerConfigurer freeMarkerConfigurer=new FreeMarkerConfigurer();
		freemarker.template.Configuration config=configurationFactory.createConfiguration();
		config.setDateTimeFormat(env.getProperty("freemarker.dateTimeFormat", "yyyy-MM-dd HH:mm:ss"));
		config.setDateFormat(env.getProperty("freemarker.dateFormat", "yyyy-MM-dd"));
		config.setNumberFormat(env.getProperty("freemarker.numberFormt", "#.##"));
		config.setLocale(Locale.forLanguageTag(env.getProperty("freemarker.locale", "zh_CN")));
		freeMarkerConfigurer.setConfiguration(config);
		return freeMarkerConfigurer;
	}
	
	/**
	 * Freemarker配置工厂
	 * @return
	 */
	@Bean
	public FreeMarkerConfigurationFactory freeMarkerConfigurationFactory(){
		FreeMarkerConfigurationFactory configurationFactory=new FreeMarkerConfigurationFactory();
		configurationFactory.setDefaultEncoding(env.getProperty("view.freemarker.defaultEncoding", "utf-8"));
		configurationFactory.setTemplateLoaderPath(env.getProperty("view.freemarker.templatePath", "/WEB-INF/templates/"));
		return configurationFactory;
	}
	
}
