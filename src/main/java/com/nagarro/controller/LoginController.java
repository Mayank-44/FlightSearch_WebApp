package com.nagarro.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.nagarro.dao.AuthenticateUser;
import com.nagarro.model.User;

/**
 * @author mayankgangwar
 * class to handle the login request from client
 */
@Controller
public class LoginController {
	
	@Autowired
	AuthenticateUser auth;
	
	@RequestMapping(value="login", method=RequestMethod.POST)
	public void login(@RequestParam("uname") String uname,@RequestParam("password") String password
						,HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		HttpSession session = request.getSession();
		User user = auth.authenticate(uname,password); 
		if(user != null)
		{	
			session.setAttribute("uname", uname);
			System.out.println(user.getUsername()+" successfully Logged In.\n");
		}
		else
		{
			System.out.println("Invalid Credentials. Please try again!!!\n");
			request.getRequestDispatcher("index.jsp").forward(request, response);
			return;
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("display.jsp");
		rd.forward(request, response);
	}
}
