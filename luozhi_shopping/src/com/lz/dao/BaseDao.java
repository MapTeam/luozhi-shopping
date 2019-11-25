package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Address;

public interface BaseDao {
	/**
	 * 插入一条数据
	 * @param conn
	 * @param obj
	 * @return
	 */
	public boolean insertObject(Connection conn,Object obj);
	/**
	 * 通过id删除
	 * @param conn
	 * @param obj
	 * @return
	 */
	public boolean deleteObjectById(Connection conn,Object obj);
	/**
	 * 通过id更新
	 * @param conn
	 * @param obj
	 * @return
	 */
	public boolean updateObjectById(Connection conn,Object obj);
	/**
	 * 查询所有
	 * @param conn 
	 * @param c 
	 * @return
	 */
	public List<Object> selectAllObject(Connection conn,Class c);
	/**
	 * 通过id查询
	 * @param conn
	 * @param obj
	 * @return
	 */
	public Object selectObjectById(Connection conn,Object obj);
}
