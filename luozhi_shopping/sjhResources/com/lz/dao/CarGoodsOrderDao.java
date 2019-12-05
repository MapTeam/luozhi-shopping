package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.dto.CarOrderInputGoods;
import com.lz.pojo.Address;

public interface CarGoodsOrderDao {
	/**
	 * 查询所勾商品信息
	 * @return
	 */
	public List<CarOrderInputGoods> selectOrderInputGood(Connection conn,List<Integer> gcgids);
	/**
	 * 通过uid查询所有的Addrss
	 * @return
	 */
	public List<Address> selectUserAddressByUid(Connection conn,int uid);
}
