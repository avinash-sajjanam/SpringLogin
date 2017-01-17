package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping(value={"/LoginController"}, method= RequestMethod.POST)
	
	private void view(HttpServletRequest request, HttpServletResponse response){
		
		String user=request.getParameter("uname");
		String pass=request.getParameter("pass");
		try{
			@SuppressWarnings("resource")
			ApplicationContext context=new ClassPathXmlApplicationContext("../Spring-servlet.xml");
			LoginCheck login=(LoginCheck) context.getBean("LoginCheck");
			if(pass.equals("admin")){
				System.out.println(login.getSuccess());
				response.getWriter().write(login.getSuccess());
			}
			else{
				System.out.println(login.getDenied());
				response.getWriter().write(login.getDenied());
			}
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
}
