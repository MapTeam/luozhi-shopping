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
	public List<Type> selectTypeByCategory1(Connection conn,int category1);
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
	/**
	 * 根据页面显示的条数获得最大的页数
	 * @param conn
	 * @param pageSize
	 * @return
	 */
	public int selectMaxPageNo(Connection conn,int category1,int pageSize);
	/**
	 * 动态sql条件查询
	 * @param conn
	 * @param gbrand
	 * @param type
	 * @param sort
	 * @param category1
	 * @param min
	 * @param max
	 * @param pageNo
	 * @return
	 */
	public List<Goods> selectGoods(Connection conn,String gbrand,String type,String sort,String category1,String min,String max,String pageNo);
	/**
	 * 动态sql条件查询条数
	 * @param conn
	 * @param gbrand
	 * @param type
	 * @param category1
	 * @param min
	 * @param max
	 * @return
	 */
	public int selectGoodsCount(Connection conn,String gbrand,String type,String category1,String min,String max);
}
