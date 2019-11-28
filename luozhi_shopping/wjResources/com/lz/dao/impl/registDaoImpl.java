package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.registDao;
import com.lz.db.DBConnection1;
import com.lz.dto.GoodsOrderDto;
import com.lz.pojo.User;
import com.lz.util.FinalType;

public class registDaoImpl implements registDao{

	@Override
	public boolean registSelectByName(String sname) {
		Connection conn=DBConnection1.getConnection();
		String sql="select * from user where uname=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, sname);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return false;
	}



	@Override
	public User registSelectByEmail(String email) {
		Connection conn=DBConnection1.getConnection();
		User u = null;
		String sql="select * from user where email=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, email);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				u = new User();
				u.setCredits(rs.getInt("credits"));
				u.setEmail(rs.getString("email"));
				u.setRegistdate(rs.getDate("registdate"));
				u.setUid(rs.getInt("uid"));
				u.setUname(rs.getString("uname"));
				u.setUpicture(rs.getString("upicture"));
				u.setUpwd(rs.getString("upwd"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return u;
	}



	@Override
	public List<GoodsOrderDto> selectAllOrderByOrSta() {
		List<GoodsOrderDto> list=new ArrayList<GoodsOrderDto>();
		Connection conn=DBConnection1.getConnection();
		String sql="SELECT * from goodsorder a,address b,goodscolor c,goods d,`user` e where gostate = ? and a.gcolorid = c.gcolorid and a.addressid = b.addressid and c.gid = d.gid and a.uid = e.uid";
		GoodsOrderDto goodsorder=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, FinalType.NOSHIPPED);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				goodsorder=new GoodsOrderDto();
				goodsorder.setGoid(rs.getInt("goid"));
				goodsorder.setGoname(rs.getString("goname"));
				goodsorder.setGcolorid(rs.getInt("gcolorid"));
				goodsorder.setUid(rs.getInt("uid"));
				goodsorder.setOutgoodid(rs.getInt("outgoodid"));
				goodsorder.setGoodsnum(rs.getInt("goodsnum"));
				goodsorder.setAddressid(rs.getInt("addressid"));
				goodsorder.setGostate(rs.getInt("gostate"));
				goodsorder.setGodate(rs.getDate("godate"));
				goodsorder.setCity(rs.getString("city"));
				goodsorder.setColortype(rs.getString("colortype"));
				goodsorder.setCredits(rs.getInt("credits"));
				goodsorder.setDetail(rs.getString("detail"));
				goodsorder.setEmail(rs.getString("email"));
				goodsorder.setGcolorid(rs.getInt("gcolorid"));
				goodsorder.setGid(rs.getInt("gid"));
				goodsorder.setGintroduce(rs.getString("gintroduce"));
				goodsorder.setGname(rs.getString("gname"));
				goodsorder.setGoid(rs.getInt("goid"));
				goodsorder.setGoodscount(rs.getInt("goodscount"));
				goodsorder.setGoodspicture(rs.getString("goodspicture"));
				goodsorder.setUname(rs.getString("uname"));
				goodsorder.setName(rs.getString("name"));
				goodsorder.setGoodscount(rs.getInt("goodscount"));
				list.add(goodsorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
}