package com.bjy.lotus.domain;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

public class Person {
	private String name;
	private String age;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private Float weight;
	private Sex sex;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date startTime;
	
	private List<String> enjoys;
	private List<Foo> foos;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Float getWeight() {
		return weight;
	}
	public void setWeight(Float weight) {
		this.weight = weight;
	}
	public Sex getSex() {
		return sex;
	}
	public void setSex(Sex sex) {
		this.sex = sex;
	}

	public enum Sex{
		MAN, WOMAN, UNKNOW
	}
	
	public Date getStartTime() {
		return startTime;
	}
	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}
	
	
	
	public List<String> getEnjoys() {
		return enjoys;
	}
	public void setEnjoys(List<String> enjoys) {
		this.enjoys = enjoys;
	}
	
	
	public List<Foo> getFoos() {
		return foos;
	}
	public void setFoos(List<Foo> foos) {
		this.foos = foos;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "name:"+name+", age:"+age+", sex:"+sex+", weight:"+weight+", birthday:"+birthday;
	}
	
}
