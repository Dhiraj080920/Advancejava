package com.demo.service;

import com.demo.beans.User;
import com.demo.dao.ProductDao;
import com.demo.dao.ProductDaoImpl;



public class LoginServiceImpl implements LoginService{
	private ProductDao loginDao;
	public LoginServiceImpl() 
	{
	    loginDao=new ProductDaoImpl();
	}
	@Override
	public User validateUser(String uname, String pass) {
		return loginDao.validateUser(uname,pass);
}
}