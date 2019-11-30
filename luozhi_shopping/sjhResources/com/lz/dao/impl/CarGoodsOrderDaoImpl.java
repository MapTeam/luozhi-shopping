package com.lz.dao.impl;

import java.sql.Connection;
import java.util.List;

import com.lz.dao.CarGoodsOrderDao;
import com.lz.dto.OrderInputGoods;
import com.lz.pojo.Address;
/**
 * CarGoodsOrderDao实现类
 * @author sjh
 *
 */
public class CarGoodsOrderDaoImpl implements CarGoodsOrderDao {

	@Override
	public boolean removeCarGood(Connection conn) {
		return false;
	}

	@Override
	public OrderInputGoods selectOrderInputGood(Connection conn) {
		return null;
	}

	@Override
	public List<Address> selectUserAddressByUid(Connection conn) {
		return null;
	}

}
