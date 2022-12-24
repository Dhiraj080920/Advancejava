package com.demo.service;

import com.demo.beans.User;
import com.demo.dao.LoginDao;
import com.demo.dao.LoginDaoImpl;

public class LoginServiceImpl implements LoginService {
	private LoginDao ldao;
	
	public LoginServiceImpl() {
		this.ldao = new LoginDaoImpl();
	}

	@Override
	public User validateUser(String uname, String password) {
		return ldao.authenticateUser(uname, password);
	}
	
	
}
