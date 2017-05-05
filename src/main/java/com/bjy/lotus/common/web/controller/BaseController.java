package com.bjy.lotus.common.web.controller;

import java.net.HttpCookie;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

public class BaseController {
	protected HttpServletRequest request;
	protected HttpServletResponse response;
	protected HttpSession session;
	protected HttpCookie cookie;
	protected Model model;
	
	
	public void init(HttpServletRequest req, HttpServletResponse resp, 
			HttpSession session, HttpCookie cookie, Model model){
		this.request=req;
		this.response=resp;
		this.session=session;
		this.cookie=cookie;
		this.model=model;
	}
}
