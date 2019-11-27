package com.lz.dao;

import java.util.List;

import com.lz.pojo.Type;

public interface TypeDao {
	/**
	 * 通过category1查询type
	 * @return
	 */
	public List<Type> selectTypeByCategory1();
}
