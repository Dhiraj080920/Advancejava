package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class FinalizeOrder
 */
@WebServlet("/finalizeorder")
public class FinalizeOrder extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		out.println("<h3>Payment done successfully</h3>");
		out.println("<h3>order will be delivered in 4 days</h3>");
		//store list details into order table
		HttpSession session=request.getSession();
		System.out.println("invalidating the session");
		session.invalidate();
		
	}

}
