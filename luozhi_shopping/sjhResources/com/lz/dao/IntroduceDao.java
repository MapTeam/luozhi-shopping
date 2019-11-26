package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.GoodsIntroduceImg;

public interface IntroduceDao {
	public GoodsIntroduceImg selectGoodsIntroduce(Connection conn,int gid);
}
