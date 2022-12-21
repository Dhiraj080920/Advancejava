package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.beans.User;

public class ProductDaoImpl implements ProductDao{
	static Connection con;
	static PreparedStatement psel,pins,pdel,pselById,pupdate,plogin,pselByCatid,csel;
	static {
		try {
			con=DBUtil.getMyConnection();
			pselByCatid=con.prepareStatement("select * from product where cid=?");
			plogin=con.prepareStatement("select * from user where uname=? and pass=?");
			psel=con.prepareStatement("select * from product");
			csel=con.prepareStatement("select * from category");
			pins=con.prepareStatement("insert into product values(?,?,?,?,?)");
			pdel=con.prepareStatement("delete from  product where pid=?");
			pselById=con.prepareStatement("select * from product where pid=?");
			pupdate=con.prepareStatement("update product set pname=?,qty=?,price=?,cid=? where pid=?");
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> findAllProduct() {
		List<Product> plist=new ArrayList<>();
		try {
			ResultSet rs=psel.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
			}
			if(plist.size()>0)
				return plist;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public void saveProduct(Product product) {
		try {
			pins.setInt(1, product.getPid());
			pins.setString(2, product.getPname());
			pins.setInt(3, product.getQty());
			pins.setDouble(4, product.getPrice());
			pins.setInt(5, product.getCid());
			pins.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
	@Override
	public void removeProduct(int pid) {
		try {
			pdel.setInt(1, pid);
			pdel.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	@Override
	public Product FindById(int id) 
	{
		try {
			pselById.setInt(1, id);
			ResultSet rs=pselById.executeQuery();
			if(rs.next()) {
				return new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5));
			}
		}
		 catch (SQLException e) 
		{
			
			System.out.println(e.getMessage());
		}
		
		return null;
	}

	@Override
	public void modifyById(Product p) 
	{
		
		try {
			pupdate.setString(1, p.getPname());
			pupdate.setInt(2, p.getQty());
			pupdate.setDouble(3, p.getPrice());
			pupdate.setInt(4, p.getCid());
			pupdate.setInt(5, p.getPid());
			pupdate.executeUpdate();
		} catch (SQLException e) 
		{
		
			e.printStackTrace();
		}
		
	}
	@Override
	public User validateUser(String uname, String pass) {
		try {
			plogin.setString(1,uname);
			plogin.setString(2, pass);
			ResultSet rs=plogin.executeQuery();
			if(rs.next()) {
				User u=new User(rs.getString(1),rs.getString(2),rs.getString(3));
				return u;
			}
		} catch (SQLException e) {
			
			System.out.println(e.getMessage());
		}
		
		
		return null;
	}
	@Override
	public List<Product> getByCategory(int catid) 
	{
		try {
			List<Product> plist=new ArrayList<>();
			pselByCatid.setInt(1, catid);
			ResultSet rs=pselByCatid.executeQuery();
			while(rs.next()) {
				plist.add(new Product(rs.getInt(1),rs.getString(2),rs.getInt(3),rs.getDouble(4),rs.getInt(5)));
			}
			if(plist.size()>0)
			   return plist;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<Category> getAllCategory() {
		List<Category> clist = new ArrayList<>();
		try {
			ResultSet rs = csel.executeQuery();
			while(rs.next()) {
				clist.add(new Category(rs.getInt(1),rs.getString(2)));
			}
			if(clist.size()>0) {
				return clist;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
