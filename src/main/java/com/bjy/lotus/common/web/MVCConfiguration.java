package com.bjy.lotus.common.web;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/**
 * Spring Web MVC Context Configuration
 * @author biejunyang
 *
 */
@Configuration
@EnableWebMvc
//@ComponentScan(basePackages="com.bjy.lotus", useDefaultFilters=false, includeFilters=@ComponentScan.Filter(Controller.class))
@ComponentScan(basePackages="com.bjy.lotus")
public class MVCConfiguration extends WebMvcConfigurerAdapter{

	
	
}
