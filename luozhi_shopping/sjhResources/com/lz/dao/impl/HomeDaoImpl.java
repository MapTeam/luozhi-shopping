package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.HomeDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;

public class HomeDaoImpl implements HomeDao {

	@Override
	public List<Goods> getHomeGoods() {
		List<Goods> gs = new ArrayList<Goods>();
		Connection conn = DBConnection1.getConnection();
		String sql = "SELECT * FROM goods ORDER BY hot DESC LIMIT 0,20";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Goods goods = new Goods();
				goods.setCategory1(rs.getInt("category1"));
				goods.setCategory2(rs.getInt("category2"));
				goods.setGbrand(rs.getString("gbrand"));
				goods.setGcolorid(rs.getInt("gcolorid"));
				goods.setGcount(rs.getInt("gcount"));
				goods.setGgrade(rs.getInt("ggrade"));
				goods.setGid(rs.getInt("gid"));
				goods.setGintroduce(rs.getString("gintroduce"));
				goods.setGmaterial(rs.getString("gmaterial"));
				goods.setGname(rs.getString("gname"));
				goods.setGpicture(rs.getString("gpicture"));
				goods.setGprice(rs.getFloat("gprice"));
				goods.setHot(rs.getInt("hot"));
				goods.setZpicture(rs.getString("zpicture"));
				gs.add(goods);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return gs;
	}

}
