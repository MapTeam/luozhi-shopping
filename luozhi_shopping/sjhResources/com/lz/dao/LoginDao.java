package com.lz.dao;

import java.sql.Connection;

import com.lz.pojo.User;

public interface LoginDao {
	/**
	 * 验证登录
	 * @param conn
	 * @param uname
	 * @param upwd
	 * @return
	 */
	public User login(Connection conn,String uname,String upwd);
}	
