package com.bjy.lotus.formatter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.util.StringUtils;

public class MyDateFormatter implements Formatter<Date>{
	private String patter="yyyy-MM-dd HH:mm:ss";
	
	public MyDateFormatter(String pattern) {
		this.patter=pattern;
	}
	@Override
	public Date parse(String text, Locale locale) throws ParseException {
		if(StringUtils.isEmpty(text))
			return null;
		System.out.println("Formatter performed !!!!!");
		return getDateFormat(locale).parse(text);
	}
	
	public String print(Date object, Locale locale) {
		if(object==null)
			return "";
		return getDateFormat(locale).format(object);
	};
	
	
	protected DateFormat getDateFormat(Locale locale) {
		DateFormat dateFormat=new SimpleDateFormat(patter, locale);
		return dateFormat;
	}
}
