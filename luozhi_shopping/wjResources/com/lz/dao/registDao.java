package com.lz.dao;

import java.util.List;

import com.lz.dto.GoodsOrderDto;
import com.lz.pojo.User;

public interface registDao {
	public boolean registSelectByName(String name);
	public User registSelectByEmail(String email);
	public List<GoodsOrderDto> selectAllOrderByOrSta();
}