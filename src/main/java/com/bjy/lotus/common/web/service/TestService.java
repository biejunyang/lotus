package com.bjy.lotus.common.web.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ApplicationContextAware{
	private ApplicationContext appCtx;
	
	
	public String sayHello(String name){
		System.out.println(appCtx);
		return "hello"+name;
	}
	
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx=applicationContext;
	}
	
}
