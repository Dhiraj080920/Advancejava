package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;
import com.demo.beans.User;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

	
@WebServlet("/displayAll")
public class DisplayAllProducts extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		User user=(User)session.getAttribute("user");
		if(user!=null && user.getRole().equals("admin")) {
			ProductService pservice = new ProductServiceImpl();
			List<Product> plist= pservice.getAllProduct();
			request.setAttribute("plist", plist);
			RequestDispatcher rd = request.
					getRequestDispatcher("displayAll.jsp");
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
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
