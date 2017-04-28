package com.bjy.lotus.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjy.lotus.service.TestService;

@Controller
public class TestController implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/hello")
	public String hello(String name, Model model, HttpServletRequest req){
		model.addAttribute("name", name);
		testService.sayHello(name);
		System.out.println(req.getContentType());
		return "test";
	}
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(@RequestParam(name="name")String name23, Integer age, Sex sex, Double weight, 
//			@DateTimeFormat(pattern="yyyy-MM-dd")Date birthday, 
//			@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")Date startTime){
//		System.out.println(name23);
//		return "test";
//	}
	
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(Person person){
//		return "test";
//	}
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(Map<String, Object> personInfo){
//		return "test";
//	}
	
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(Integer[] ages){
//		return "test";
//	}
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(@RequestParam Map<String, String> personInfo){
//		System.out.println(personInfo.get("names").getClass());
//		return "test";
//	}
	
	@RequestMapping("/savePerson")
	@ResponseBody
	public String savePerson(@RequestParam MultiValueMap<String, List<String>> personInfo){
		System.out.println(personInfo.get("names").getClass());
		return "test";
	}
	
	
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext=applicationContext;
	}

	public ApplicationContext getApplicationContext() {
		return applicationContext;
	}
	
//	@InitBinder
//    public void initBinder(WebDataBinder binder, String name) {
//		String defaultPattern=SystemContext.getSystemInfo("common.date.format");
//		DateFormat dateFormat=new SimpleDateFormat(defaultPattern);
		
//		binder.registerCustomEditor(Date.class, "birthday", 
//				new CustomDateEditor(dateFormat, true));
//		binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
//		
//    }
}
