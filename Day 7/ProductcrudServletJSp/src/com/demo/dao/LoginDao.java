package com.demo.dao;

import com.demo.beans.User;

public interface LoginDao {

	User authenticateUser(String uname, String password);
	
}
