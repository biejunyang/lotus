package com.bjy.lotus.common.web.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bjy.lotus.common.web.service.TestService;

@Controller
@RestController
public class TestController implements ApplicationContextAware{
	
	private ApplicationContext appCtx;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/hello")
	public String hello(String name){
		String value=testService.sayHello(name);
		System.out.println(value);	
		
		return value;
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.appCtx=applicationContext;
	}
}
