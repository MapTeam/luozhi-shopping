package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Goods;

public interface LikeSelectDao {
	public List<Goods> selectGoodsByKey(String key,int pageNo,int pageSize);
	public int selectMaxPageNo(String key,int pageSize);
}
