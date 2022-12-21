package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

public class LoginServlet extends HttpServlet{
	
	public void doPost(HttpServletRequest req, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String uname=req.getParameter("nm");
		String pass=req.getParameter("passwd");
		LoginService ls=new LoginServiceImpl();
		User u=ls.validateUser(uname,pass);
		if(u!=null) {
			//valid user
			if(u.getRole().equals("admin")) {
                  RequestDispatcher rd=req.getRequestDispatcher("displayall");
                  rd.forward(req, response);
			}else {
				RequestDispatcher rd=req.getRequestDispatcher("categories");
                rd.forward(req, response);
			}
		}else {
			//invalid user
			out.println("invalid credentials");
			
			RequestDispatcher rd=req.getRequestDispatcher("login.html");
            rd.include(req, response);
           // out.println("pls relogin");
		}
		
	}

}
