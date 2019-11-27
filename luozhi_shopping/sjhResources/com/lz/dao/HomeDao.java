package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Goods;

public interface HomeDao {
	public List<Goods> getHomeGoods(Connection conn,int start,int num);
	public List<Goods> getHotGoods(Connection conn);
	public List<Goods> getRecommandGoods(Connection conn);
	public List<Goods> getIpGoods(Connection conn);
	public List<Goods> getShuMaGoods(Connection conn);
	
	
}
