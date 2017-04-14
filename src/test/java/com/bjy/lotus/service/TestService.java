package com.bjy.lotus.service;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;

@Service
public class TestService implements ApplicationContextAware{
	private ApplicationContext applicationContext;
	
	
	public String sayHello(String name){
		return "hello"+name;
	}
	
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}



	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
