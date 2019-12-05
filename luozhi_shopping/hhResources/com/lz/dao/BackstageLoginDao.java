package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Admincount;

public interface BackstageLoginDao {
	public Admincount selectPasswordByuserame(Connection conn,String username);
	
}
