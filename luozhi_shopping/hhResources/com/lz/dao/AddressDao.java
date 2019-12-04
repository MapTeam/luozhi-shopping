package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Address;

public interface AddressDao {
	public boolean insertFirstDefault(Connection conn,int addressid);
}
