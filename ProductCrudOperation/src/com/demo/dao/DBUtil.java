package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	static Connection con=null;
	static Connection getMyConnection() 
	{
		if(con==null) {
			try {
				DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
				String url="jdbc:mysql://192.168.10.109:3306/dac49?useSSL=false";
				String username="dac49";
				String password="welcome";
				con=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
		}
		return con;
		
	}
	static void closeMyConnection() {
		try {
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
