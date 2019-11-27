package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.ClassifyDao;
import com.lz.pojo.Goods;

public class ClassifyDaoImpl implements ClassifyDao {

	@Override
	public List<String> selectTypeByCategory1(Connection conn,int category1) {
		List<String> tnames = new ArrayList<String>();
		String sql = "SELECT tname FROM `type` WHERE category1 = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				tnames.add(rs.getString("tname"));
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
		return tnames;
	}

	@Override
	public List<Goods> selectGoodsByCategory1(Connection conn,int category1,int start,int size) {
		List<Goods> goods = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods WHERE category1 = ? ORDER BY hot LIMIT ?,?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category1);
			ps.setInt(2, start);
			ps.setInt(3, size);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Goods good = new Goods();
				good.setCategory1(rs.getInt("category1"));
				good.setCategory2(rs.getInt("category2"));
				good.setGbrand(rs.getString("gbrand"));
				good.setGcolorid(rs.getInt("gcolorid"));
				good.setGcount(rs.getInt("gcount"));
				good.setGgrade(rs.getInt("ggrade"));
				good.setGid(rs.getInt("gid"));
				good.setGintroduce(rs.getString("gintroduce"));
				good.setGmaterial(rs.getString("gmaterial"));
				good.setGname(rs.getString("gname"));
				good.setGpicture(rs.getString("gpicture"));
				good.setGprice(rs.getFloat("gprice"));
				good.setHot(rs.getInt("hot"));
				good.setZpicture(rs.getString("zpicture"));
				goods.add(good);
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
		return goods;
	}

	@Override
	public List<String> selectGbrandByCategory1(Connection conn,int category1) {
		List<String> brands = new ArrayList<String>();
		String sql = "SELECT gbrand FROM goods WHERE category1 = ? GROUP BY gbrand ORDER BY hot";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				brands.add(rs.getString("gbrand"));
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
		return brands;
	}

}
