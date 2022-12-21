package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class EditProduct
 */
@WebServlet(name = "edit", urlPatterns = { "/edit" })
public class EditProduct extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id=Integer.parseInt(request.getParameter("id"));
		response.setContentType("text/html");	
		ProductService pservice =new ProductServiceImpl();
		Product p=pservice.getById(id);
		PrintWriter out=response.getWriter();
		out.println("<form action='update' method='post'> ");



		out.println("Product Id: <input type='text' name='pid' id='pid' value='"+p.getPid()+"' readonly><br> ");

		out.println("Product name: <input type='text' name='pname' id='pname' value='"+p.getPname()+"'><br> ");

		out.println("Product qty: <input type='text' name='qty' id='qty' value='"+p.getQty()+"'><br> ");

		out.println("Product price: <input type='text' name='price' id='price' value='"+p.getPrice()+"'> <br>");

		out.println("Product cid: <input type='text' name='cid' id='cid' value='"+p.getCid()+"'> ");

		out.println("<button type='submit' name='btn' id='btn' value='update'>Update Product</button> ");

		out.print("</form>");
		
		}

}
