package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.GoodsColor;

public interface GoodsColorDao {
	/**
	 * 商品查询颜色
	 * @param conn
	 * @param gid
	 * @return
	 */
	public List<GoodsColor> selectColor(Connection conn,int gid);
}
