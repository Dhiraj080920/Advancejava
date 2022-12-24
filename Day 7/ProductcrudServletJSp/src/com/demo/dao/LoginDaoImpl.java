package com.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.demo.beans.User;

public class LoginDaoImpl implements LoginDao{
	static Connection con;
	static PreparedStatement getUser;
	static {
		con=DBUtil.getMyConnection();
		try {
			getUser=con.prepareStatement
			("select * from user where uname=? and password=?");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	@Override
	public User authenticateUser(String uname, String password) {
		
		try {
			getUser.setString(1, uname);
			getUser.setString(2, password);
			ResultSet rs = getUser.executeQuery();
			if(rs.next()) {
				return new User(rs.getString(1),
						rs.getString(2), rs.getString(3));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
