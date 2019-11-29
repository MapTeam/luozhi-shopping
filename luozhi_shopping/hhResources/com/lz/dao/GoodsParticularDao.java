package com.lz.dao;

import java.sql.Connection;

public interface GoodsParticularDao {
	public int selectGcigByUid(Connection conn,int uid);
}
