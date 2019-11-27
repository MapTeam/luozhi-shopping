package com.lz.dao.impl;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.LikeSelectDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;

public class LikeSelectDaoImpl implements LikeSelectDao{

	@Override
	public List<Goods> selectGoodsByKey(String key,int pageNo,int pageSize) {
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=DBConnection1.getConnection();
		String sql="select * from goods where gname like ? LIMIT ?,?";
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+key+"%");
			ps.setInt(2, (pageNo-1)*pageSize);
			ps.setInt(3, pageSize);
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
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBConnection1.close(conn);
		}
		return list;
	}
	/**
	 * 根据页面显示的条数获得最大的页数
	 */
	@Override
	public int selectMaxPageNo(String key,int pageSize) {
		Connection conn = DBConnection1.getConnection();
		int count = 0;//总记录数
		try {
			String sql = "select count(*) from goods where gname like ?";
			PreparedStatement ps =conn.prepareStatement(sql);
			ps.setString(1, "%"+key+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection1.close(conn);
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}
		
}
