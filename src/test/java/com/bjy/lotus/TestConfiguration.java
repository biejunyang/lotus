package com.bjy.lotus;

import java.beans.PropertyEditor;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.PropertyEditorRegistrar;
import org.springframework.beans.PropertyEditorRegistry;
import org.springframework.beans.factory.config.CustomEditorConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;

import com.bjy.lotus.domain.ExoticType;
import com.bjy.lotus.editor.DateTimeEditor;
import com.bjy.lotus.editor.ExoticTypeEditor;
import com.bjy.lotus.editor.UpStringEditor;


@Profile("test")
@Configuration
@ImportResource("classpath:/test-context.xml")
@ComponentScan(basePackages="com.bjy.lotus", 
	excludeFilters={@ComponentScan.Filter(Controller.class), @ComponentScan.Filter(Configuration.class)})
public class TestConfiguration {

	
	@Bean
	public CustomEditorConfigurer CustomEditorConfigurer(){
		CustomEditorConfigurer customEditorConfigurer=new CustomEditorConfigurer();
		
		Map<Class<?>, Class<? extends PropertyEditor>> customEditors=new HashMap<Class<?>, Class<? extends PropertyEditor>>();
		
		//设置无效，在xml配置中有效
		customEditors.put(ExoticType.class, ExoticTypeEditor.class);
		customEditors.put(String.class, UpStringEditor.class);
		
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
}
