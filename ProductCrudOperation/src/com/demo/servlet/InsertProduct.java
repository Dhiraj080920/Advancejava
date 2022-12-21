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
 * Servlet implementation class InsertProduct
 */
@WebServlet("/insertproduct")
public class InsertProduct extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int pid=Integer.parseInt(request.getParameter("pid"));
		String pname=request.getParameter("pname");
		int qty=Integer.parseInt(request.getParameter("qty"));
		int cid=Integer.parseInt(request.getParameter("cid"));
		double price=Double.parseDouble(request.getParameter("price"));
		ProductService pservice=new ProductServiceImpl();
		pservice.inserproduct(new Product(pid,pname,qty,price,cid));
		RequestDispatcher rd=request.getRequestDispatcher("displayall");
		rd.forward(request, response);
	}

}
