package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/displayall")
public class DisplayAllProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getAllProduct();
		out.println("<a href='addproduct'>Add Product</a>");
		out.println("<table border='2'><tr><th>Id</th><th>Name</th><th>qty</th>");
		out.println("<th>price</th><th>cid</th><th>operations</th></tr>");
		for(Product p :plist) {
			out.println("<tr><td>"+p.getPid()+"</td><td><a href=ProductDescription?name="+p.getPname()+">"+p.getPname()+"</a></td><td>"+p.getQty()+"</td><td>"+p.getPrice()+"</td><td>"+p.getCid()+"</td>");
			out.println("<td><a href='deleteproduct?id="+p.getPid()+"'>delete</a> / <a href='edit?id="+p.getPid()+"'>edit</a></td></tr>");
		}
		out.println("</table>");
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}
	
	

}
