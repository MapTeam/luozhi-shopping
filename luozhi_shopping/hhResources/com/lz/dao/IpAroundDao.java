package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.pojo.Goods;
import com.lz.pojo.Type;

public interface IpAroundDao {
	public List<Type> selectTypeTitleByIpAroundId(Connection conn);
	public List<Goods> selectLittleTitleByIpAroundId(Connection conn);
	public List<Goods> selectAllGoodsByIpAroundId(Connection conn,int pageNo,int pageSize);
	public int selectMaxPageNo(Connection conn,int pageSize);
}
