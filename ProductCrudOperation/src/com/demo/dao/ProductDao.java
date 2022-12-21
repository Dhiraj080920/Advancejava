package com.demo.dao;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;
import com.demo.beans.User;

public interface ProductDao {

	List<Product> findAllProduct();

	void saveProduct(Product product);

	void removeProduct(int pid);

	Product FindById(int id);

	void modifyById(Product p);
	
	User validateUser(String uname, String pass);
	
	List<Product> getByCategory(int catid);

	List<Category> getAllCategory();

}
