package com.bjy.lotus.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanWrapperImpl;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bjy.lotus.service.TestService;

@Controller
public class TestController implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private TestService testService;
	
	BeanWrapperImpl s;
	
	@RequestMapping("/hello")
	public String hello(String name, Model model, HttpServletRequest req){
		model.addAttribute("name", name);
		testService.sayHello(name);
		System.out.println(req.getContentType());
		return "test";
	}
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
}
