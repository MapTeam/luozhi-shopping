package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.lz.dao.ClassifyDao;
import com.lz.pojo.Goods;
import com.lz.pojo.Type;

public class ClassifyDaoImpl implements ClassifyDao {
	private static final Logger log = Logger.getLogger(ClassifyDaoImpl.class);
	/**
	 * 通过category1查询type
	 * @return
	 */
	@Override
	public List<Type> selectTypeByCategory1(Connection conn,int category1) {
		List<Type> types = new ArrayList<Type>();
		String sql = "SELECT * FROM `type` WHERE category1 = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, category1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				Type type = new Type();
				type.setCategory1(rs.getInt("category1"));
				type.setCategory2(rs.getInt("category2"));
				type.setTid(rs.getInt("tid"));
				type.setTname(rs.getString("tname"));
				type.setTtid(rs.getInt("ttid"));
				types.add(type);
			}
		} catch (SQLException e) {
			e.printStackTrace();
			log.error(e);
		} finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		return types;
	}
	
	/**
	 * 通过category1查询Goods
	 * @return
	 */
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
		return goods;
	}

	/**
	 * 通过category1查询Gbrand去重
	 * @return
	 */
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
		return brands;
	}
	
	/**
	 * 根据页面显示的条数获得最大的页数
	 * @param conn
	 * @param pageSize
	 * @return
	 */
	@Override
	public int selectMaxPageNo(Connection conn,int category1,int pageSize) {
		int count = 0;//总记录数
		PreparedStatement ps = null;
		try {
			String sql = "select count(*) from goods where category1=?";
			ps =conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
			log.error(e);
		}finally{
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
				log.error(e);
			}
		}
		return count%pageSize==0 ? count/pageSize : count/pageSize+1;
	}
	
	/**
	 * 动态sql条件查询
	 * @param conn
	 * @param gbrand
	 * @param type
	 * @param sort
	 * @param category1
	 * @param min
	 * @param max
	 * @param pageNo
	 * @return
	 */
	@Override
	public List<Goods> selectGoods(Connection conn,String gbrand,String type,String sort,String category1,String min,String max,String pageNo) {
		List<Goods> goods = new ArrayList<Goods>();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT * FROM goods WHERE 1=1 ");
		if(gbrand!=null&&!"".equals(gbrand)){
			sb.append("AND gbrand = ? ");
		}
		if(type!=null&&!"".equals(type)){
			sb.append("AND category2 = ? ");
		}
		if(min!=null&&!"".equals(min)){
			sb.append("AND gprice > ? ");
		}
		if(max!=null&&!"".equals(max)){
			sb.append("AND gprice < ? ");
		}
		if(category1!=null&&!"".equals(category1)){
			sb.append("AND category1 = ? ");
		}
		if(sort!=null&&!"".equals(sort)){
			if("价格低到高".equals(sort)){
				sb.append("ORDER BY gprice ASC ");
			}
			if("价格高到低".equals(sort)){
				sb.append("ORDER BY gprice DESC ");
			}
		}
		if(pageNo!=null&&!"".equals(pageNo)){
			sb.append("LIMIT ?,20");
		}
		PreparedStatement ps = null;
		int i=0;
		try {
			ps = conn.prepareStatement(sb.toString());
			if(gbrand!=null&&!"".equals(gbrand)){
				ps.setString(++i, gbrand);
			}
			if(type!=null&&!"".equals(type)){
				ps.setInt(++i, Integer.parseInt(type));
			}
			if(min!=null&&!"".equals(min)){
				ps.setInt(++i, Integer.parseInt(min));
			}
			if(max!=null&&!"".equals(max)){
				ps.setInt(++i, Integer.parseInt(max));
			}
			if(category1!=null&&!"".equals(category1)){
				ps.setInt(++i, Integer.parseInt(category1));
			}
			if(pageNo!=null&&!"".equals(pageNo)){
				ps.setInt(++i, (Integer.parseInt(pageNo)-1)*20);
			}
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
		return goods;
	}
	
	/**
	 * 动态sql条件查询条数
	 * @param conn
	 * @param gbrand
	 * @param type
	 * @param category1
	 * @param min
	 * @param max
	 * @return
	 */
	@Override
	public int selectGoodsCount(Connection conn,String gbrand,String type,String category1,String min,String max) {
		int count = 0;
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT count(*) FROM goods WHERE 1=1 ");
		if(gbrand!=null&&!"".equals(gbrand)){
			sb.append("AND gbrand = ? ");
		}
		if(type!=null&&!"".equals(type)){
			sb.append("AND category2 = ? ");
		}
		if(category1!=null&&!"".equals(category1)){
			sb.append("AND category1 = ? ");
		}
		if(min!=null&&!"".equals(min)){
			sb.append("AND gprice > ? ");
		}
		if(max!=null&&!"".equals(max)){
			sb.append("AND gprice < ? ");
		}
		
		PreparedStatement ps = null;
		int i=0;
		try {
			ps = conn.prepareStatement(sb.toString());
			if(gbrand!=null&&!"".equals(gbrand)){
				ps.setString(++i, gbrand);
			}
			if(type!=null&&!"".equals(type)){
				ps.setInt(++i, Integer.parseInt(type));
			}
			if(category1!=null&&!"".equals(category1)){
				ps.setInt(++i, Integer.parseInt(category1));
			}
			if(min!=null&&!"".equals(min)){
				ps.setInt(++i, Integer.parseInt(min));
			}
			if(max!=null&&!"".equals(max)){
				ps.setInt(++i, Integer.parseInt(max));
			}
			ResultSet rs = ps.executeQuery();
			if(rs.next()){
				count = rs.getInt("count(*)");
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
		return count%20==0 ? count/20 : count/20+1;
	}
}
