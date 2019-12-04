package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.dto.GoodsOrderDto;
import com.lz.dto.GoodsOrdergoodDto;
import com.lz.pojo.User;

public interface registDao {
	public boolean registSelectByName(String name);
	public User registSelectByEmail(String email);
	public List<GoodsOrderDto> selectAllOrderByOrSta(int status);
	public boolean selectBySoid(int soid,int status);
	public boolean insertRefuseReasonById(String msg,int id,int status);
	public List<GoodsOrdergoodDto> selectAllGoodsByOrSta(String goname);
	public List<GoodsOrderDto> selectUserOrderByStaAndUid(int uid,int status);
	public List<GoodsOrderDto> selectUserOrderByuid(int uid);
	public boolean insertOutGoodsOrder(Connection conn,String outgoodsname,int uid,String receiveaddress,String tel);
	public boolean updateGoodOrder(Connection conn,String outgoodname, int status,int goid);
	public List<GoodsOrderDto> selectOrderByOrSta(int status);
	public boolean updateUserReason(int status,int goid,String msg);//插入申请退款原因
}
