package com.bjy.lotus.domain;

public class Cource {
	private Integer id;
	private String courceName;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourceName() {
		return courceName;
	}
	public void setCourceName(String courceName) {
		this.courceName = courceName;
	}
	@Override
	public String toString() {
		return "Cource [id=" + id + ", courceName=" + courceName + "]";
	}
	
}
