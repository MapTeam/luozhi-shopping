package com.lz.dao;

import java.sql.Connection;

import com.lz.pojo.User;

public interface LoginDao {
	public User login(Connection conn,String uname,String upwd);
}	
