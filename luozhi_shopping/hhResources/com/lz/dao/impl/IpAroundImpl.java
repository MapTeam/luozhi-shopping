package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.IpAroundDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;
import com.lz.pojo.Type;

public class IpAroundImpl implements IpAroundDao{

	@Override
	public List<Type> selectTypeTitleByIpAroundId(Connection conn) {
		List<Type> list=new ArrayList<Type>();
		String sql="select tname,category2 from type where category1=1008002";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Type type =new Type();
				type.setTname(rs.getString("tname"));
				type.setCategory2(rs.getInt("category2"));
				list.add(type);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	@Override
	public List<Goods> selectAllGoodsByIpAroundId(Connection conn,int pageNo,int pageSize) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select * from goods where category1=1008002 LIMIT ?,?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, (pageNo-1)*pageSize);
			ps.setInt(2, pageSize);
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
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return list;
	}
	
	/**
	 * 根据页面显示的条数获得最大的页数
	 */
	@Override
	public int selectMaxPageNo(Connection conn,int pageSize) {
		int count = 0;//总记录数
		PreparedStatement ps = null;
		try {
			String sql = "select count(*) from goods where category1=1008002";
			ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}

	@Override
	public List<Goods> selectLittleTitleByIpAroundId(Connection conn) {
		List<Goods> list =new ArrayList<Goods>();
		String sql="select gbrand from goods WHERE category1=1008002 GROUP BY gbrand";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				Goods good=new Goods();
				good.setGbrand(rs.getString("gbrand"));
				list.add(good);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
