package com.lz.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lz.dao.GoodsCarDao;
import com.lz.pojo.Goods;
import com.lz.pojo.User;

import com.lz.dto.GoodsCarDTO;
 public class GoodsCarDaoImpl implements GoodsCarDao{

	@Override
	public List<GoodsCarDTO> getGoodsCarDTO(Connection conn,User user) {
		List<GoodsCarDTO>  goodsCarDTO= new ArrayList<GoodsCarDTO>();
		 int uid=user.getUid();
		String sql = "SELECT d.*,e.*,c.gcgid,c.goodsnum FROM `user` a,goodscar b,goodscargoods c,goodscolor d,goods e WHERE a.`uid` = b.`uid` AND c.`gcid`=b.`gcid` AND d.`gcolorid` = c.`gcolorid` AND d.`gid` = e.`gid` AND a.`uid` = ?";
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, uid);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
			   GoodsCarDTO g=new GoodsCarDTO();
               g.setCategory2(rs.getInt("category2"));
               g.setColortype(rs.getString("colortype"));
               g.setGbrand(rs.getString("gbrand"));
               g.setGintroduce(rs.getString("gintroduce"));
               g.setGname(rs.getString("gname"));
               g.setGpicture(rs.getString("gpicture"));
               g.setGprice(rs.getFloat("gprice"));
               g.setZpicture(rs.getString("zpicture"));
               g.setGoodsnum(rs.getInt("goodsnum"));
               g.setGcgid(rs.getInt("gcgid"));
			   goodsCarDTO.add(g);
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
		
		return goodsCarDTO;
	}



}
