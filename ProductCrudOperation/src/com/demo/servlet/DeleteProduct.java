package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteproduct")
public class DeleteProduct extends HttpServlet 
{
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	int pid=Integer.parseInt(request.getParameter("id"));	
	ProductService pservice=new ProductServiceImpl();
	pservice.deleteProduct(pid);
	RequestDispatcher rd=request.getRequestDispatcher("displayall");
	rd.forward(request, response);
	
	  
	}

}
