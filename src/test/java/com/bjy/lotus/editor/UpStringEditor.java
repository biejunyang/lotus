package com.bjy.lotus.editor;

import java.beans.PropertyEditorSupport;

import org.springframework.util.StringUtils;

public class UpStringEditor extends PropertyEditorSupport{
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(StringUtils.isEmpty(text) ? "" : text.toUpperCase());
	}
	
}
