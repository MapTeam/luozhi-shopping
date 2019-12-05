package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lz.dao.GoodsParticularDao;
import com.lz.db.DBConnection1;

public class GoodsParticularDaoImpl implements GoodsParticularDao{
	private static final Logger log = Logger.getLogger(GoodsParticularDaoImpl.class);
	@Override
	public int selectGcigByUid(Connection conn,int uid) {
		int gcid=0;
		String sql ="select gcid from goodscar where uid=?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				gcid=rs.getInt("gcid");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		return gcid;
	}
	
}
