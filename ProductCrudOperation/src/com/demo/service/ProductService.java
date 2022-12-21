package com.demo.service;

import java.util.List;

import com.demo.beans.Category;
import com.demo.beans.Product;

public interface ProductService {

	List<Product> getAllProduct();

	void inserproduct(Product product);

	void deleteProduct(int pid);

	Product getById(int id);

	void updateById(Product p);

	List<Product> getByCategory(int catid);

	List<Category> getAllCategory();

	


}
