package com;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginAction extends Action{

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		 String name=request.getParameter("uname");
		 if(name.equals("ramu")){
		      return "login.success";
		 }
		 else{
		     return "login.register";
		 }
		 
		}
	}
	


