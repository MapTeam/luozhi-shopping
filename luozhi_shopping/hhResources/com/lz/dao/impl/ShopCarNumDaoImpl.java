package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.lz.dao.ShopCarNumDao;

public class ShopCarNumDaoImpl implements ShopCarNumDao{

	@Override
	public int selectShopCardNumDao(Connection conn,int uid) {
		int num=0;
		String sql="SELECT COUNT(*) FROM goodscargoods WHERE uid=?";
		PreparedStatement ps=null;
		try {
			 ps=conn.prepareStatement(sql);
			 ps.setInt(1, uid);
			 ResultSet rs=ps.executeQuery();
			 if (rs.next()) {
				 num=rs.getInt("COUNT(*)");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}		
		return num;
	}

}
