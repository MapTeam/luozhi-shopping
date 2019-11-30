package com.lz.dao;

import java.util.List;

import com.lz.dto.GoodsBackDto;
import com.lz.dto.GoodsOrderDto;
import com.lz.dto.GoodsOrdergoodDto;
import com.lz.pojo.User;

public interface registDao {
	public boolean registSelectByName(String name);
	public User registSelectByEmail(String email);
	public List<GoodsOrderDto> selectAllOrderByOrSta(int status);
	public boolean selectBySoid(int soid,int status);
	public List<GoodsBackDto> selectOrderByOrsta(int status);
	public boolean insertRefuseReasonById(String msg,int id);
	public List<GoodsOrdergoodDto> selectAllGoodsByOrSta(int goid);
}
