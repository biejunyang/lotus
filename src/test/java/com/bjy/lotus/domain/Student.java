package com.bjy.lotus.domain;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

@JsonAutoDetect(fieldVisibility=Visibility.ANY)
public class Student {

	private Integer id;
	private String name;
	private Integer age;
	
	@JsonFormat(pattern="yyyy-MM-dd")
	private Date birthday;
	private Double weight;
	
	@JsonProperty("start-time")
	@JsonFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Timestamp startTime;
	private Sex sex;
	private List<String> enjoyes;
	private List<Cource> cources;
	
	@JsonUnwrapped
	private Name ename;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}
	
	
	public Student(Integer id, String name, Integer age, Date birthday, Double weight, Timestamp startTime) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.birthday = birthday;
		this.weight = weight;
		this.startTime = startTime;
	}


	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public Double getWeight() {
		return weight;
	}
	public void setWeight(Double weight) {
		this.weight = weight;
	}
	public Timestamp getStartTime() {
		return startTime;
	}
	public void setStartTime(Timestamp startTime) {
		this.startTime = startTime;
	}
	
	public Sex getSex() {
		return sex;
	}


	public void setSex(Sex sex) {
		this.sex = sex;
	}

	
	public List<String> getEnjoyes() {
		return enjoyes;
	}


	public void setEnjoyes(List<String> enjoyes) {
		this.enjoyes = enjoyes;
	}
	
	public List<Cource> getCources() {
		return cources;
	}


	public void setCources(List<Cource> cources) {
		this.cources = cources;
	}


	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", age=" + age + ", birthday=" + birthday + ", weight=" + weight
				+ ", startTime=" + startTime + ", sex=" + sex + ", enjoyes=" + enjoyes + ", cources=" + cources
				+ ", ename=" + ename + "]";
	}


	









	public Name getEname() {
		return ename;
	}


	public void setEname(Name ename) {
		this.ename = ename;
	}












	public static enum Sex{
		MAN, WOMAN
	}
}
