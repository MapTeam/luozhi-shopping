package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.CarGoodsOrderDao;
import com.lz.dto.CarOrderInputGoods;
import com.lz.dto.OrderInputGoods;
import com.lz.pojo.Address;
import com.lz.pojo.Goods;
import com.lz.pojo.GoodsColor;
/**
 * CarGoodsOrderDao实现类
 * @author sjh
 *
 */
public class CarGoodsOrderDaoImpl implements CarGoodsOrderDao {

	/**
	 * 移除购物车商品
	 * @return
	 */
	@Override
	public boolean removeCarGood(Connection conn) {
		return false;
	}

	/**
	 * 查询商品信息
	 * @return
	 */
	@Override
	public List<CarOrderInputGoods> selectOrderInputGood(Connection conn,List<Integer> gcgids) {
		List<CarOrderInputGoods> coigs = new ArrayList<CarOrderInputGoods>();
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT a.`goodsnum`,b.*,c.* FROM goodscargoods a,goodscolor b,goods c WHERE a.`gcolorid`=b.`gcolorid` AND b.`gid`=c.`gid` AND ( 1=2 ");
		for (int i = 0; i < gcgids.size(); i++) {
			sb.append("OR a.`gcgid` = ? ");
		}
		sb.append(")");
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sb.toString());
			for (int i = 0; i < gcgids.size(); i++) {
				ps.setInt(i+1, gcgids.get(i));
			}
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				CarOrderInputGoods coig = new CarOrderInputGoods();
				GoodsColor goodscolor = new GoodsColor();
				Goods goods = new Goods();
				goodscolor.setColortype(rs.getString("colortype"));
				goodscolor.setGcolorid(rs.getInt("gcolorid"));
				goodscolor.setGid(rs.getInt("gid"));
				goodscolor.setGoodscount(rs.getInt("goodscount"));
				goodscolor.setGoodspicture(rs.getString("goodspicture"));
				
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
				
				coig.setGoodscount(rs.getInt("goodsnum"));
				coig.setGoods(goods);
				coig.setGoodscolor(goodscolor);
				coigs.add(coig);
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
		return coigs;
	}

	/**
	 * 通过uid查询所有的Addrss
	 * @return
	 */
	@Override
	public List<Address> selectUserAddressByUid(Connection conn,int uid) {
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
