package com.lz.dao.impl;
/**
 * 查找库存
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.log4j.Logger;

import com.lz.dao.ShopCarNumDao;
import com.lz.db.DBConnection1;

public class ShopCarNumDaoImpl implements ShopCarNumDao{
	private static final Logger log = Logger.getLogger(ShopCarNumDaoImpl.class);
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
			log.error(e);
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error(e);
			}
		}		
		return num;
	}

}
