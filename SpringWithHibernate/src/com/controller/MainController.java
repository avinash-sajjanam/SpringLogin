package com.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.dao.UserInfo;
import com.daoImpl.UserInfoImpl;
import com.model.User;

@Controller
public class MainController {
	
@Autowired
	

	UserInfo userinfo;
	UserInfoImpl userinfoimpl;
@RequestMapping(value="/register",method=RequestMethod.POST)

	public void LoginCheck (HttpServletRequest request, HttpServletResponse response){
//	Random random=new Random();
	String username=request.getParameter("uname");
	String password=request.getParameter("pass");
	
	System.out.println(username);
	try{
		User user=new User();
//		user.setId(random.nextInt());
		user.setUsername(username);
		user.setPassword(password);
		
		userinfo.save(user);
		
	}catch(Exception e){
		e.printStackTrace();
	}
	

		
	}
@RequestMapping(value="/logincheck",method=RequestMethod.POST)

	public void UserValidation(HttpServletRequest request, HttpServletResponse response){
	String username=request.getParameter("uname");
	String password=request.getParameter("pass");
	
	try{
		User user=new User();
		user.setUsername(username);
		user.setPassword(password);
		
		userinfo.checkUser(user);
	}catch(Exception e){
		e.printStackTrace();
	}
	

	
	
}

}
