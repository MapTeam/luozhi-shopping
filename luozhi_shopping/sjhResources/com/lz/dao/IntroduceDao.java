package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.GoodsIntroduceImg;

public interface IntroduceDao {
	/**
	 * 获取商品的介绍
	 * @param conn
	 * @param gid
	 * @return
	 */
	public GoodsIntroduceImg selectGoodsIntroduce(Connection conn,int gid);
}
