package com.demo.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.demo.beans.Product;
import com.demo.service.ProductService;
import com.demo.service.ProductServiceImpl;

/**
 * Servlet implementation class ProductDetails
 */
@WebServlet("/findprod")
public class ProductDetails extends HttpServlet 
{
    public ProductDetails() 
    {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String btn=request.getParameter("btn");
		
		if(btn.equals("find")) 
		{	
		int catid= Integer.parseInt(request.getParameter("catid"));
		ProductService pservice=new ProductServiceImpl();
		List<Product> plist=pservice.getByCategory(catid);
		out.println("<form action='generatecart' method='get'>");
		int cnt=1;
		for(Product p:plist) 
		{
			String str=p.getPid()+":"+p.getPname()+":"+p.getPrice();  ///1:lays:40
			out.println("<input type='checkbox' name='prod' id='p"+cnt+"' value='"+str+"'><label for='p"+cnt+"'>"+p.getPname()+"-----"+p.getPrice()+"<lable><br>");
			cnt++;
		}	
			out.println("<button type='submit' name='btn' id='btn'>Add to cart</button>");
			out.print("</form>");
		
		}
	    else if (btn.equals("payment"))
	{
		RequestDispatcher rd=request.getRequestDispatcher("generatebill");
		rd.forward(request, response);
	}
	
}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}
}