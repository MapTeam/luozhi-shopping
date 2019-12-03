package com.lz.dao.impl;
/**
 * 模糊查询
 */
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
		StringBuffer sql=new StringBuffer();
		sql.append("select * from goods where 1=1 ");
		if (key!=null&&!"".equals(key)) {
			for (int i = 0; i < key.length(); i++) {
				sql.append(" AND gname like ?");
			}
		}
		
		sql.append(" limit ?,?");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql.toString());
			if (key!=null&&!"".equals(key)) {
				char[] keyarr = key.toCharArray();
				for (int i = 0; i < keyarr.length; i++) {
					ps.setString(i+1, "%"+keyarr[i]+"%");
				}
				ps.setInt(keyarr.length+1, (pageNo-1)*pageSize);
				ps.setInt(keyarr.length+2, pageSize);
			}else {
				ps.setInt(1, (pageNo-1)*pageSize);
				ps.setInt(2, pageSize);
			}
			
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
			DBConnection1.close(conn);
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
	public int selectMaxPageNo(String key,int pageSize) {
		Connection conn = DBConnection1.getConnection();
		int count = 0;//总记录数
		PreparedStatement ps = null;
		try {
			String sql = "select count(*) from goods where gname like ?";
			ps =conn.prepareStatement(sql);
			ps.setString(1, "%"+key+"%");
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBConnection1.close(conn);
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
		
}
