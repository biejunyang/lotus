package com.bjy.lotus.editor;

import java.beans.PropertyEditorSupport;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.springframework.util.StringUtils;

public class DateTimeEditor extends PropertyEditorSupport{
	private DateFormat formatter;
	public DateTimeEditor(String pattern){
		this.formatter=new SimpleDateFormat(pattern);
	}
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		if(StringUtils.isEmpty(text))
			setValue(null);
		else{
			try {
				setValue(formatter.parse(text));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}
