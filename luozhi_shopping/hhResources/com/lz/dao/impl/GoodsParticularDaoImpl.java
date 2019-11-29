package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.dao.GoodsParticularDao;

public class GoodsParticularDaoImpl implements GoodsParticularDao{

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
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gcid;
	}
	
}
