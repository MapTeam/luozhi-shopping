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
import com.lz.dto.GoodsOrdergoodDto;
import com.lz.pojo.GoodsOrder;
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
				if (conn!=null && !conn.isClosed()) {
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
				if (conn!=null && !conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return u;
	}


//未发货
	@Override
	public List<GoodsOrderDto> selectAllOrderByOrSta(int status) {
		List<GoodsOrderDto> list=new ArrayList<GoodsOrderDto>();
		Connection conn=DBConnection1.getConnection();
		String sql="SELECT * FROM goodsorder a,address b,`user` c WHERE gostate = ?  AND a.addressid = b.addressid AND a.uid = c.uid ";
		GoodsOrderDto goodsorder=null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, status);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				goodsorder=new GoodsOrderDto();
				goodsorder.setAddressid(rs.getInt("addressid"));//
				goodsorder.setGostate(rs.getInt("gostate"));//
				goodsorder.setGoname(rs.getString("goname"));//
				goodsorder.setUid(rs.getInt("uid"));//
				goodsorder.setGodate(rs.getDate("godate").toString());//
				goodsorder.setCity(rs.getString("city"));//
				goodsorder.setCredits(rs.getInt("credits"));//
				goodsorder.setDetail(rs.getString("detail"));//
				goodsorder.setEmail(rs.getString("email"));//
				goodsorder.setTel(rs.getString("tel"));//
				goodsorder.setProvince(rs.getString("province"));//
				goodsorder.setVillage(rs.getString("village"));//
				goodsorder.setGoid(rs.getInt("goid"));
				goodsorder.setName(rs.getString("name"));
				goodsorder.setUname(rs.getString("uname"));
				goodsorder.setReason(rs.getString("reason"));
				list.add(goodsorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && !conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}
	
	public List<GoodsOrdergoodDto> selectAllGoodsByOrSta(int goid) {
		List<GoodsOrdergoodDto> list = new ArrayList<GoodsOrdergoodDto>();
		Connection conn = DBConnection1.getConnection();
		String sql = "SELECT * FROM goods a,goodscolor b,goodsordergcolor c WHERE c.`goid` = ? AND c.`gcolorid` = b.`gcolorid` AND b.`gid` = a.`gid`";
		GoodsOrdergoodDto goodsorder = null;
		try {
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, goid);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				goodsorder=new GoodsOrdergoodDto();
				goodsorder.setColortype(rs.getString("colortype"));
				goodsorder.setGbrand(rs.getString("gbrand"));
				goodsorder.setGcolorid(rs.getInt("gcolorid"));
				goodsorder.setGid(rs.getInt("gid"));
				goodsorder.setGintroduce(rs.getString("gintroduce"));
				goodsorder.setGname(rs.getString("gname"));
				goodsorder.setGoodsnum(rs.getInt("goodsnum"));
				goodsorder.setGoodspicture(rs.getString("goodspicture"));
				goodsorder.setGoodscount(rs.getInt("goodscount"));//
				list.add(goodsorder);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && !conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
			
		}
		return list;
	}


//	更改状态码
	@Override
	public boolean selectBySoid(int id,int status) {
		Connection conn=DBConnection1.getConnection();
		String sql="update goodsorder set gostate =? where goid=? ";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, status);
			ps.setInt(2, id);
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && !conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


////    通过状态码查询退款订单
//	@Override
//	public List<GoodsBackDto> selectOrderByOrsta(int status) {
//		Connection conn=DBConnection1.getConnection();
//		String sql="SELECT * FROM goodsorder a,goodscolor c,goods g where gostate = ? and  a.gcolorid=c.gcolorid and c.gid=g.gid";
//		List<GoodsBackDto> backlist=new ArrayList<GoodsBackDto>();
//		GoodsBackDto go=null;
//		try {
//			PreparedStatement ps=conn.prepareStatement(sql);
//			ps.setInt(1, status);
//			ResultSet rs=ps.executeQuery();
//			while (rs.next()) {
//				go=new GoodsBackDto();
//				go.setGoodspicture(rs.getString("goodspicture"));
//				go.setGname(rs.getString("gname"));
//				go.setGid(rs.getInt("gid"));
//				go.setGoodsnum(rs.getInt("goodsnum"));
//				go.setReason(rs.getString("reason"));
//				go.setGoid(rs.getInt("goid"));
//				backlist.add(go);
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}finally {
//			try {
//				if (conn!=null && !conn.isClosed()) {
//					DBConnection1.close(conn);
//				}
//			} catch (SQLException e) {
//				e.printStackTrace();
//			}
//		}
//		return backlist;
//	}


//插入拒绝原因
	@Override
	public boolean insertRefuseReasonById(String msg,int id,int status) {
		Connection conn=DBConnection1.getConnection();
		String sql="UPDATE goodsorder SET refusereason = ?,gostate = ? WHERE goid=?";
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, msg);
			ps.setInt(2, status);
			ps.setInt(3, id);
			int i=ps.executeUpdate();
			if (i>0) {
				return true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				if (conn!=null && !conn.isClosed()) {
					DBConnection1.close(conn);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}


}
