package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.GoodsColorDao;
import com.lz.pojo.GoodsColor;

public class GoodsColorDaoImpl implements GoodsColorDao {

	@Override
	public List<GoodsColor> selectColor(Connection conn,int gid) {
		List<GoodsColor> gcolors = new ArrayList<GoodsColor>();
		String sql = "select * from goods_color where gid = ? ";
		
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, gid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				GoodsColor gcolor = new GoodsColor();
				gcolor.setGcolorid(rs.getInt("gcolorid"));
				gcolor.setGid(rs.getInt("gid"));
				gcolor.setColortype(rs.getString("colortype"));
				gcolor.setGoodspicture(rs.getString("goodspicture"));
				gcolor.setGoodscount(rs.getInt("goodscount"));
				gcolors.add(gcolor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gcolors;
	}

}
