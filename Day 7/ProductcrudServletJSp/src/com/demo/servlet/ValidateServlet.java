package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.User;
import com.demo.service.LoginService;
import com.demo.service.LoginServiceImpl;

/**
 * Servlet implementation class ValidateServlet
 */
@WebServlet("/validateservlet")
public class ValidateServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uname=request.getParameter("uname");
		String password=request.getParameter("pass");
		LoginService lservice = new LoginServiceImpl();
		User user=lservice.validateUser(uname,password);
		
		if(user!=null) {
			HttpSession session = request.getSession();
			session.setAttribute("user", user);
			RequestDispatcher rd=request.getRequestDispatcher
					("displayAll");
			rd.forward(request, response);
		}
		else {
			PrintWriter out = response.getWriter();
			response.setContentType("text/html");
			RequestDispatcher rd=request.
					getRequestDispatcher("login.jsp");
			out.println(""
			+ "<h3>Please re-enter the credentials</h3>");
			rd.include(request, response);
		}
		
		
	}

}
