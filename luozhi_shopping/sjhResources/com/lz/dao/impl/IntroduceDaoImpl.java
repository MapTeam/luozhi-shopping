package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.IntroduceDao;
import com.lz.pojo.GoodsIntroduceImg;

public class IntroduceDaoImpl implements IntroduceDao {

	@Override
	public GoodsIntroduceImg selectGoodsIntroduce(Connection conn, int gid) {
		GoodsIntroduceImg gii = new GoodsIntroduceImg();
		String sql = "select * from goods_introduce_img where gid = ?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				gii.setGiid(rs.getInt("giid"));
				gii.setGid(rs.getInt("gid"));
				gii.setIntroduceImgs(rs.getString("introduce_imgs"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gii;
	}

}
