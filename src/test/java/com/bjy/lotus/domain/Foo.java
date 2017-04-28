package com.bjy.lotus.domain;

import java.util.Date;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Foo {
	
	@Value("zhagnsan")
	private String name;
	
	@Value("20")
	private int age;
	
//	@DateTimeFormat(iso=ISO.DATE_TIME, pattern="yyyy-MM-dd HH:mm:ss")
//	@Value("2015-10-15 15:15:15")
	private Date birthday;
	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	
	@Override
	public String toString() {
		return "name:"+this.name+",age:"+this.age+",birthday:"+this.birthday;
	}
	
}
