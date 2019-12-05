package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lz.dao.IntroduceDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.GoodsIntroduceImg;

public class IntroduceDaoImpl implements IntroduceDao {
	private static final Logger log = Logger.getLogger(IntroduceDaoImpl.class);
	/**
	 * 获取商品的介绍
	 * @param conn
	 * @param gid
	 * @return
	 */
	@Override
	public GoodsIntroduceImg selectGoodsIntroduce(Connection conn, int gid) {
		GoodsIntroduceImg gii = new GoodsIntroduceImg();
		String sql = "select * from goodsintroduceimg where gid = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				gii.setGiid(rs.getInt("giid"));
				gii.setGid(rs.getInt("gid"));
				gii.setIntroduceImgs(rs.getString("introduceimgs"));
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
		return gii;
	}

}
