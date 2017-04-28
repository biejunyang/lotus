package com.bjy.lotus.converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;
import org.springframework.util.StringUtils;

public class DateConverter implements Converter<String, Date>{
	private String dateFormat="yyyy-MM-dd hh:mm:ss";
	private boolean allowEmpty=true;
	
	public DateConverter(String dateFormat) {
		this.dateFormat=dateFormat;
	}
	
	@Override
	public Date convert(String source) {
		if(StringUtils.isEmpty(source) && !allowEmpty){
			throw new IllegalArgumentException("the source is empty, can not convert to Date");
		}
		if(!StringUtils.isEmpty(source)){
			System.out.println("Date converter performed!!!!");
			DateFormat formatter=new SimpleDateFormat(dateFormat);
			try {
				return formatter.parse(source);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return null;
	}
}
