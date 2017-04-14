package com.bjy.lotus.editor;

import java.beans.PropertyEditorSupport;

import com.bjy.lotus.domain.ExoticType;

public class ExoticTypeEditor extends PropertyEditorSupport {
	@Override
	public void setAsText(String text) throws IllegalArgumentException {
		setValue(new ExoticType(text.toUpperCase()));
	}
}
