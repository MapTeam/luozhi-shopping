package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.GoodsColor;

public interface GoodsColorDao {
	public List<GoodsColor> selectColor(Connection conn,int gid);
}
