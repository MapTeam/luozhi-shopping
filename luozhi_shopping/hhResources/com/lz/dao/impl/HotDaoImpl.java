package com.lz.dao.impl;
/**
 * 热门商品
 */
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lz.dao.HotDao;
import com.lz.db.DBConnection1;
import com.lz.pojo.Goods;

public class HotDaoImpl implements HotDao{
	private static final Logger log = Logger.getLogger(HotDaoImpl.class);
	@Override
	public List<Goods> selectHot() {
		List<Goods> list=new ArrayList<Goods>();
		Connection conn=DBConnection1.getConnection();
		String sql="select * from goods order by hot desc LIMIT 0,40";
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
				list.add(goods);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}finally{
			DBConnection1.close(conn);
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		return list;
	}

}
