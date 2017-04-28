package com.bjy.lotus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.env.Environment;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.stereotype.Controller;

import com.bjy.lotus.converter.DateConverter;
import com.bjy.lotus.formatter.MyDateFormatter;


@Configuration
@ImportResource("classpath:/test-context.xml")
@ComponentScan(basePackages="com.bjy.lotus", 
	excludeFilters={@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(Configuration.class)})
@PropertySources({@PropertySource("classpath:/application.properties")})
public class TestConfiguration {

	@Autowired
	private Environment env;
	
	
	/**
	 * PropertEditor配置
	 
	@Bean
	public static CustomEditorConfigurer CustomEditorConfigurer(){
		CustomEditorConfigurer customEditorConfigurer=new CustomEditorConfigurer();
		
		//设置无效，在xml配置中有效
//		Map<Class<?>, Class<? extends PropertyEditor>> customEditors=new HashMap<Class<?>, Class<? extends PropertyEditor>>();
//		customEditors.put(ExoticType.class, ExoticTypeEditor.class);
//		customEditors.put(String.class, UpStringEditor.class);
		//设置无效，在xml配置中有效
		
		customEditorConfigurer.setPropertyEditorRegistrars(new PropertyEditorRegistrar[]{
				new PropertyEditorRegistrar(){
					@Override
					public void registerCustomEditors(PropertyEditorRegistry registry) {
						registry.registerCustomEditor(Date.class, new DateTimeEditor("yyyy-MM-dd HH:mm:ss"));
					}
				},
				new PropertyEditorRegistrar(){
					@Override
					public void registerCustomEditors(PropertyEditorRegistry registry) {
						registry.registerCustomEditor(String.class, new UpStringEditor());
					}
				},
				new PropertyEditorRegistrar(){
					@Override
					public void registerCustomEditors(PropertyEditorRegistry registry) {
						registry.registerCustomEditor(ExoticType.class, new ExoticTypeEditor());
					}
				}
		});
		return customEditorConfigurer;
	}
	*/
	
	
	
	/**
	 * 完整的Converter和Formatter配置
	 */
	@Bean(name="conversionService")
	public ConversionService defaultConversionService(){
		DefaultFormattingConversionService defaultConversionService=new DefaultFormattingConversionService(true);
		defaultConversionService.addConverter(new DateConverter(env.getProperty("common.date.format", "yyyy-MM-dd HH:mm:ss")));
		defaultConversionService.addFormatter(new MyDateFormatter(env.getProperty("common.date.format", "yyyy-MM-dd HH:mm:ss")));
		return defaultConversionService;
	}
	
	
	
	/**
	 * Spring类型转换配置
	 * @return
	
	@Bean(name="conversionService")
	public FormattingConversionServiceFactoryBean conversionServiceFactoryBean(){
		FormattingConversionServiceFactoryBean conversionServiceFactoryBean=new FormattingConversionServiceFactoryBean();
		Set<Object> converters=new HashSet<Object>();
		converters.add(new DateConverter(env.getProperty("common.date.format", "yyyy-MM-dd HH:mm:ss")));
		conversionServiceFactoryBean.setConverters(converters);
		return conversionServiceFactoryBean;
	}
	 */
	
	/**
	 * Spring类型转换配置
	 * @return
	 */
//	@Bean(name="conversionService")
//	public DefaultConversionService defaultConversionService(){
//		DefaultConversionService conversionService=new DefaultConversionService();
//		conversionService.addConverter(new DateConverter(env.getProperty("common.date.format", 
//				"yyyy-MM-dd HH:mm:ss")));
//		return conversionService;
//	}
	
	/**
	 * Spring Formatter配置
	 * @return
	 */
//	@Bean(name="conversionService")
//	public DefaultFormattingConversionService defaultFormattingConversionService(){
//		DefaultFormattingConversionService conversionService=new DefaultFormattingConversionService();
//		conversionService.addConverter(new DateConverter(env.getProperty("common.date.format", 
//				"yyyy-MM-dd HH:mm:ss")));
//		return conversionService;
//	}
}
