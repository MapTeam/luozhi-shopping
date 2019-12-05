package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lz.dao.GoodsColorDao;
import com.lz.pojo.GoodsColor;

public class GoodsColorDaoImpl implements GoodsColorDao {
	private static final Logger log = Logger.getLogger(GoodsColorDaoImpl.class);
	/**
	 * 商品查询颜色
	 * @param conn
	 * @param gid
	 * @return
	 */
	@Override
	public List<GoodsColor> selectColor(Connection conn,int gid) {
		List<GoodsColor> gcolors = new ArrayList<GoodsColor>();
		String sql = "select * from goodscolor where gid = ? ";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
		return gcolors;
	}

}
