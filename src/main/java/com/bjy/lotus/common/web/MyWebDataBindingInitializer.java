package com.bjy.lotus.common.web;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.support.ConfigurableWebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

public class MyWebDataBindingInitializer extends ConfigurableWebBindingInitializer{
	@Override
	public void initBinder(WebDataBinder binder, WebRequest request) {
		super.initBinder(binder, request);	
		
//		String defaultPattern=SystemContext.getSystemInfo("common.date.format");
//		DateFormat dateFormat=new SimpleDateFormat(defaultPattern);
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	
	
	}
}
