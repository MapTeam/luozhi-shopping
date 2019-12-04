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
	public List<Goods> getHomeGoods(Connection conn,int start,int num) {
		if(num==0){
			num = 20;
		}
		List<Goods> gs = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods ORDER BY hot DESC LIMIT ?,?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, num);
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
		}finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return gs;
	}

	@Override
	public List<Goods> getHotGoods(Connection conn) {
		List<Goods> hs= new ArrayList<Goods>();	
		String sql = "SELECT * FROM goods ORDER BY hot DESC LIMIT 0,16";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
				hs.add(goods);
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
		return hs;
		
	}

	@Override
	public List<Goods> getRecommandGoods(Connection conn) {
		List<Goods> res = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods ORDER BY  RAND() LIMIT 20;";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
				res.add(goods);
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
		return res;

	}

	@Override
	public List<Goods> getIpGoods(Connection conn) {
		List<Goods> Is = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods where category1=1008002";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
				Is.add(goods);
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
		return Is;
	}

	@Override
	public List<Goods> getShuMaGoods(Connection conn) {
		List<Goods> sms = new ArrayList<Goods>();
		String sql = "SELECT * FROM goods where category1=101000";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
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
				sms.add(goods);
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
		return sms;
	}

}
