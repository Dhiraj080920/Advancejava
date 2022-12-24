package com.demo.service;

import java.util.List;

import com.demo.beans.Product;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;

public class ProductServiceImpl implements ProductService
{
	private ProductDao pdao;

	public ProductServiceImpl() {
		super();
		this.pdao = new ProductDaoImpl();
	}

	@Override
	public List<Product> getAllProduct() {
		return pdao.findAllProduct();
	}

	@Override
	public void inserproduct(Product product) {
		pdao.saveProduct(product);
		
	}

	@Override
	public void deleteProduct(int pid) {
		pdao.removeProduct(pid);
		
	}

	@Override
	public Product getById(int id) {
		return pdao.findById(id);
	}

	@Override
	public void updateById(Product p) {
		pdao.modifyById(p);
		
	}
	

}
