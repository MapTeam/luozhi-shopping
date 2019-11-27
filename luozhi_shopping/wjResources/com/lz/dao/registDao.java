package com.lz.dao;

import com.lz.pojo.User;

public interface registDao {
	public boolean registSelectByName(String name);
	public User registSelectByEmail(String email);
}
