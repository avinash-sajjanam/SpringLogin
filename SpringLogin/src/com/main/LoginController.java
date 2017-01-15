package com.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String user= request.getParameter("username");
		String Pass= request.getParameter("password");
		//PrintWriter writer = null;
    ApplicationContext context= new ClassPathXmlApplicationContext("Login.xml");
	Login login= (Login) context.getBean("login");
		
		if(Pass.equals("admin")){
			System.out.println(login.getSuccess());
			response.sendRedirect("Success.jsp");
		}
		else{
			System.out.println(login.getDenied());	
			response.sendRedirect("Login.jsp");
			
		}
	}

}
