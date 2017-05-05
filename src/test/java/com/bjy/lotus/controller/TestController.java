package com.bjy.lotus.controller;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bjy.lotus.common.web.controller.BaseController;
import com.bjy.lotus.domain.Person;
import com.bjy.lotus.service.TestService;

@Controller
public class TestController  extends BaseController implements ApplicationContextAware{
	
	private ApplicationContext applicationContext;
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/hello")
	public String hello(String name, Model model){
		model.addAttribute("name", name);
		testService.sayHello(name);
		System.out.println(request.getContentType());
		return "test";
	}
	
//	@RequestMapping("/hello/{name}/{age}")
//	public String hello2(@PathVariable String name, @PathVariable Integer age){
//		
//		testService.sayHello(name);
//		return "test";
//	}
	
//	@RequestMapping("/hello/{name}/{age}")
//	public String hello2(@PathVariable Map<String, Object> map){
//		
//		System.out.println(map);
//		return "test";
//	}
	
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
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(@RequestParam MultiValueMap<String, List<String>> personInfo){
//		System.out.println(personInfo.get("names").getClass());
//		return "test";
//	}
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson(@ModelAttribute(name="name") String name, 
//			@ModelAttribute(name="age") Integer age, 
//			@ModelAttribute(name="birthday") @DateTimeFormat(pattern="yyyy-MM-dd")Date birthday, 
//			Model model){
//		System.out.println(model);
//		return "test";
//	}
//	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson2(Person person22, Model model){
//		System.out.println(model);
//		return "test";
//	}
	
	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson3(Person person, Model model){
//		System.out.println(model);
//		return "test";
//	}
//	
//	
//	@RequestMapping("/savePerson")
//	@ResponseBody
//	public String savePerson3(@ModelAttribute("name") String[] names, Model model){
//		System.out.println(model);
//		return "test";
//	}
	
	@RequestMapping("/savePerson")
	@ResponseBody
	public String savePerson3(@RequestBody Person person, Model model){
		System.out.println(model);
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
