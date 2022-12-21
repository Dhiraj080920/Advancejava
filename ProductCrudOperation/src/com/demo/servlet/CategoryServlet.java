package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Category;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;


@WebServlet("/categories")
public class CategoryServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		ProductService pservice=new ProductServiceImpl();
		PrintWriter out = response.getWriter();
		out.println("<h2>Select category to see the products</h2>");
		out.println("<form action='findprod'>");
		out.println("<select name='catid'>");
		List<Category> clist = pservice.getAllCategory();
		if(clist!=null) {
		for(Category c:clist) {
		out.println("<option value='"+c.getCatid()+"'>"+c.getCatname()+"</option>");
		}
		}
		out.println("</select>");
		out.println("<button type='submit' name='btn' id='btn' value='find'  >Find products</button>");
		out.println("<button type='submit' name='btn' id='btn' value='payment' >Place order</button>");
		out.println("</form>");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
