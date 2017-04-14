package com.bjy.lotus.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.bjy.lotus.domain.Foo;

public class PersonValidator implements Validator{
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return Foo.class.equals(clazz);
	}
	
	
	@Override
	public void validate(Object target, Errors errors) {
		ValidationUtils.rejectIfEmpty(errors, "name", "person.name.empty");
		Foo p=(Foo)target;
		if(p.getAge()<0){
			errors.rejectValue("age", "negativevalue");
		}else if(p.getAge()>150){
			errors.rejectValue("age", "too.darn.old");
		}
	}
}
