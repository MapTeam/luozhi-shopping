package com.lz.dao;

import java.util.List;

import com.lz.pojo.Goods;

public interface HomeDao {
	public List<Goods> getHomeGoods();
	public List<Goods> getHotGoods();
	public List<Goods> getRecommandGoods();
	public List<Goods> getIpGoods();
	public List<Goods> getShuMaGoods();
	
	
}
