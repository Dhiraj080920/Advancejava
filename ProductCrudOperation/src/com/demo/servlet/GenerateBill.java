package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.demo.beans.Product;

/**
 * Servlet implementation class GenerateBill
 */
@WebServlet("/generatebill")
public class GenerateBill extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		List<Product> list=(List<Product>) session.getAttribute("cart");
		if(list!=null) {
			double amount=0;
			out.println("<form action='finalizeorder'>");
			out.println("<table border='2'><tr><th>Id</th><th>name</th><th>price</th></tr>");
			for(Product p:list) {
				out.println("<tr><td>"+p.getPid()+"</td><td>"+p.getPname()+"</td><td>"+p.getPrice()+"</td></tr>");
				amount=amount+p.getPrice();
				
			}
			out.println("<tr><td colspan='2'>Total bill</td><td>"+amount+"</td></tr>");
			out.println("</table>");
			out.println("<button type='submit' name='btn' id='btn'>Pay the bill</button>");
			out.println("</form>");
		}
		
	}

}
