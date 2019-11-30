package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.ShopCurrentDao;
import com.lz.dto.OrderInputGoods;
import com.lz.pojo.Address;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;

public class ShopCurrentDaoImpl implements ShopCurrentDao{

	@Override
	public OrderInputGoods selectGoodsInformationByGcolorid(Connection conn,int gcolorid) {
		OrderInputGoods oig=new OrderInputGoods();
		String sql="SELECT a.* , b.* FROM goods a ,goodscolor b WHERE a.gid = b.gid AND b.gcolorid = ?";
		PreparedStatement ps=null;
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, gcolorid);
			ResultSet rs=ps.executeQuery();
			if (rs.next()) {
				Goods goods =new Goods();
				GoodsColor gcolor=new GoodsColor();
				goods.setCategory1(rs.getInt("category1"));
				goods.setCategory2(rs.getInt("category2"));
				goods.setGbrand(rs.getString("gbrand"));
				goods.setGcolorid(gcolorid);
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
				GoodsColor goodscolor=new GoodsColor();
				goodscolor.setColortype(rs.getString("colortype"));
				goodscolor.setGcolorid(gcolorid);
				goodscolor.setGid(rs.getInt("gid"));
				goodscolor.setGoodscount(rs.getInt("goodscount"));
				goodscolor.setGoodspicture(rs.getString("goodspicture"));
				oig.setGoods(goods);
				oig.setGoodscolor(goodscolor);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(ps!=null&&ps.isClosed()){
					ps.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return oig;
	}

	@Override
	public List<Address> selectUserAddressByUid(Connection conn, int uid) {
		List<Address> list=new ArrayList<Address>();
		String sql="select * from address where uid=?";
		PreparedStatement ps=null;		
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs =ps.executeQuery();
			while (rs.next()) {
				Address address=new Address();
				address.setAddressid(rs.getInt("addressid"));
				address.setCity(rs.getString("city"));
				address.setDetail(rs.getString("detail"));
				address.setIsdefault(rs.getInt("isdefault"));
				address.setName(rs.getString("name"));
				address.setProvince(rs.getString("province"));
				address.setTel(rs.getString("tel"));
				address.setUid(rs.getInt("uid"));
				address.setVillage(rs.getString("village"));
				list.add(address);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
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
		return list;
	}
	
}