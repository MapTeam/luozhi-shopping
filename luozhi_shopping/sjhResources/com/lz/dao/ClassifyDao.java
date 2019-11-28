package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Goods;
import com.lz.pojo.Type;

public interface ClassifyDao {
	/**
	 * 通过category1查询type
	 * @return
	 */
	public List<String> selectTypeByCategory1(Connection conn,int category1);
	/**
	 * 通过category1查询Goods
	 * @return
	 */
	public List<Goods> selectGoodsByCategory1(Connection conn,int category1,int start,int size);
	/**
	 * 通过category1查询Gbrand去重
	 * @return
	 */
	public List<String> selectGbrandByCategory1(Connection conn,int category1);

}
