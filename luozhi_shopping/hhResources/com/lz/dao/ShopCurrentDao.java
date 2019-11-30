package com.lz.dao;

import java.sql.Connection;
import java.util.List;

import com.lz.dto.OrderInputGoods;
import com.lz.pojo.Address;

public interface ShopCurrentDao {
		public OrderInputGoods selectGoodsInformationByGcolorid(Connection conn,int gcolorid);
		public List<Address> selectUserAddressByUid(Connection conn,int uid);
}
