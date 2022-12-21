package com.demo.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProduct
 */
@WebServlet("/update")
public class UpdateProduct extends HttpServlet 
{
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int qty=Integer.parseInt(request.getParameter("qty"));
		double price=Double.parseDouble(request.getParameter("price"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		Product p=new Product(id,pname,qty,price,cid);
		ProductService pservice=new ProductServiceImpl();
		pservice.updateById(p);
		RequestDispatcher rd=request.getRequestDispatcher("displayall");
		rd.forward(request, response);
	
	}

}
