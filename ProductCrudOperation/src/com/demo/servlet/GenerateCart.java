package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;

/**
 * Servlet implementation class GenerateCart
 */
@WebServlet("/generatecart")
public class GenerateCart extends HttpServlet {
	
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String[] arr=request.getParameterValues("prod");
		
		HttpSession session=request.getSession();
		System.out.println("New session "+session.isNew());
		if(session.isNew()) {
			session.setMaxInactiveInterval(10);
		}
		List<Product> list=(List<Product>) session.getAttribute("cart");
		if(list==null) {
			System.out.println("new list created");
			list=new ArrayList<>();
		}
		if(arr!=null) {
		for(String s:arr) {
			String[] sarr=s.split(":");
			Product p=new Product(Integer.parseInt(sarr[0]),sarr[1],Double.parseDouble(sarr[2]));
			list.add(p);
		}
		session.setAttribute("cart", list);
		}
		else {
			PrintWriter out = response.getWriter();
			out.println("no items selected");
			RequestDispatcher rd=request.getRequestDispatcher("categorydetails.html");
			rd.forward(request,response);
			
		}
		
		RequestDispatcher rd=request.getRequestDispatcher("categorydetails.html");
		rd.forward(request,response);
		
		
	}

}
