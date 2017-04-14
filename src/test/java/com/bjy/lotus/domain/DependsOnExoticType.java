package com.bjy.lotus.domain;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class DependsOnExoticType {
	
	@Value("aNameForExoticType")
	private ExoticType type;

	public ExoticType getType() {
		return type;
	}

	public void setType(ExoticType type) {
		this.type = type;
	}
	
}
